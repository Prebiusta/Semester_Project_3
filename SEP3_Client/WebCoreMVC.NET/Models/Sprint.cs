using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Sprint {
        public int projectId { get; set; }
        public int sprintId { get; set; }
        public int sprintNumber { get; set; }
        public string dateStarted { get; set; }
        public string dateFinished { get; set; }
        public int productOwnerId { get; set; }
        public int scrumMasterId { get; set; }
        public String status { get; set; }
    }
}