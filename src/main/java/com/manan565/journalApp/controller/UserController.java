package com.manan565.journalApp.controller;


import com.manan565.journalApp.entity.JournalEntry;
import com.manan565.journalApp.entity.User;
import com.manan565.journalApp.services.JournalEntryService;
import com.manan565.journalApp.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName")
    public ResponseEntity<?> updateUser(@PathVariable String userName,@RequestBody User user){
        User userInDb = userService.findByUserName(userName);
        if(userInDb!=null){
           userInDb.setUserName(user.getUserName());
           userInDb.setPassword(user.getPassword());
           userService.saveEntry(userInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
