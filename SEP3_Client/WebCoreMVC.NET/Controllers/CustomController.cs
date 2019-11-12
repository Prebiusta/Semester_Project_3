using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace WebCoreMVC.NET.Controllers {
    public class CustomController : Controller {
        //All controllers are reusing the same http client and server ip so there is no need to create them multiple times
        protected readonly HttpClient client = new HttpClient();
        protected readonly string serverUrl = "http://" + "10.152.204.51" + ":8080/";
    
        public async Task<HttpResponseMessage> PostData(Object data, string PostWhere)
        {
                string json = JsonConvert.SerializeObject(data);
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await client.PostAsync(serverUrl + PostWhere, content);
                return response;
        }

        public async Task<string> GetJsonData(string GetFromWhere)
        {
            Task<string> getStringTask = client.GetStringAsync("http://" + serverUrl + ":8080/");
            string content = await getStringTask;
            return content;
        }


        public static string GetSha256(string text)
        {
            if (text == null)
            {
                return string.Empty;
            }

            byte[] message = System.Text.Encoding.ASCII.GetBytes(text);
            byte[] hashValue = GetSha256(message);

            string hashString = string.Empty;
            foreach (byte x in hashValue)
            {
                hashString += string.Format("{0:x2}", x);
            }
            return hashString;

        }

        private static byte[] GetSha256(byte[] message)
        {
            SHA256Managed hashString = new SHA256Managed();
            return hashString.ComputeHash(message);
        }
    }
}
