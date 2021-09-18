package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("events")
public class EventsController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping("index")
    public String list(Model model) {
        model.addAttribute("view all","View All");
        model.addAttribute("attractions",attractionRepository.findAll());
        model.addAttribute("cuisines", categoryRepository.findAll());

        return "events/index";

    }



    @GetMapping("add")
    public String displayAddAttractionForm(@ModelAttribute Attraction attraction, Model model) {
        model.addAttribute("title", "Add Attraction");
        model.addAttribute("attraction", attraction);
        return "events/add";
    }

    @PostMapping("add")
    public String processAddAttractionForm(@ModelAttribute @Valid Attraction newAttraction, Errors errors, Model model) {
        if (errors.hasErrors()) {
//            attractionRepository.save(newAttraction);
            //model.addAttribute("attraction", attractionRepository.findAll());
            return "events/add";
        }


        attractionRepository.save(newAttraction);
        model.addAttribute("attraction", attractionRepository.findAll());
        return "redirect:index";
    }

}

