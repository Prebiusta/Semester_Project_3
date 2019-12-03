using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    public class UserStoryController : CustomController {
        public IActionResult Index(int id) {
            var list = GetUserStories(id).Result;
            var result = JsonConvert.DeserializeObject<List<UserStory>>(list);
            return View("~/Views/Project/UserStory/Index.cshtml", result);
        }

        public async Task<string> GetUserStories(int id) {
            var content = await GetJsonData("api/userStory?backlogId="+id);
            return content;
        }
    }
}
