package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.jammatesapp.model.UserLogin;
import edu.utsa.cs3443.jammatesapp.model.LoginController;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;
    /**
     * @author Ariel Martinez
     * screen that opens the app, where the user can login, with correct credentials the user will be taken to the
     * main page
     */

    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();

            UserLogin login = new UserLogin(username, password);
            loginController = new LoginController(login);

            if (loginController.authenticate()) {
                Toast.makeText(this, "Login successful.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show();
                loginController.resetCredentials();
                usernameInput.setText("");
                passwordInput.setText("");
            }
        });
    }
}
