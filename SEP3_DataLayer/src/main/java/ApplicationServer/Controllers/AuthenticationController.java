package ApplicationServer.Controllers;

import ApplicationServer.JPA.UserRepository;
import ApplicationServer.Model.RegisterSocketProtocol.RegisterSocketServer;
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
        Thread registerSocketThread = new Thread(new RegisterSocketServer(5595, userRepository));
        registerSocketThread.setDaemon(true);
        registerSocketThread.start();
    }

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
