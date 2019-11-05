using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class SystemUser {
        public long UserID { get; set; }
        [Required]
        [StringLength(250, MinimumLength = 3, ErrorMessage = "Min 3 letters")]
        public string Username { get; set; }
        [DataType(DataType.Password)]
        [Required]
        [StringLength(50, MinimumLength = 3, ErrorMessage = "Min 3, max 50 letters")]
        public string Password { get; set; }
    }
}
