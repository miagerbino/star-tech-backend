package com.startech.restapi.Controller;

import com.startech.restapi.Persistence.Account;
import com.startech.restapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="user/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path="all-users",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> listUsers(){
        System.out.println("LOG: looking for users");
        return service.getAllUsers();
    }
}

