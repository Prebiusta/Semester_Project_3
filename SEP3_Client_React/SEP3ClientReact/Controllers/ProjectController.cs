using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using SEP3ClientReact.Models;

namespace SEP3ClientReact.Controllers {
    [ApiController]
    [Route("[controller]")]
    public class ProjectController : ControllerBase {
        private readonly HttpClient client = new HttpClient();
        private readonly string serverIp = "192.168.87.103";
        private readonly ILogger<ProjectController> _logger;

        public ProjectController(ILogger<ProjectController> logger)
        {
            _logger = logger;
        }

        [HttpGet]
        public IEnumerable<Project> Get()
        {
            string projectsList = GetProjects().Result;
            List<Project> projects = JsonConvert.DeserializeObject<List<Models.Project>>(projectsList);
            return projects.ToArray();
            /*
            var rng = new Random();
            return Enumerable.Range(1, 5).Select(index => new WeatherForecast
            {
                Date = DateTime.Now.AddDays(index),
                TemperatureC = rng.Next(-20, 55),
                Summary = Summaries[rng.Next(Summaries.Length)]
            })
            .ToArray();
            */
        }

        public async Task<string> GetProjects()
        {
            Task<string> getProjects = client.GetStringAsync("http://" + serverIp + ":8080/api/project");
            string content = await getProjects;
            return content;
        }
    }
}
