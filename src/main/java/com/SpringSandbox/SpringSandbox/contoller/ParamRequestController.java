package com.SpringSandbox.SpringSandbox.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamRequestController {
    //Here are the annotations for our controllers
    @GetMapping(value = "/param")
    @ResponseBody
    public int param(@RequestParam(name="deafaultName") String defaultName, @RequestParam String requiredName){
        //defaultName has the default value of "defaultName". If it isn't passed in that's what it gets set to.
        //requiredName is required
        System.out.println(defaultName);
        System.out.println(requiredName);
        return 1;
    }
}
