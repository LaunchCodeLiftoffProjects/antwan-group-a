package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.Attraction;
import org.launchcode.StlAttractions.models.AttractionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("name", "Name");
        columnChoices.put("address", "Address");
        columnChoices.put("link", "Link");
//        columnChoices.put("category", "Category");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("view all","View All");
        model.addAttribute("attractions",attractionRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        return "list";
    }

    @RequestMapping("attractions")
    public String listAttractionsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Attraction> attractions = null;
        if (column.toLowerCase().equals("all")) {
            attractions = attractionRepository.findAll();
            model.addAttribute("title","All Attractions");
        } else if (column.toLowerCase().equals("category")) {
            attractions = AttractionData.findByColumnAndValue(column, value, attractionRepository.findAll());
            model.addAttribute("title", "Attractions with " + value + " category" );
        }

        model.addAttribute("attractions", attractions);
        return "list-attractions";
    }





}