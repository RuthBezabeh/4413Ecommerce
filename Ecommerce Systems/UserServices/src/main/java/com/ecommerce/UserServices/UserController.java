package com.ecommerce.UserServices;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app_users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user.getUsername(), user.getPassword(), user.getShippingAddress());
    }

    @PostMapping("/signin")
    public User signIn(@RequestBody User user) {
        return userService.signIn(user.getUsername(), user.getPassword());
    }
}
