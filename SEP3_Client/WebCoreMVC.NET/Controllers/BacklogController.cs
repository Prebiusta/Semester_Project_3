using System;
using System.Collections.Generic;
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

        public IActionResult AddUserStory(string userStory, int projectBacklogId)
        {
            var response = AddUserStoryRequest(userStory, projectBacklogId).Result;
            if (response.IsSuccessStatusCode)
            {
                
            }

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
        
        private async Task<HttpResponseMessage> AddUserStoryRequest(string userStory, int id) {
            var httpContent = await PostData(userStory, "api/userStory=" + "&sprintId=" + id);
            return httpContent;
        }
        
        private async Task<HttpResponseMessage> DeleteUserStoryRequest(int userStoryId) {
            var httpContent = await PostData(userStoryId, "api/usersInProjectDelete=");
            return httpContent;
        }
    }
}
