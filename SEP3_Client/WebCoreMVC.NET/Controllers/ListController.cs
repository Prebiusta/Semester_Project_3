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
        private readonly HttpClient client = new HttpClient();
        private readonly string serverIp = "10.152.204.82";
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Person()
        {
            List<Person> people = new List<Person>();
            Person person = new Person("Borys", "Birthday", "Male", "Bottle of vodka");
            Person person2 = new Person("Roxanne", "12.02.1992", "Female", "200 euro per hour");
            people.Add(person);
            people.Add(person2);
            return View(people);
        }

        public IActionResult Tasks()
        {
            string list = GetAllTasks().Result;
            List<Models.Task> result = JsonConvert.DeserializeObject<List<Models.Task>>(list);         
            return View(result);
        }

        /*
        public async Task<ActionResult> GetTasks()
        {
            
            Task<ActionResult> task = null;
            HttpResponseMessage responseMessage = await client.GetAsync("http://10.152.204.8:8080/api/task");
            if(responseMessage.IsSuccessStatusCode)
            {
                task = await responseMessage.Content.ReadAsStreamAsync();
            }
            return task;
            
            return null;
        }
        */

        public async Task<string> GetAllTasks()
        {
            /*
            var task = await client.GetStringAsync("http://192.168.87.103:8080/api/task");
            string json = JsonConvert.SerializeObject(task);
            List<Models.Task> result = JsonConvert.DeserializeObject<Dictionary<string, Models.Task>>(json)
            .Select(x => x.Value)
            .ToList();
            return result;
            */
            Task<string> getStringTask = client.GetStringAsync("http://" + serverIp + ":8080/api/task");
            string content = await getStringTask;

            return content;
        }
    }
}