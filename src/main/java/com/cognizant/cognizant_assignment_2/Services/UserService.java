package com.cognizant.cognizant_assignment_2.Services;

import com.cognizant.cognizant_assignment_2.Models.User;
import com.cognizant.cognizant_assignment_2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findOneUser(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
