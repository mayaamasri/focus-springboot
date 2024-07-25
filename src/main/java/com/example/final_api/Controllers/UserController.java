package com.example.final_api.Controllers;

import com.example.final_api.Model.User;
import com.example.final_api.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", savedUser.getUserId());
        response.put("username", savedUser.getUsername());
        response.put("success", true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User loginUser = userService.login(user.getEmail(), user.getPassword());
        if (loginUser != null) {
            return ResponseEntity.ok(Map.of("userId", loginUser.getUserId(), "username", loginUser.getUsername(), "success", true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}

