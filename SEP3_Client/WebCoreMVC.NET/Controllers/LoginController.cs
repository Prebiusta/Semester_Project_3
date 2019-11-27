using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Cryptography;
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
            return View("Index");
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
                switch(response.StatusCode)
                {
                    case System.Net.HttpStatusCode.OK:
                        username = user.username;
                        return RedirectToAction("Index", "Home");
                    case System.Net.HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return Index();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return Index();
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
            String password = user.password;
            String hashedValue = GetSha256(password);
            user.password = hashedValue;

            //Remember to hash password here before creating an instance of the user
            
            var httpContent = await PostData(user, "auth/login");
            return httpContent;
}
        

    }
}