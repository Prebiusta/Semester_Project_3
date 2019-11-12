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
    public class RegisterController : CustomController
    {
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Register(SystemUser user)
        {
            if (ModelState.IsValid)
            {
                HttpResponseMessage response = SendRegisterData(user).Result;
                if (response.StatusCode == HttpStatusCode.OK)
                {
                    return RedirectToAction("Index", "Home");
                }
                else if (response.StatusCode == HttpStatusCode.BadRequest)
                {
                    ModelState.AddModelError(string.Empty, "Works but server gave bad request: " + response.Content);
                    return View("Index");
                } else
                {
                    ModelState.AddModelError(string.Empty, "Not connected to server at all");
                    return View("Index");
                }
            }
            else
            {
                ModelState.AddModelError(string.Empty, "Please insert the necessary data");
                return View();
            }
        }
        private async Task<HttpResponseMessage> SendRegisterData(SystemUser user)
        {
            //Remember to hash password here before creating an instance of the user
            string userJson = JsonConvert.SerializeObject(user);
            var content = new StringContent(userJson.ToString(), Encoding.UTF8, "application/json");
            var response = await client.PostAsync(serverAPIurl + "auth/register", content);
            //This if statement will be more specific after implementing server HTTP calls
            return response;
        }
    }  
}