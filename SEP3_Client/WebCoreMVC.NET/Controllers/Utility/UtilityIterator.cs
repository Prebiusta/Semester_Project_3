using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebCoreMVC.NET.Models;

namespace WebCoreMVC.NET.Controllers.Utility {
    public class UtilityIterator {

        public List<Project> assignAdministrators(List<Project> projects, string username)
        {
            foreach(Project project in projects)
            {
                foreach(string admin in project.admins)
                {
                    if(admin.Equals(username))
                    {
                        project.isAdministrator = true;
                    }
                }
            }
            return projects;
        }

        public List<Sprint> assignRoles(List<Sprint> sprints, string username)
        {
            foreach(Sprint sprint in sprints)
            {
                if(sprint.productOwnerUsername.Equals(username))
                {
                    sprint.isProductOwner = true;
                }
                if(sprint.scrumMasterUsername.Equals(username))
                {
                    sprint.isScrumMaster = true;
                }
            }
            return sprints;
        }
    }
}
