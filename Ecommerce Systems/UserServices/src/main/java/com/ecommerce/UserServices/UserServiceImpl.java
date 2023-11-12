package com.ecommerce.UserServices;

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
    public User signUp(String username, String password, String shippingAddress) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setShippingAddress(shippingAddress);

        return userRepository.save(newUser);
    }

    @Override
    public User signIn(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.validatePassword(password)) {
            return user;
        }
        return null; 
    }
}
