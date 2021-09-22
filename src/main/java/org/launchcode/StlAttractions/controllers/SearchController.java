package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.models.Attraction;
import org.launchcode.StlAttractions.models.AttractionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static org.launchcode.StlAttractions.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private AttractionRepository attractionRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Attraction> attractions;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            attractions = attractionRepository.findAll();
        } else {
            attractions = AttractionData.findByColumnAndValue(searchType, searchTerm, attractionRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Search results for: " + searchTerm);
        model.addAttribute("attractions", attractions);

        return "search";
    }
}