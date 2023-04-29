package com.example.CRUD_Operation_Validation.service;

import com.example.CRUD_Operation_Validation.dao.UserRepository;
import com.example.CRUD_Operation_Validation.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    List<User> userList;
    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersById(Integer userId) {
        if(null!=userId){
            userList = new ArrayList<>();
            userList.add(userRepository.findById(userId).get());
        }else{
            return userRepository.findAll();
        }
        return userList;
    }

    public User updateUsers(JSONObject user) {
        User newUser = new User();
        newUser.setUserId(user.getInt("userId"));
        newUser.setUserName(user.getString("userName"));
        newUser.setDateOfBirth(user.getString("dateOfBirth"));
        newUser.setUserPhoneNumber(user.getString("userPhoneNumber"));
        newUser.setEmail(user.getString("email"));
        userRepository.save(newUser);
        return newUser;
    }

    public void delete(Integer userId) {
        if(null!=userId){
            userRepository.deleteById(userId);
        }else{
            userRepository.deleteAll();
        }
    }
}
