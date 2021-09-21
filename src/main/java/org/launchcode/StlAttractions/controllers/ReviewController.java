package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.ReviewRepository;
import org.launchcode.StlAttractions.models.Attraction;
import org.launchcode.StlAttractions.models.Review;
import org.launchcode.StlAttractions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping("")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("title", "Add Review");
        model.addAttribute(new Review());
        model.addAttribute("attractions", attractionRepository.findAll());
        return "add-review";
    }

    @PostMapping("")
    public String processAddReviewForm(@ModelAttribute @Valid Review newReview,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Review");
            model.addAttribute("attractions", attractionRepository.findAll());
            return "add-review";
        }

        reviewRepository.save(newReview);

        return "redirect:";
    }

    @GetMapping("view/{reviewId}")

    public String displayViewReview(Model model, @PathVariable int reviewId) {

        Optional optReview = reviewRepository.findById(reviewId);
        if (optReview.isPresent()) {
            Review review = (Review) optReview.get();
            model.addAttribute("review", review);
            return "view-review";
        } else {
            return "redirect:../";
        }
    }
}