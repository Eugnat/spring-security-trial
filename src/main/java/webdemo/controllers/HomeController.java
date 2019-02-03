package webdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("/")
public class HomeController {


    @GetMapping
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/trial")
    public String trial() {
        return "trial";
    }

    @GetMapping("/servlet")
    public String servlet() {
        return "servlet";
    }

    @GetMapping("/myLogin")
    public String login() {
        return "login";
    }
}
