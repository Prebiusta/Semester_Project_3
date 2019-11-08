using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers
{
    public class LoginController : Controller
    {
        private readonly HttpClient client = new HttpClient();
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Authorization(SystemUser user)
        {
            /*string orgMsg = "dickhead";
            string otherMsg = "ilovemymom";
            Console.WriteLine("HMAC SHA256 Demo in .NET");
            Console.WriteLine("----------------------");
            Console.WriteLine();
            var salt = MyHmac.GenerateSalt();
            var hmac1 = MyHmac.ComputeHMAC_SHA256(Encoding.UTF8.GetBytes(orgMsg), salt);
            var hmac2 = MyHmac.ComputeHMAC_SHA256(Encoding.UTF8.GetBytes(otherMsg), salt);
            Console.WriteLine("Hashing of " + "dickhead:{0}", Convert.ToBase64String(hmac1));
            Console.WriteLine("Hashing of " + "ilovemymom99:{0}", Convert.ToBase64String(hmac2));
            */
            if(ModelState.IsValid)
            {
                




                return RedirectToAction("Index", "Home");
            } else {           
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return View("Index");
            }

            //How to confuse a browser 101
            //return View("../Home/Index");
            
        }
    }
}