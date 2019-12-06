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
        public IActionResult Index(int projectId)
        {
            var list = GetUsersInProjects(projectId).Result;
            var result = JsonConvert.DeserializeObject<List<UserWithName>>(list);
            ContainerForListAndId<UserWithName> containerForListAndId = new ContainerForListAndId<UserWithName>(result, projectId);
            return View("~/Views/Project/Members/Index.cshtml",containerForListAndId);
        }

        public IActionResult AddMember(int projectId) {
            var list = GetAllUsers().Result;
            var result = JsonConvert.DeserializeObject<List<UserWithName>>(list);
            ContainerForListAndId<UserWithName> containerForListAndId = new ContainerForListAndId<UserWithName>(result, projectId);
            return View("~/Views/Project/Members/AddMember.cshtml", containerForListAndId);
        }

        public IActionResult DeleteMember(UserProject user)
        {
            var result = DeleteMemberRequest(user).Result;
            if (result.IsSuccessStatusCode)
            {
                return Index(user.projectId);
            }
            else
            {
                ModelState.AddModelError(string.Empty, "Server sent a bad request: " + result.Content);
                return Index(user.projectId);
            }
        }

        [HttpPost]
        public IActionResult PostMember(UserProject user) {
            if(ModelState.IsValid) {
                var response = SendMemberData(user).Result;
                switch(response.StatusCode) {
                    case HttpStatusCode.OK:
                        return RedirectToAction("Index", "Members");
                    case HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return AddMember(user.projectId);
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return AddMember(user.projectId);
                }
            }

            ModelState.AddModelError(string.Empty, "Please insert the necessary data");
            return AddMember(user.projectId);
        }

        public async Task<HttpResponseMessage> SendMemberData(UserProject user) {
            var httpContent = await PostData(user, "api/addUser");
            return httpContent;
        }
        
        public async Task<HttpResponseMessage> DeleteMemberRequest(UserProject user) {
            var httpContent = await PostData(user, "api/removeUser");
            return httpContent;
        }

        public async Task<string> GetUsersInProjects(int projectId) {
            Console.WriteLine("api/usersInProjects?projectId=" + projectId);
            var content = await GetJsonData("api/usersInProject?projectId=" + projectId);
            return content;
        }
        public async Task<string> GetAllUsers() {
            var content = await GetJsonData("api/usersOutsideProject");
            return content;
        }
    }
}
