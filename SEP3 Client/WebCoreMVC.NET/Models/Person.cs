using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebCoreMVC.NET.Models {
    public class Person {
        public string Name { get; set; }
        public string Birthday { get; set; }
        public string Gender { get; set; }
        public string Price { get; set; }
        public Person(string name, string birthday, string gender, string price)
        {
            Name = name;
            Birthday = birthday;
            Gender = gender;
            Price = price;
        }
    }
}
