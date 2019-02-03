package webdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import webdemo.services.MySampleInterface;


@Controller("/")
public class HomeController {

    @Autowired
    private MySampleInterface myService;

    @GetMapping
    public String index() {

        return "index";
    }

    @GetMapping("/trial")
    public String trial() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        myService.printUsername(name);

        return "trial";
    }

    @GetMapping("/servlet")
    public String servlet() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        myService.printUsername(name);

        return "servlet";
    }

    @GetMapping("/myLogin")
    public String login() {
        return "login";
    }
}
