package com.project.questapp.controllers;

import com.project.questapp.entities.User;
import com.project.questapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    public UserController(UserRepository userRepository) { // Constructor injection
//        this.userRepository = userRepository;
//    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        //findById optional dönüyor o yüzden orElse yaptık buraya sonradan yoksa kullanıcı ona göre custom exception eklenebilir
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser){

        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){

            User existingUser = user.get();

            existingUser.setUserName(newUser.getUserName());
            existingUser.setPassword(newUser.getPassword());

            userRepository.save(existingUser);

            return existingUser;
        }
        else
            return null;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){

        userRepository.deleteById(userId);
    }
}
