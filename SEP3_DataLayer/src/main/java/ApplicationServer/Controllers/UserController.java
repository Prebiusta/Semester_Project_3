package ApplicationServer.Controllers;

import ApplicationServer.JPA.UserRepository;
import ApplicationServer.Model.User;
import ApplicationServer.Model.UsersInProjects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Return all users from the database.
     * EXAMPLE
     *  http://{host}:6969/api/users
     *
     * @return <i>HTTP 200 - OK</i> code with list of users. Returns <i>HTTP 400 - BAD_REQUEST</i> with error message if error occurred.
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {

        // Private class UserPublicInfo defining the part of User class which is sent out of the database.
        class UserPublicInfo{
            private String username;
            private String firstName;
            private String lastName;

            public UserPublicInfo(String username, String firstName, String lastName) {
                this.username = username;
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }

        try {
            var usersFromDb = userRepository.findAll();
            ArrayList<UserPublicInfo> allUsers = new ArrayList<>();

            for (User user : usersFromDb) {
                allUsers.add(new UserPublicInfo(user.getUsername(), user.getFirstName(), user.getLastName()));
            }

            return ResponseEntity.status(HttpStatus.OK).body(allUsers);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
