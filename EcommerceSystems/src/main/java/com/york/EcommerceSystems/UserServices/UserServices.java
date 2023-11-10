package com.york.EcommerceSystems.UserServices;

import com.york.EcommerceSystems.Database.user.User;
import com.york.EcommerceSystems.Database.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    // User sign-up operation
    public boolean signUp(String username, String password, String shippingAddress) {
        // Validate inputs 
        if (username == null || password == null || shippingAddress == null) {
            return false;
        }

        // Check if the username is unique 
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            return false;
        }

        // Create a new user
        User newUser = new User(shippingAddress, shippingAddress, shippingAddress);
        newUser.setUserName(username);
        newUser.setPassword(password);
        newUser.setStreetAddress(shippingAddress);

        // Save the user to the database
        userRepository.save(newUser);

        return true;
    }

    // User sign-in operation
    public boolean signIn(String username, String password) {
        // Validate inputs 
        if (username == null || password == null) {
            return false;
        }

        // Check if the user exists in the database
        Optional<User> existingUser = userRepository.findByUsernameAndPassword(username, password);
        return existingUser.isPresent();
    }
}
