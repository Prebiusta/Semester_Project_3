using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace WebCoreMVC.NET.Controllers {
    public class CustomController : Controller {
        protected readonly HttpClient client = new HttpClient();
        protected readonly string serverAPIurl = "http://" + "192.168.87.103" + ":8080/api/";
    }
}
