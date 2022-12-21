package com.example.demo3.controllers;

import com.example.demo3.entity.User;
import com.example.demo3.repository.RoleRepository;
import com.example.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final RoleRepository roleRepository;

    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    //ADDING NEW USER
    @GetMapping(path = "/addUser")
    public ResponseEntity<String> addUser(Model model) {
        try {
            model.addAttribute("user", new User());
            model.addAttribute("allRoles", roleRepository.findAll());
            model.addAttribute("allUsers", userService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

//        //SAVING NEW USER
//        @PostMapping(path = "/addUser")
//        public String registerUser (@ModelAttribute("user")
//        @Valid User user, BindingResult bresult){
//
//            if (!bresult.hasErrors()) {
//                userService.saveUser(user);
//                return "admin/success";
//            } else {
//                return "admin/addUser";
//            }
//        }

    }

