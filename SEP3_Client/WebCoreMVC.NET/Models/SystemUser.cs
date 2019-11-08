using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class SystemUser {
        [Required(ErrorMessage = "Please insert your username")]
        public string username { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime dateJoined { get; set; }
        public DateTime birthday { get; set; }
        public String profilePicture { get; set; }
        [DataType(DataType.Password)]
        [Required(ErrorMessage = "Insert your password")]
        public string Password { get; set; }
        private List<Project> projects { get; set; }

        public SystemUser(string username, string password, string firstName, string lastName, DateTime birthday, DateTime dateJoined, String profilePicture) {
            this.username=username;
            this.Password=password;
            this.FirstName=firstName;
            this.LastName=lastName;
            this.birthday=birthday;
            this.dateJoined=dateJoined;
            this.profilePicture=profilePicture;
        }

        public List<Project> getProjectsCompleted() {
            List<Project> completedProjects = new List<Project>();
            foreach(var project in projects) {
                if(project.Equals("Completed")) {
                    completedProjects.Add(project);
                }
            }
            return completedProjects;
        }

        public List<Project> getWorkingProjects() {
            List<Project> workingProjects = new List<Project>();

            foreach(var project in projects) {
                if(project.getStatus().Equals("Working")) {
                    workingProjects.Add(project);
                }
            }
            return workingProjects;
        }

        public List<Project> getAllProjects() {
            return projects;
        }
    }
}
