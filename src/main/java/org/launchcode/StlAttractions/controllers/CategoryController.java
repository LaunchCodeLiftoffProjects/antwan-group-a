package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public String categories(Model model) {
        model.addAttribute("category", new Category());

        return "category";
    }
}




//    public String displayCategory(@RequestParam Integer categoryId, Model model) {
//        model.addAttribute("title", "Category");
//        Optional<Category> result = categoryRepository.findById(categoryId);
//        Category category = result.get();
//        model.addAttribute("category", category);



