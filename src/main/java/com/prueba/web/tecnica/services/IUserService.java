package com.prueba.web.tecnica.services;

import com.prueba.web.tecnica.entities.User;

import java.util.List;

public interface IUserService {

    public List<User> sp_findAll();

    public User sp_findById(int id);

    public User sp_save(User user);

    public User sp_edit(User user);
}
