using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;
using Task = WebCoreMVC.NET.Models.Task;

namespace WebCoreMVC.NET.Controllers {
    [Authorize(Policy = "MustBeUser")]
    public class TasksController : CustomController {
        public IActionResult Index(int sprintId) {
            var list = GetTasks(sprintId).Result;
            var result = JsonConvert.DeserializeObject<List<Task>>(list);
            return View("~/Views/Project/Sprint/Tasks/Index.cshtml", result);
        }

        private async Task<string> GetTasks(int sprintId) {
            var content = await GetJsonData("api/task?sprintId=" + sprintId);
            return content;
        }    
    }
}