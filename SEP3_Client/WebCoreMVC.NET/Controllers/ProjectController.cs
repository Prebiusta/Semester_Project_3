using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    public class ProjectController: CustomController {
        public IActionResult Index()
        {
            string list = GetProjects().Result;
            List<Models.Project> result = JsonConvert.DeserializeObject<List<Models.Project>>(list);
            return View(result);
        }

        public IActionResult CreateProject()
        {
            return View("CreateProject");
        }

        [HttpPost]
        public IActionResult PostProject(Project project)
        {
            if (ModelState.IsValid)
            {
                HttpResponseMessage response = SendProjectData(project).Result;
                switch(response.StatusCode)
                {
                    case System.Net.HttpStatusCode.OK:
                        return RedirectToAction("Index", "Project");
                    case System.Net.HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return CreateProject();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return CreateProject();

                }
            }
            else
            {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return CreateProject();
            }
        }

        public async Task<string> GetProjects()
        {
            var content = await GetJsonData("api/project");
            return content;
        }

        public async Task<HttpResponseMessage> SendProjectData(Project projects)
        {
            var httpContent = await PostData(projects, "api/createProject");
            return httpContent;
        }
    }
}
