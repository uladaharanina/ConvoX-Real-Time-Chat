package main.java.AuthService.Services;

interface IAuthenticationService {

    public UserDTO registeredUser(UserDTO user);

    public UserDTO authenticateUser(UserDTO user);
}
