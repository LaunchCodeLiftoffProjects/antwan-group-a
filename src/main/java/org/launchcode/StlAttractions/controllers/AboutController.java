package org.launchcode.StlAttractions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("about")
    public class AboutController {

        @GetMapping
        public String about(Model model) {
            model.addAttribute("title", "about");
            return "about";
        }

    }

