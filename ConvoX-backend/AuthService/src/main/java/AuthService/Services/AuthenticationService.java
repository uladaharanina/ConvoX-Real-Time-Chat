package main.java.AuthService.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    public UserDTO registerUser(UserDTO user) {
        // Implement user registration logic
        // Return the registered user
        throw new UnsupportedOperationException();

    }

    public UserDTO authenticateUser(String username, String password) {
        // Implement user authentication logic
        // Return the authenticated user
        throw new UnsupportedOperationException();
    }
}
