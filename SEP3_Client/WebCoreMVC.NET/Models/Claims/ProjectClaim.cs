﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebCoreMVC.NET.Controllers;

namespace WebCoreMVC.NET.Models.Claims {
    public class ProjectClaim {
        public int projectId { get; set; }
        public bool isAdministrator { get; set; }
        public List<SprintClaim> sprintClaims { get; set; }
        public List<Administrator> administrators { get; set; }

        public ProjectClaim()
        {
            sprintClaims = new List<SprintClaim>();
            administrators = new List<Administrator>();
        }

        public ProjectClaim(int projectId, List<Administrator> administrators)
        {
            this.projectId = projectId;
            this.administrators = administrators;
            isUserAdministrator();
        }

        public void isUserAdministrator()
        {
            foreach(Administrator administrator in administrators)
            {
                if(administrator.Equals(CustomController.username))
                {
                    isAdministrator = true;
                }
            }
            isAdministrator = false;
        }

        public void addSprintClaim(SprintClaim sprintClaim)
        {
            foreach(SprintClaim sprintClaim1 in sprintClaims)
            {
                if(sprintClaim1.sprintId == sprintClaim.sprintId)
                {
                    sprintClaims.Remove(sprintClaim1);
                }
            }
            sprintClaims.Add(sprintClaim);
        }

        
    }
}