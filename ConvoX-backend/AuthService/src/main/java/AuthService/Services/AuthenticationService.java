package AuthService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AuthService.DTOs.NewUserDTO;
import AuthService.DTOs.UserDTO;
import AuthService.Models.User;
import AuthService.Repo.IUserRepo;
import AuthService.Utils.HashData;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private final IUserRepo userRepo;

    public AuthenticationService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO registeredUser(NewUserDTO user) {

        try {
            if (userRepo.findByUsername(user.getUsername()) == null) {

                // hash password and update it
                user.setPassword(HashData.hashPassword(user.getPassword()));
                User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail());
                userRepo.save(newUser);
                return new UserDTO(user.getUsername(), user.getEmail());
            }

            else {
                throw new Exception("User already exist!");
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to register user: " + e.getMessage());
        }

    }

    @Override
    public UserDTO authenticateUser(UserDTO user) {
        // Implement user authentication logic
        // Return the authenticated user
        throw new UnsupportedOperationException();
    }

}
