package ApplicationServer.Controllers;

import ApplicationServer.JPA.UserRepository;
import ApplicationServer.Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) { this.userRepository = userRepository;}

    /**
     * HTTP Method to get all users.
     *
     * Endpoint
     * http://<b>{host}</b>:8080/api/user
     *
     * Example
     * http://localhost:8080/api/user   =
     *
     * @return returns a list of all users
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
