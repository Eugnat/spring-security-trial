package webdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "servlet";
    }
}
