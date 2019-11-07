package hello.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "date_joined")
    private Date dateJoined;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "profile_picture")
    private String profilePicture;

    public User(){

    }

    public User(String firstName, String password, String lastName, String username, Date dateJoined, Date birthday, String profilePicture) {
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.username = username;
        this.dateJoined = dateJoined;
        this.birthday = birthday;
        this.profilePicture = profilePicture;
    }

    public long getUserId() {
        return userId;
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

    public String getUsername() {
        return username;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
