using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Sprint {
        public int projectId { get; set; }
        public int sprintId { get; set; }
        public int sprint_number { get; set; }
        public string date_started { get; set; }
        public string date_finished { get; set; }
        public int ProductOwnerId { get; set; }
        public int ScrumMasterId { get; set; }
        public String status { get; set; }
    }
}
