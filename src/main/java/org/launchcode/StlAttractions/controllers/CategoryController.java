package org.launchcode.StlAttractions.controllers;


import org.launchcode.StlAttractions.data.CategoryRepository;
//import org.launchcode.StlAttractions.models.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Controller
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        //model.addAttribute("categories", CategoryRepository.findAll());
        return "categories";
    }

}
