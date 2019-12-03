using System;
using System.Collections.Generic;
using System.Linq;
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

        public async Task<string> GetUsersInProjects(int id) {
            var content = await GetJsonData("api/usersInProjects?projectId=" + id);
            return content;
        }
    }
}
