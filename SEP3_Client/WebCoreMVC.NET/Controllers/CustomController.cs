using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace WebCoreMVC.NET.Controllers {
    public class CustomController : Controller {
        //All controllers are reusing the same http client and server ip so there is no need to create them multiple times
        protected readonly HttpClient client = new HttpClient();
        protected readonly string serverAPIurl = "http://" + "10.152.204.51" + ":8080/";
    
    public async Task<HttpResponseMessage> PostData(Object data, string PostWhere)
        {
            string json = JsonConvert.SerializeObject(data);
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = await client.PostAsync(serverAPIurl + PostWhere, content);
            return response;
        }
    }
}
