package com.SpringSandbox.SpringSandbox.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.youtube.com/watch?v=PhG5p_yv0zs&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=3



@RestController
public class HomeResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        System.out.println(userRepository.toString());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userRepository.findByUsername("user"));
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome</h1>");
    }
}
