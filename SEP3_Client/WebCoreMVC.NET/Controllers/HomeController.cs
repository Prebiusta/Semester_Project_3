using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    public class HomeController : Controller {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            Console.WriteLine(DateTime.Now);
            return View();
        }

        public IActionResult Privacy()
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

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
