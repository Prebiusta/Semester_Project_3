using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    //[Authorize(Policy = "MustBeUser")]
    public class ProjectController : CustomController {
        public IActionResult Index() {
            var list = GetProjects().Result;
            var result = JsonConvert.DeserializeObject<List<Project>>(list);
            foreach(Project project in result)
            {
                clientData.addProjectClaim(new Models.Claims.ProjectClaim(project.projectId, project.admins));
            }
            return View(result);
        }
        
        public IActionResult Members(int id) {
            var list = GetUsersInProjects(id).Result;
            var result = JsonConvert.DeserializeObject<List<User>>(list);
            return View(result);
        }

            //public IActionResult ProjectBacklog(int id)
            //{
    //            var list = GetProjectBacklog(id).Result;
    //            var result = JsonConvert.DeserializeObject<List<ProjectBacklog>>(list);
    //            return View(result);
            //}

            public IActionResult UserStories(int id)
            {
                var list = GetUserStories(id).Result;
                var result = JsonConvert.DeserializeObject<List<UserStory>>(list);
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

        public async Task<string> GetProjects() {
            var content = await GetJsonData("api/project?username=" + username);
            return content;
        }

        public async Task<HttpResponseMessage> SendProjectData(Project projects) {
            var httpContent = await PostData(projects, "api/createProject?username=" + username);
            return httpContent;
        }
        
        public async Task<string> GetUsersInProjects(int id) {
            var content = await GetJsonData("api/users_in_projects?projectId=" + id);
            return content;
        }

        public async Task<string> GetProjectBacklog(int id)
        {
            var content = await GetJsonData("api/projectBacklog?projectId=" + id);
            return content;
        }

        public async Task<string> GetUserStories(int id)
        {
            var content = await GetJsonData("api/userStory?projectBacklogId=" + id);
            return content;
        }
    }
}