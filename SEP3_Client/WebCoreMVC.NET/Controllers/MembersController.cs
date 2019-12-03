using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy = "MustBeUser")]
    public class MembersController : CustomController {
        public IActionResult Index(int id) {
            var list = GetUsersInProjects(id).Result;
            var result = JsonConvert.DeserializeObject<List<User>>(list);
            return View("~/Views/Project/Members/Index.cshtml",result);
        }

        public IActionResult AddMember() {
            return View("~/Views/Project/Members/AddMember.cshtml");
        }

        [HttpPost]
        public IActionResult PostMember(User user) {
            if(ModelState.IsValid) {
                var response = SendMemberData(user).Result;
                switch(response.StatusCode) {
                    case HttpStatusCode.OK:
                        return RedirectToAction("Index", "Members");
                    case HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return AddMember();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return AddMember();
                }
            }

            ModelState.AddModelError(string.Empty, "Please insert the necessary data");
            return AddMember();
        }

        public async Task<HttpResponseMessage> SendMemberData(User user) {
            var httpContent = await PostData(user, "api/usersInProject=" + username);
            return httpContent;
        }

        public async Task<string> GetUsersInProjects(int id) {
            var content = await GetJsonData("api/usersInProjects?projectId=" + id);
            return content;
        }
    }
}
