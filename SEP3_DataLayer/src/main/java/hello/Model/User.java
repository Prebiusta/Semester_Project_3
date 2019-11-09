package hello.Model;

import javax.persistence.*;

/**
 *  Entity class referencing table in the database
 */
@Entity
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "date_joined")
    private String dateJoined;

    @Column(name = "profile_picture")
    private String profilePicture;

    public User() {

    }

    public User(String username, String password, String firstName, String lastName, String birthday, String dateJoined, String profilePicture) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.dateJoined = dateJoined;
        this.profilePicture = profilePicture;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.birthday = "birthday";
        this.dateJoined = "dateJoined";
        this.profilePicture = "profilePicture";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
