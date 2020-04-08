package com.lingo4lingo.lingo.service;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> userList.add(user1));
        return userList;
    }

    public User getUserById(Long id){
        return userRepository.findById(id); //.get
    }

    public void  saveOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public  void update(User user, Long id){
        userRepository.save(user);
    }

}
