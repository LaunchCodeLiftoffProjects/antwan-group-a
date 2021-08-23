package org.launchcode.StLouisAttractions.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String landing() {return "landing";
    }
    @GetMapping("index")
    public String index() {return "index";
    }

    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }

    @GetMapping("/attractions")
    public String attractions() {
        return "attractions";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



}