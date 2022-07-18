package com.prueba.web.tecnica.services;

import com.prueba.web.tecnica.entities.User;
import com.prueba.web.tecnica.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> sp_findAll() {
        return (List<User>)userRepository.sp_findAll();
    }

    @Override
    public User sp_findById(int id) {
        return userRepository.sp_findById(id).orElse(null);
    }

    @Override
    public User sp_save(User user) {
        return userRepository.sp_save(user.getName());
    }

    @Override
    public User sp_edit(User user) {
        return userRepository.sp_edit(user.getId(), user.getName());
    }
}
