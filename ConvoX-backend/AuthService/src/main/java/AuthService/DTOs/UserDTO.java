package AuthService.DTOs;

public class UserDTO {

    private String username;
    private String email;

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return email;
    }

    public void setPassword(String email) {
        this.email = email;
    }

}
