package edu.utsa.cs3443.jammatesapp.model;

import edu.utsa.cs3443.jammatesapp.model.UserLogin;

public class LoginController {

    private UserLogin userLogin;

    public LoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public boolean authenticate() {
        // Example for now! : hardcoded valid credentials
        String validUsername = "user1";
        String validPassword = "password123";

        return userLogin.getUsername().equals(validUsername) &&
                userLogin.getPassword().equals(validPassword);
    }

    public void resetCredentials() {
        userLogin.setUsername("");
        userLogin.setPassword("");
    }
}
