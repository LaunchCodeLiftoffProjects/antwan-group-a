package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.Attraction;
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
@RequestMapping("attraction")
public class AttractionController {

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("")
    public String displayAddAttractionForm(Model model) {
        model.addAttribute("title", "Add Attraction");
        model.addAttribute(new Attraction());
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-attraction";
    }

    @PostMapping("")
    public String processAddAttractionForm(@ModelAttribute @Valid Attraction newAttraction,
                                           Errors errors, Model model, @RequestParam int categoryId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Attraction");
            model.addAttribute("categories", categoryRepository.findAll());
            return "add-attraction";
        }
        Optional optCategory = categoryRepository.findById(categoryId);
        if (optCategory.isPresent()) {
            Category category = (Category) optCategory.get();
            newAttraction.setCategory(category);
        }

        attractionRepository.save(newAttraction);

        return "redirect:";
    }
//    @GetMapping("view/{attractionId}")
//    public String displayViewAttraction(Model model, @PathVariable int attractionId) {
//
//        Optional optAttraction = attractionRepository.findById(attractionId);
//        if (optAttraction.isPresent()) {
//            Attraction attraction = (Attraction) optAttraction.get();
//            model.addAttribute("attraction", attraction);
//            return "view";
//        } else {
//            return "redirect:../";
//        }
//    }

}