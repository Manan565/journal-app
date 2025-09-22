package com.manan565.journalApp.services;

import com.manan565.journalApp.entity.JournalEntry;
import com.manan565.journalApp.entity.User;
import com.manan565.journalApp.repository.JournalEntryRepository;
import com.manan565.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
        userRepository.save(user);
    }
    public void saveNewUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){

        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById((id));
    }

    public User findByUserName(String  userName) {
        return userRepository.findByUserName((userName));
    }
}
