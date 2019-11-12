using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers
{
    public class ListController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        /*
         * Tasks will come during next sprint
        public IActionResult Tasks()
        {
            string list = GetAllTasks().Result;
            List<Models.Task> result = JsonConvert.DeserializeObject<List<Models.Task>>(list);         
            return View(result);
        }

        public async Task<string> GetAllTasks()
        {
            Task<string> getStringTask = client.GetStringAsync("http://" + serverIp + ":8080/api/task");
            string content = await getStringTask;

            return content;
        }
        */
    }
}