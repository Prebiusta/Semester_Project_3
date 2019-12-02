﻿using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    public class SprintController : CustomController {
  //      [Authorize(Policy = "MustBeUser")]
        public IActionResult Index(int id) { 
            var list = GetSprints(id).Result;
            var result = JsonConvert.DeserializeObject<List<Sprint>>(list);
            return View(result);
        }

        public IActionResult PlanSprint() {
            return View("PlanSprint");
        }

        [HttpPost]
        public IActionResult PostSprint(Sprint sprint) {
            if (ModelState.IsValid) {
                var response = SendSprintData(sprint).Result;
                switch (response.StatusCode) {
                    case System.Net.HttpStatusCode.OK:
                        return RedirectToAction("Index", "Home");
                    case System.Net.HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return PlanSprint();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return PlanSprint();
                }
            }
            else {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return PlanSprint();    
            }
        }

        public async Task<string> GetSprints(int id) {
            var content = await GetJsonData("api/sprint?projectId=" + id);
            return content;
        }

        public async Task<HttpResponseMessage> SendSprintData(Sprint sprints) {
            var httpContent = await PostData(sprints, "api/createSprint");
            return httpContent;
        }
    }
}