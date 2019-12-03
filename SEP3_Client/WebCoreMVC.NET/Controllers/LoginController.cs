﻿using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Mvc;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers {
    
    public class LoginController : CustomController {

        public IActionResult Index() {
            return View("Index");
        }

        public IActionResult Register() {
            return RedirectToAction("Index", "Register");
        }

        [HttpPost]
        public IActionResult Authorization(LogginUser user) {
            if (ModelState.IsValid) {
                var response = SendLoginData(user).Result;
                switch (response.StatusCode) {
                    case HttpStatusCode.OK:
                        username = user.username;
                        AuthorizeLogin(username);
                        return RedirectToAction("Index", "Home");
                    case HttpStatusCode.BadRequest:
                        ModelState.AddModelError(string.Empty, "Server sent a bad request: " + response.Content);
                        return Index();
                    default:
                        ModelState.AddModelError(string.Empty, "Server is not answering");
                        return Index();
                }
            }

            ModelState.AddModelError(string.Empty, "Please insert the necessary data");
            return View("Index");
        }

        public async Task<HttpResponseMessage> SendLoginData(LogginUser user) {
            var password = user.password;
            var hashedValue = GetSha256(password);
            user.password = hashedValue;

            //Remember to hash password here before creating an instance of the user
            var httpContent = await PostData(user, "auth/login");
            return httpContent;
        }
        
        public async void AuthorizeLogin(string username) {

            var claims = new List<Claim>
            {
                new Claim("MustBeUser", username)
            };
            claims.Add(new Claim("MustBeUser", "MustBeUser"));
            claims.Add(new Claim(username, "MustBeUser"));
            var claimsIdentity = new ClaimsIdentity(claims, CookieAuthenticationDefaults.AuthenticationScheme);
            var principal = new ClaimsPrincipal(claimsIdentity);
            await HttpContext.SignInAsync(CookieAuthenticationDefaults.AuthenticationScheme, new ClaimsPrincipal(claimsIdentity));
            
        }
    }
}