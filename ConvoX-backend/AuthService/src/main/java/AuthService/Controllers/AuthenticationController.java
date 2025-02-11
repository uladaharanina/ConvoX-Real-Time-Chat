package AuthService.Controllers;

import org.springframework.web.bind.annotation.RestController;

import AuthService.DTOs.NewUserDTO;
import AuthService.DTOs.UserDTO;
import AuthService.Services.IAuthenticationService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final IAuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Registration
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody NewUserDTO user) {

        try {
            logger.info("Registratrion attempt");
            UserDTO newUser = authenticationService.registeredUser(user);
            if (newUser != null) {
                return ResponseEntity.ok("User " + user.getUsername() + " registered successfully");
            } else {
                return ResponseEntity.badRequest().body("Registration failed");
            }

        } catch (Exception e) {
            logger.error("Error registering user: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }

    // Login

}
