using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebCoreMVC.NET.Models.Claims;

namespace WebCoreMVC.NET.Models {
    public class ClientData {
        public List<ProjectClaim> projectClaims { get; set; }
        
        public ClientData()
        {
            projectClaims = new List<ProjectClaim>();
        }

        public void addProjectClaim(ProjectClaim projectClaim)
        {
            foreach (ProjectClaim projectClaim1 in projectClaims)
            {
               if(projectClaim1.projectId == projectClaim.projectId)
                {
                    projectClaims.Remove(projectClaim1);
                }
            }
            projectClaims.Add(projectClaim);
        }
    }
}
