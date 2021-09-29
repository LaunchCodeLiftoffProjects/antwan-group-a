package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.data.ReviewRepository;
import org.launchcode.StlAttractions.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @RequestMapping("")
    public String displayHomePage() {
        return "HomePage";
    }

    @GetMapping("view/{attractionId}")
    public String displayViewAttraction(Model model,HttpServletRequest request, @PathVariable int attractionId) {

        Optional optAttraction = attractionRepository.findById(attractionId);
        if (optAttraction.isPresent()) {
            Attraction attraction = (Attraction) optAttraction.get();
            model.addAttribute("attraction", attraction);

            User user = authenticationController.getUserFromSession(request.getSession());

            String column = "attraction";
            String value = attraction.getName();

            Iterable<Review> reviews = reviewRepository.findAll();
            reviews = ReviewData.findByColumnAndValue(column, value, reviewRepository.findAll());

            model.addAttribute("reviews", reviews);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}
