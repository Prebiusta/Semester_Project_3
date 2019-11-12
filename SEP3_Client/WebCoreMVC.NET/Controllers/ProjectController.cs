using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace WebCoreMVC.NET.Controllers {
    public class ProjectController: CustomController {


        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Projects()
        {
            string list = GetProjects().Result;
            List<Models.Project> result = JsonConvert.DeserializeObject<List<Models.Project>>(list);
            return View(result);
        }

        public async Task<string> GetProjects()
        {
            var content = await GetJsonData("api/project");
            return content;
        }
    }
}
