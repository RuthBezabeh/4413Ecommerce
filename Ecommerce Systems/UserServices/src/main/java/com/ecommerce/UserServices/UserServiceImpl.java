package com.ecommerce.UserServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository; 

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String username, String password, String shippingAddress) {
    Optional<User> existingUser = userRepository.findByUsername(username);
    
    if (existingUser.isPresent()) {
        // User already exists, throw an exception 
        throw new RuntimeException("User already exists with the username: " + username);
    } else {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setShippingAddress(shippingAddress);
        userRepository.save(newUser); 
    }
    }

    @Override
    public boolean signIn(String username, String password) {
        Optional<User> userOptional = (Optional<User>) userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (validatePassword(password, user.getPassword())) {
                return true; 
            }
        }
        return false; 
    }
    
    private boolean validatePassword(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword); 
    }
    }
