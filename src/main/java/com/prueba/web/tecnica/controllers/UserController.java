package com.prueba.web.tecnica.controllers;

import com.prueba.web.tecnica.entities.User;
import com.prueba.web.tecnica.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = {"","/","home"})
    public String index(Model model){
        List<User> users = userService.sp_findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/show/{id}")
    public String show(@PathVariable int id, Model model){
        User user = null;
        try{
            user = userService.sp_findById(id);
        }catch (DataAccessException e){
            System.out.println(e);
        }
        model.addAttribute("user", user);
        return "show";
    }

    @PostMapping(value = "/save")
    public RedirectView save(@ModelAttribute("user")User user, Model model){
        User userNew = null;
        try{
            userNew = userService.sp_save(user);
        }catch (DataAccessException e){
            System.out.println(e);
        }
        return new RedirectView("/");
    }

    @GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping(value = "/edit")
    public RedirectView edit(@ModelAttribute("user")User user, Model model){
        User userNow = userService.sp_findById(user.getId());
        User userUpdate = null;
        try{
            userNow.setName(user.getName());
            userUpdate = userService.sp_edit(userNow);
        }catch (DataAccessException e){
            System.out.println(e);
        }
        return new RedirectView("/");
    }
}
