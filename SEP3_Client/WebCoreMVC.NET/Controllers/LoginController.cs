using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers
{
    public class LoginController : CustomController {
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Register()
        {
            return RedirectToAction("Index", "Register");
        }

        [HttpPost]
        public IActionResult Authorization(LogginUser user)
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
           
        
            if (ModelState.IsValid)
            {
                string result = SendLoginData(user).Result;
                if (result.Equals("OK"))
                {
                    return RedirectToAction("Index", "Home");
                } else if(result.Equals("Working"))
                {
                    ModelState.AddModelError(string.Empty, "WORKING");
                    return View("Index");
                }
                else
                {
                    ModelState.AddModelError(string.Empty, "Server is not answering");
                    return View("Index");
}
            }
            else
            {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return View("Index");
            }
        }
        private async Task<string> SendLoginData(LogginUser user)
{
            //Remember to hash password here before creating an instance of the user
            string userJson = JsonConvert.SerializeObject(user);
            var content = new StringContent(userJson.ToString(), Encoding.UTF8, "application/json");
            var response = await client.PostAsync(serverAPIurl + "auth/login", content);
            //This if statement will be more specific after implementing server HTTP calls
            if (response.StatusCode == HttpStatusCode.OK)
            {
                //Return system user with all the data: name, birthday etc
                //string systemUserJson = await response.Content.ReadAsStringAsync();
                //SystemUser systemUser = (SystemUser)JsonConvert.DeserializeObject(systemUserJson);
                return "OK";
            }
            else if(response.StatusCode == HttpStatusCode.BadRequest)
            {
                //That means server actually responded with 400
                return "Working";
            } else
            {
                //No server at all simply error
                return "ERROR";
            }
}
    }
}