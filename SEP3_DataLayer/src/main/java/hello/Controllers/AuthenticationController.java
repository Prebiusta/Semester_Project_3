package hello.Controllers;

import hello.JPA.UserRepository;
import hello.Model.User;
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.save(user) != null){
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Register failed", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {
        if (isCorrectLogin(username, password)) {
            return userRepository.findByUsername(username);
        }
        throw new UserNotVerifiedException();
    }

    private boolean isCorrectLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user.getPassword().equals(password);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Username or Password incorrect")
    private static class UserNotVerifiedException extends RuntimeException {

    }
}
