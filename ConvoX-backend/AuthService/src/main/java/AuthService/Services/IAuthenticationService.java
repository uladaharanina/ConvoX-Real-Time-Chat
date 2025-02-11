package AuthService.Services;

import AuthService.DTOs.NewUserDTO;
import AuthService.DTOs.UserDTO;

public interface IAuthenticationService {

    public UserDTO registeredUser(NewUserDTO user);

    public UserDTO authenticateUser(UserDTO user);
}
