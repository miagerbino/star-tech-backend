package com.startech.restapi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HealthController {

    @GetMapping(path="health")
    @ResponseBody
    public String checkHealth(){
        return "Up!";
    }
}
