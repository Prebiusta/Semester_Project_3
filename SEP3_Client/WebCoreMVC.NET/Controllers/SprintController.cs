﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy= "MustBeUser")]
    public class SprintController : CustomController {
        private int projectId;
        public IActionResult Index(int projectId) {
            this.projectId = projectId;
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

        public IActionResult SprintBacklog(IDcontainer idContainer)
        {
            var list = GetSprintUSerStories(idContainer.sprintId).Result;
            var result = JsonConvert.DeserializeObject<List<SprintUserStory>>(list);
            ContainerForListAndId<SprintUserStory> containerForListAndId = new ContainerForListAndId<SprintUserStory>(result, idContainer.sprintId);
            ViewData.Add("projectId", idContainer.projectId);
            return View("~/Views/Project/Sprint/Backlog/Index.cshtml", containerForListAndId);
        }

        public IActionResult DeleteUserStory(DeleteSprintUserStory deleteSprintUserStory)
        {
            var response = DeleteUserStoryFromSprint(deleteSprintUserStory.userStoryId).Result;
            return SprintBacklog(new IDcontainer(deleteSprintUserStory.projectId, deleteSprintUserStory.sprintId));
        }

        public string AssignUserStoryToSprintJS(AssignUserStory assignUserStory)
        {
            var content = AssignUserStoryToSprint(assignUserStory).Result;
            if (content.IsSuccessStatusCode)
            {
                return "{\"status\":\"ok\"}";
            }
            return "{\"status\":\"error\"}";
        }
        public string GetUserStoriesNotAssignedToTheSprintJS(int sprintID)
        {
            Debug.WriteLine("!!!!!!!!!!!!! " + sprintID);
            var content = GetUserStoriesNotAssignedToTheSprint(sprintID).Result;
            return content;
        }

        //removeUserStory

        private async Task<HttpResponseMessage> DeleteUserStoryFromSprint(int userStoryID)
        {
            var content = await DeleteData("api/userStory?sprintId" + userStoryID);
            return content;
        }

        private async Task<string> GetUserStoriesNotAssignedToTheSprint(int sprintId)
        {
            var content = await GetJsonData("api/userStory?sprintId=" + sprintId);
            return content;
        }

        private async Task<string> GetSprints(int projectId) {
            var content = await GetJsonData("api/sprint?projectId=" + projectId + "&username=" + username);
            return content;
        }

        private async Task<HttpResponseMessage> SendSprintData(Sprint sprint) {
            var httpContent = await PostData(sprint, "api/createSprint");
            return httpContent;
        }

        private async Task<string> GetSprintUSerStories(int sprintId)
        {
            var httpContent = await GetJsonData("api/sprintUserStory?sprintId=" + sprintId);
            return httpContent;
        }

        private async Task<HttpResponseMessage> AssignUserStoryToSprint(AssignUserStory assignUserStory)
        {
            var httpContent = await PostData(assignUserStory, "api/sprintUserStory");
            return httpContent;
        }
    }
}