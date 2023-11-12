package com.ecommerce.UserServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField addressField;

    public UserInterface() {
        setTitle("User Services Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        addressField = new JTextField();

        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(new JLabel("Shipping Address: "));
        add(addressField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add the logic to interact with the Spring Boot endpoint for signing up here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String address = addressField.getText();

                // Make an HTTP request to the Spring Boot backend with the entered details
                // Display success or error messages based on the response
            }
        });

        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add the logic to interact with the Spring Boot endpoint for signing in here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Make an HTTP request to the Spring Boot backend with the entered details
                // Display success or error messages based on the response
            }
        });

        add(signUpButton);
        add(signInButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserInterface();
        });
    }
}
