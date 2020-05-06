package com.lingo4lingo.lingo.service;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@Slf4j
//@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> userList.add(user1));
        return userList;
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id); //.get
    }

    public void  saveOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
        System.out.println("User with id: " + id + " has been deleted!");
    }

    public void update(User user, Long id){
        userRepository.save(user);
        System.out.println("User with id: " + id + " has been updated!");
    }

}
