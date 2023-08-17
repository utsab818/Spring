package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        User responseUser = userService.insertUser(user);
        return ResponseEntity.ok(responseUser);
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User responseUser = userService.updateUser(user);
        return ResponseEntity.ok(responseUser);
    }

    @GetMapping("/email={email}&password={password}")
    public ResponseEntity<User> getUser(@PathVariable String email, @PathVariable String password) {
        User responseUser = userService.getUser(email, password);
        return ResponseEntity.ok(responseUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

}