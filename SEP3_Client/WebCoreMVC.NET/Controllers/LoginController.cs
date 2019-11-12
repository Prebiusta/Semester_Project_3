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
            if (ModelState.IsValid)
            {
                HttpResponseMessage response = SendLoginData(user).Result;
                if (response.StatusCode == HttpStatusCode.OK)
                {
                    //Return system user with all the data: name, birthday etc
                    //string systemUserJson = await response.Content.ReadAsStringAsync();
                    //SystemUser systemUser = (SystemUser)JsonConvert.DeserializeObject(systemUserJson);
                    return RedirectToAction("Index", "Home");
                }
                else if (response.StatusCode == HttpStatusCode.BadRequest)
                {
                    //That means server actually responded with 400
                    ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                    return View("Index");
                }
                else
                {
                    //No server at all simply error
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
        private async Task<HttpResponseMessage> SendLoginData(LogginUser user)
{
            /*
            string password = user.password;
            string hashedPassword;
            user.password = hashedPassword;
            */
            //Remember to hash password here before creating an instance of the user
            
            var variable = await PostData(user, "auth/login");
            return variable;
           
        }
    }
}