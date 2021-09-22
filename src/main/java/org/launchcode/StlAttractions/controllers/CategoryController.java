package org.launchcode.StlAttractions.controllers;


import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.AttractionData;
import org.launchcode.StlAttractions.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")

    public String displayAddCategoryForm(Model model) {
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());
        return "add-category";
    }

    @PostMapping("")
    public String processAddCategoryForm(@ModelAttribute @Valid Category newCategory,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            return "add-category";
        }

        categoryRepository.save(newCategory);

        return "redirect:list";
    }

    @GetMapping("view/{categoryId}")
    public String displayViewCategory(Model model, @PathVariable int categoryId) {
        Optional optCategory = categoryRepository.findById(categoryId);
        if (optCategory.isPresent()) {
            Category category = (Category) optCategory.get();
            model.addAttribute("category", category);
            return "view-category";
        } else {
            return "redirect:../";
        }
    }

//    @RequestMapping("/delete/{categoryId}")
//    public String processDeleteProductForm(@PathVariable(name = "categoryId") int categoryId, @org.jetbrains.annotations.NotNull Model model) {
//        model.addAttribute("product", categoryRepository.deleteById(categoryId));
//        return "redirect:/list";
//    }
}