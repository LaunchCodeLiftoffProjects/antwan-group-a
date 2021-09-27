package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.ReviewRepository;
import org.launchcode.StlAttractions.data.UserRepository;
import org.launchcode.StlAttractions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String profile(Model model, HttpSession session, RedirectAttributes redirAttrs) {
        User user = authenticationController.getUserFromSession(session);
        if (user == null) {
            redirAttrs.addFlashAttribute("mustlogin", "Please log into access this feature.");

            return "redirect:login";
        }

        model.addAttribute("title", user.getUsername());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("reviews", user.getReviews());
        model.addAttribute(user);

        return "profile";
    }
}
