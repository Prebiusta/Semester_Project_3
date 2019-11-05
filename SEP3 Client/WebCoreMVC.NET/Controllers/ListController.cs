using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers
{
    public class ListController : Controller
    {
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
    }
}