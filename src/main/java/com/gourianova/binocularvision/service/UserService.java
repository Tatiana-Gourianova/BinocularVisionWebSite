package com.gourianova.binocularvision.service;
import com.gourianova.binocularvision.exception.UserNotFoundException;
import com.gourianova.binocularvision.model.User;
import com.gourianova.binocularvision.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    public User addUser(User user){
      //  user.setId(UUID.randomUUID().hashCode());
         return userRepo.save(user);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
    public User updateUser(User user){
        return userRepo.save(user);
    }
    public User findUserById(Integer id){
        return userRepo.findUserById(id).
                orElseThrow(()-> new UserNotFoundException("User by id" + id + "not found"));

    }

    public void deleteUser(Integer id){
        userRepo.deleteUserById(id);
    }
}
