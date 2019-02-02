package webdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller("/")
public class HomeController {

    @GetMapping
    public String index() {
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
