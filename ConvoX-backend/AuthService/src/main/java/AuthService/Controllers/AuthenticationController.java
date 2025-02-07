package main.java.AuthService.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    // Registration
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO user) {
        throw new UnsupportedOperationException();
    }

    // Login

}
