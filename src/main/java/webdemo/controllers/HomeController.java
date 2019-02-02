package webdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("trialLine", "Trial line");
        return "index";
    }

    @GetMapping("/trial")
    public String trial(Model model) {
        model.addAttribute("trialLine", "Trial line");
        return "trial";
    }

    @GetMapping("/servlet")
    public String servlet(Model model) {
        model.addAttribute("trialLine", "Trial line");
        model.addAttribute("trialLine1", "Trial line 2");
        return "servlet";
    }
}
