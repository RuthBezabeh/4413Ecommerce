package com.ecommerce.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/ecommerce/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody User userDTO) {
        userService.signUp(userDTO.getUsername(), userDTO.getPassword(), userDTO.getShippingAddress());
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public boolean signIn(@RequestParam String username, @RequestParam String password) {
        return userService.signIn(username, password);
    }
}
