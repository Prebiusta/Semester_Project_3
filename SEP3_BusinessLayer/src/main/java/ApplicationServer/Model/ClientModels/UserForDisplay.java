package ApplicationServer.Model.ClientModels;

public class UserForDisplay {

    private String username;
    private String firstName;
    private String lastName;

    public UserForDisplay(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserForDisplay(String username) {
        this.username = username;
        this.firstName = "empty name";
        this.lastName = "empty surname";
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
