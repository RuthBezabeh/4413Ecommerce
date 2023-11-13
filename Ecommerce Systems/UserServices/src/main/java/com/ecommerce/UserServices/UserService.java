package com.ecommerce.UserServices;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User signUp(String username, String password, String shippingAddress);
    User signIn(String username, String password);
    // Other user-related methods
}
