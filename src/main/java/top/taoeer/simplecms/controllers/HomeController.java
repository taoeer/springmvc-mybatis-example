package top.taoeer.simplecms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping
    @ResponseBody
    public String home() {
        return "hello world";
    }
}
