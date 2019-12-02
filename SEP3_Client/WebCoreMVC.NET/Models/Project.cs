﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Project {
        public int projectId { get; set; }
        public int backlogID { get; set; }

        [Required(ErrorMessage = "Please insert the name of your project")]
        [StringLength(100, MinimumLength = 1, ErrorMessage = "Min 1 letter, maximum 100")]
        public string name { get; set; }

        public string status { get; set; }

        [Required(ErrorMessage = "Please define how many iterations are you planning to have")]
        public int numberOfIterations { get; set; }

        [Required(ErrorMessage = "Please define length of your sprints")]
        public int lengthOfSprint { get; set; }
    }
}