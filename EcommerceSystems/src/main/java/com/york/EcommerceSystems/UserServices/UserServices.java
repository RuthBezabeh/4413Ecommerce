package com.york.EcommerceSystems.UserServices;

import com.york.EcommerceSystems.Database.user.UserRepository;
import com.york.EcommerceSystems.Database.user.User;

import java.util.Optional;

public class UserServices {
    private UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User sign-up operation
    public boolean signUp(String username, String password, String shippingAddress) {
        // Validate inputs (you may add more validation logic)
        if (username == null || password == null || shippingAddress == null) {
            return false;
        }

        // Check if the username is unique (you may add more checks)
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            return false;
        }

        // Save the user to the database
        userRepository.save(new User(username, password, shippingAddress));
        return true;
    }

    // User sign-in operation
    public boolean signIn(String username, String password) {
        // Validate inputs (you may add more validation logic)
        if (username == null || password == null) {
            return false;
        }

        // Check if the user exists in the database
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.isPresent(); // Sign-in successful if the user exists
    }
}
