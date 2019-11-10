using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class SystemUser: LogginUser {
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string birthday { get; set; }
        public string dateJoined { get; set; }

        public string profilePicture { get; set; }


        public SystemUser(string username, string password, string firstName, string lastName, string birthday, string dateJoined, String profilePicture) {
            this.username=username;
            this.password=password;
            this.firstName=firstName;
            this.lastName=lastName;
            this.birthday=birthday;
            this.dateJoined=dateJoined;
            this.profilePicture=profilePicture;
        }

        public SystemUser(string username, string password)
        {
            this.username = username;
            this.password = password;
            this.firstName = "NotValeriusMom";
            this.lastName = "NotValeriusSister";
            this.birthday = "28-11-08";
            this.dateJoined = "12-03-2019";
            this.profilePicture = "hehehe nudes";
        }

       
    }
}
