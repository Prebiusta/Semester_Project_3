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
                return View("Index");
            }
        }

        private async Task<HttpResponseMessage> SendRegisterData(SystemUser user)
        {
            //Remember to hash password here before creating an instance of the user
            String password = user.password;
            String hashedValue = GetSha256(password);
            user.password = hashedValue;

            string userJson = JsonConvert.SerializeObject(user);
            var content = new StringContent(userJson.ToString(), Encoding.UTF8, "application/json");
            var response = await client.PostAsync(serverAPIurl + "auth/register", content);
            //This if statement will be more specific after implementing server HTTP calls
            return response;
        }

        public static string GetSha256(string text) {
            if(text==null) {
                return string.Empty;
            }

            byte[] message = System.Text.Encoding.ASCII.GetBytes(text);
            byte[] hashValue = GetSha256(message);

            string hashString = string.Empty;
            foreach(byte x in hashValue) {
                hashString+=string.Format("{0:x2}", x);
            }
            return hashString;
        }

        private static byte[] GetSha256(byte[] message) {
            SHA256Managed hashString = new SHA256Managed();
            return hashString.ComputeHash(message);
        }
    }  
}