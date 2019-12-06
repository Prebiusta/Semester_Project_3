using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy = "MustBeUser")]
    public class BacklogController : CustomController
    {
        private int sprintId;
        public IActionResult Index(int sprintId)
        {
            this.sprintId = sprintId;
            var list = GetUserStories(sprintId).Result;
            var result = JsonConvert.DeserializeObject<List<UserStory>>(list);
            ContainerForListAndId<UserStory> containerForListAndId = new ContainerForListAndId<UserStory>(result, sprintId);
            return View("~/Views/Project/Backlog/Index.cshtml", containerForListAndId);
        }

        public IActionResult AddUserStory(int sprintId)
        {
            return View("~/Views/Project/Backlog/AddUserStory.cshtml", sprintId);
        }

        public IActionResult PostUserStory()
        {
            string priority = Request.Form["priority"];
            string description = Request.Form["description"];
            int difficulty = int.Parse(Request.Form["difficulty"]);
            int sprintId = int.Parse(Request.Form["sprintId"]);
            //TODO
            int productBacklogId = 1;
            //-----------------------
            UserStory userStory = new UserStory(-1, productBacklogId, priority, description, difficulty, "ongoing");
            var response = AddUserStoryRequest(userStory).Result;
            if(response.IsSuccessStatusCode)
            {
                return Index(sprintId);
            }
            ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
            return Index(sprintId);
        }
        
        public IActionResult DeleteUserStory(UserStory userStory)
        {
            var response = DeleteUserStoryRequest(userStory.userStoryId).Result;
            if (response.IsSuccessStatusCode)
            {
                return Index(sprintId);
            }

            return Index(sprintId);
        }

        public IActionResult BacklogFromLastSprint(int projectId)
        {
            // that doesn't worj first we have to figure out which sprint is the newest and get user stories for that spring'
            return Index(projectId);
        }

        private async Task<string> GetUserStories(int projectId) {
            var content = await GetJsonData("api/userStory?backlogId="+projectId);
            return content;
        }
        
        private async Task<HttpResponseMessage> AddUserStoryRequest(UserStory userStory) {
            var httpContent = await PostData(userStory, "api/userStory");
            return httpContent;
        }
        
        private async Task<HttpResponseMessage> DeleteUserStoryRequest(int userStoryId) {
            var httpContent = await PostData(userStoryId, "api/usersInProjectDelete=");
            return httpContent;
        }

        private async Task<HttpResponseMessage> GetProductBacklogId(int sprintId)
        {
            var httpContent = await PostData(sprintId, "api/sprintId=" + sprintId);
            return httpContent;
        } 
    }
}
