package com.ecommerce.UserServices;

public interface UserService {    
    void signUp(String username, String password, String shippingAddress);
    boolean signIn(String username, String password);
}
