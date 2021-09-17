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

import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private AttractionRepository attractionRepository;

    static HashMap<String, String> columnChoices = new HashMap<String,String>();

    static {
        columnChoices.put("all","All");
        columnChoices.put("name", "Name");
        columnChoices.put("category", "Category");
        columnChoices.put("address", "Address");
        columnChoices.put("link", "Link");
    }



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
        }
//        else {
//            attractions = AttractionData.findByColumnAndValue(searchType, searchTerm, AttractionRepository.findAll());
//        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Attractions with " + columnChoices.get(searchType) + ": " + searchTerm);
        //model.addAttribute("attractions", attractions);

        return "search";
    }
}

