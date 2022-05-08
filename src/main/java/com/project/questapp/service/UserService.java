package com.project.questapp.service;

import com.project.questapp.entity.User;
import com.project.questapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public User createUser(User user){

        return userRepository.save(user);
    }

    public User getUserById(Long userId){
        //findById optional dönüyor o yüzden orElse yaptık buraya sonradan yoksa kullanıcı ona göre custom exception eklenebilir
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User newUser){

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

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
