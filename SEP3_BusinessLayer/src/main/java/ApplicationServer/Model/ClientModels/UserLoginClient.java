package ApplicationServer.Model.ClientModels;


public class UserLoginClient {

    private String username;
    private String password;

    public UserLoginClient() {

    }

    public UserLoginClient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + ", " + password;
    }
}
