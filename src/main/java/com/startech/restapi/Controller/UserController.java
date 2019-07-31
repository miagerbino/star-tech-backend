package com.startech.restapi.Controller;

import com.startech.restapi.Persistence.Account;
import com.startech.restapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="user/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path="all-users",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> listUsers(){
        return service.getAllUsers();
    }

    @GetMapping(path="user-id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account getUserById(@RequestParam(name="id") Long id){
        return service.getUser(id);
    }

    @PostMapping(path="create",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createUser(@RequestBody Account user){
        service.save(user);
    }

}

