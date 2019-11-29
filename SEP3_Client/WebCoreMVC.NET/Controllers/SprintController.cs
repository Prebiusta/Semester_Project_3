using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    public class SprintController : CustomController {
        public IActionResult Index() 
        {
            string list = GetSprints().Result;
            List<Models.Sprint> result = JsonConvert.DeserializeObject<List<Models.Sprint>>(list);
            return View(result);
        }
        public IActionResult PlanSprint() 
        {
            return View("PlanSprint");
        }
        [HttpPost]
        public IActionResult PostSprint(Sprint sprint) {
            if(ModelState.IsValid) {
                HttpResponseMessage response = SendSprintData(sprint).Result;
                switch(response.StatusCode) {
                    case System.Net.HttpStatusCode.OK:
                        return RedirectToAction("Index", "Home");
                    case System.Net.HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: "+ response.Content);
                        return PlanSprint();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return PlanSprint();
                }
            } else {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return PlanSprint();
            }
        }

        public async Task<string> GetSprints() {
            var content = await GetJsonData("api/sprint");
            return content;
        }

        public async Task<HttpResponseMessage> SendSprintData(Sprint sprints) {
            var httpContent = await PostData(sprints, "api/createSprint");
            return httpContent;
        }
    }
}