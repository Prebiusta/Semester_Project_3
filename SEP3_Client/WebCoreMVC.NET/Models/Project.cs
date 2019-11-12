using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Project {
        public int projectId { get; set; }
        public string name { get; set; }
        public string status { get; set; }
        public int numberOfIterations { get; set; }
        public int lengthOfSprint { get; set; }
    }
}
