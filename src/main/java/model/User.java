package model;

public class User {
    private String username;
    private int userId;
    private String userRole;
    private String email;
    private String password;

    public User(int userId, String userRole, String password) {
        this.userId = userId;
        this.userRole = userRole;
        this.password = password;
    }

    public User(int userId, String userRole, String username, String email, String password) {
        this.username = username;
        this.userId = userId;
        this.userRole = userRole;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", userId=" + userId +
                ", userRole='" + userRole + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
