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
            String password = user.password;
            String hashedValue = GetSha256(password);
            user.password=hashedValue;

            //Remember to hash password here before creating an instance of the user
            
            var variable = await PostData(user, "auth/login");
            return variable;
           
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