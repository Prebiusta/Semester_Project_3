package ApplicationServer.Controllers;

import ApplicationServer.JPA.UserRepository;
import ApplicationServer.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/auth")
public class AuthenticationController {
    private UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //region Register POST
    /**
     * Register user method, processing data in JSON form sent from Client site of the system. Register user to the system database
     * in case all the conditions ale fulfilled. Returns HTTP Response Status with code '400 Bad Request' or '200 OK' and relevant
     * message so client can react accordingly
     *
     * JSON Template
     * {
     * 	    "username": "username",
     * 	    "password": "password",
     *      "firstName": "firstName",
     *      "lastName": "lastName",
     *      "birthday": "YYYY-MM-DD",
     *      "dateJoined": "YYYY-MM-DD",
     *      "profilePicture": "profilePicture"
     * }
     *
     * @param user User object parsed from JSON format received from Client
     * @return HTTP Response Status with Relevant message
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        // Checks if the username already exists in the database
        // In case some result is returned, skip the body
        if (userRepository.findByUsername(user.getUsername()) != null){
            // Returns HTTP Response Status with code '400 Bad Request' and relevant message so client can react accordingly
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username with username " + user.getUsername() + " already exists");
        }

        // Saves User object to database, if there is no error, HTTP Response Status with code '200 OK' and relevant message is returned to client
        if (userRepository.save(user) != null){
            return ResponseEntity.status(HttpStatus.OK).body("Account created");
        }

        // If anything above goes wrong,
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed");
    }
    //endregion

    //region Login POST
    /**
     * Method for login user. It is processing POST request with User object in format of JSON as an argument.
     * <p>
     *  Examples:
     *  http://<b>{host}</b>:8080/api/auth as a POST request with User object converted to JSON in a body.
     * </p>
     *
     * @param user User object in format of JSON
     * @return <i>HTTP 200 - OK</i> code if credentials are verified. Returns <i>HTTP 400 - BAD_REQUEST</i> if credentials are incorrect.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        if (isCorrectLogin(user.getUsername(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByUsername(user.getUsername()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    /**
     * Private method to verify if data in received JSON are matching data from the database.
     *
     * @param username from received JSON from Client
     * @param password from received JSON from Client
     * @return <i>true</i> if username and password matches. If it doesn't match or username is not found, return <i>false</i> .
     */
    private boolean isCorrectLogin(String username, String password) {
        System.out.println("Username: " + username);
        User user;
        try {
            user = userRepository.findByUsername(username);
        } catch (Exception e){
            return false;
        }

        if (user == null){
            return false;
        }

        return user.getPassword().equals(password);
    }
    //endregion
}
