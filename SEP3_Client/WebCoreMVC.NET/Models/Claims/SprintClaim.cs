using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebCoreMVC.NET.Controllers;

namespace WebCoreMVC.NET.Models.Claims {
    public class SprintClaim {
        public int sprintId { get; set; }
        public string role { get; set; }

        public SprintClaim(int sprintId, string productOwnerUsername, string scrumMasterUsername)
        {
            this.sprintId = sprintId;
            isScrumMaster(scrumMasterUsername);
            isProductOwner(productOwnerUsername);
        }
        public void isScrumMaster(string productOwnerUsername)
        {
            if(productOwnerUsername.Equals(CustomController.username))
            {
                role = "Scrum Master";
            }
        }

        public void isProductOwner(string scrumMasterUsername)
        {
            if(scrumMasterUsername.Equals(CustomController.username))
            {
                role = "Product Owner";
            }
        }
    }
}
