package com.SpringSandbox.SpringSandbox.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.SpringSandbox.SpringSandbox.beans.LifecycleHooks;

@Controller
public class TestController {
    @GetMapping(value = "/dashboard")
    @ResponseBody
    public int dashboard() {

        return 1;
    }
}

