using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Project {
        private List<SystemUser> userList { get; set; }
        private int numberOfIterations { get; set; }
        private String status { get; set; }

        public Project(List<SystemUser> userList, int numberOfIterations, String status) {
            this.userList=userList;
            this.numberOfIterations=numberOfIterations;
            this.status=status;
        }

        public List<SystemUser> getAdmins(List<SystemUser> userList) {
            List<SystemUser> admins = new List<SystemUser>();
            foreach(var user in userList) {
                admins.Add(user);
            }
            return admins;
        }

        public String getStatus() {
            return status;
        }
    }
}
