package com.example.CRUD_Operation_Validation.controller;

import com.example.CRUD_Operation_Validation.model.User;
import com.example.CRUD_Operation_Validation.service.UserService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/getUser")
    public List<User> getUser(@Nullable @RequestParam Integer userId){
        return userService.getUsersById(userId);
    }

    @PutMapping("/updateUserInfo")
    public ResponseEntity updateUser(@Valid @RequestBody User user){
        JSONObject json = new JSONObject(user);
        return new ResponseEntity<>(userService.updateUsers(json), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@Nullable @RequestParam Integer userId){
        userService.delete(userId);
        return new ResponseEntity<>("User is deleted from database", HttpStatus.OK);
    }
}
