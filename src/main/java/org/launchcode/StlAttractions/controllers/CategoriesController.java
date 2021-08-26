package org.launchcode.StlAttractions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriesController {
    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }
}