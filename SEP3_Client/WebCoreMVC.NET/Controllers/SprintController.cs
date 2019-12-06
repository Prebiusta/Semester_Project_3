using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy= "MustBeUser")]
    public class SprintController : CustomController {
        public IActionResult Index(int projectId) {
            var list = GetSprints(projectId).Result;
            var result = JsonConvert.DeserializeObject<List<Sprint>>(list);
            ContainerForListAndId<Sprint> containerForListAndId = new ContainerForListAndId<Sprint>(result, projectId);
            sprints = containerForListAndId;
            return View("~/Views/Project/Sprint/Index.cshtml", sprints);
        }

        public IActionResult PlanSprint(Sprint sprint) {
            return View("~/Views/Project/Sprint/PlanSprint.cshtml", sprint);
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
                        return PlanSprint(sprint);
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return PlanSprint(sprint);
                }
            }
            else {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return PlanSprint(sprint);    
            }
        }

        private async Task<string> GetSprints(int projectId) {
            var content = await GetJsonData("api/sprint?projectId=" + projectId + "&username=" + username);
            return content;
        }

        private async Task<HttpResponseMessage> SendSprintData(Sprint sprint) {
            var httpContent = await PostData(sprint, "api/createSprint");
            return httpContent;
        }
    }
}