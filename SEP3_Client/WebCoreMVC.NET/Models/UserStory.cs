namespace WebCoreMVC.NET.Models {
    public class UserStory {
        public int userStoryId { get; set; }
        public int projectBacklogId { get; set; }
        public string priority { get; set; }
        public string description { get; set; }
        public int difficulty { get; set; }
        public string status { get; set; }
    }
}