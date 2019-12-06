﻿using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy = "MustBeUser")]
    public class ProjectController : CustomController {
        public IActionResult Index() {
            var list = GetProjectsByUsername().Result;
            var result = JsonConvert.DeserializeObject<List<Project>>(list);
            projects = result;
            return View(result);
        }

        public IActionResult CreateProject() {
            return View("CreateProject");
        }

        [HttpPost]
        public IActionResult PostProject(Project project) {
            if (ModelState.IsValid) {
                var response = SendProjectData(project).Result;
                switch (response.StatusCode) {
                    case HttpStatusCode.OK:
                        return RedirectToAction("Index", "Project");
                    case HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return CreateProject();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return CreateProject();
                }
            }

            ModelState.AddModelError(string.Empty, "Please insert the necessary data");
            return CreateProject();
        }

        private async Task<string> GetProjectsByUsername() {
            var content = await GetJsonData("api/project?username=" + username);
            return content;
        }
        private async Task<string> GetProjectsByStatus(string status)
        {
            var content = await GetJsonData("api/project?username=" + username + "&status=" + status);
            return content;
        }

        private async Task<HttpResponseMessage> SendProjectData(Project project) {
            var httpContent = await PostData(project, "api/createProject?username=" + username);
            return httpContent;
        }
    }
}