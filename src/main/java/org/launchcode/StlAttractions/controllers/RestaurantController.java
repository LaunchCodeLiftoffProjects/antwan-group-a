package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.data.AttractionRepository;
import org.launchcode.StlAttractions.data.CategoryRepository;
import org.launchcode.StlAttractions.models.Attraction;
import org.launchcode.StlAttractions.models.AttractionData;
import org.launchcode.StlAttractions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.launchcode.StlAttractions.controllers.AttractionController.columnChoices;

@Controller
@RequestMapping("restaurants")

public class RestaurantController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping("index")
    public String list(Model model) {
        model.addAttribute("view all","View All");
        model.addAttribute("attractions",attractionRepository.findAll());
        model.addAttribute("cuisines", categoryRepository.findAll());

        return "restaurants/index";

}

    @GetMapping("add")
    public String displayAddAttractionForm(Model model){
        model.addAttribute("title","Add attraction");
        model.addAttribute(new Attraction());
        model.addAttribute("attractions",attractionRepository.findAll());
        return "restaurants/add";
    }

    @PostMapping("add")
    public String processAddAttractionForm(@ModelAttribute @Valid Attraction newAttraction, Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title","Add Restaurant");
            return "restaurants/add";
        }
        attractionRepository.save(newAttraction);
        return "redirect:index";
    }

//    @GetMapping("delete")
//    public String displayDeleteAttractionForm(Model model) {
//        model.addAttribute("title", "Delete Attraction");
//        model.addAttribute("attractions", attractionRepository.findAll());
//        return "restaurants-delete";
//    }
//
//    @PostMapping("delete")
//    public String processDeleteAttractionForm(@RequestParam(required = false) int[] attractionIds) {
//        if (attractionIds != null) {
//            for (int id : attractionIds) {
//                attractionRepository.deleteById(id);
//            }
//        }
//        return "redirect:";
//    }

}


//    @GetMapping("restaurants")
//    public String displayRestaurant(Model model) {
//        List<Attraction> list = buildItems();
//        List<Attraction> restaurantsList = list.stream().filter(line -> "Restaurants".equals(line.getAttraction_category())).collect(Collectors.toList());
//        model.addAttribute("Restaurants", restaurantsList);
//
//        return "restaurants";
//    }
//    private List<Attraction> buildItems() {
//        List<Attraction> list = new ArrayList<Attraction>();
//        Attraction attraction1 = new Attraction("Restaurants", "Sauce on the side", "We think there’s something special about fresh food. That’s why we make everything from scratch here at Sauce on the Side. Our handmade calzones. Our salad dressings. Even our desserts. It’s all made right here.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouribotanicalgarden/@38.7514168,-92.6179286,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4ffa9d2cd81:0x60b0c580fcde5080!2m2!1d-90.2593798!2d38.6127672", "https://www.missouribotanicalgarden.org/");
//        Attraction attraction2 = new Attraction("Restaurants", "Tempus", "Opened in fall 2020, Tempus is the highly anticipated restaurant by acclaimed chef Ben Grupe", "https://www.google.com/maps/dir/38.9329,-76.9988664/tempus+stl/@38.7514168,-92.6168587,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b544bd25e4c1:0xa3bc1f101969f942!2m2!1d-90.259435!2d38.6265236", "https://www.tempusstl.com/");
//        Attraction attraction3 = new Attraction("Restaurants", "Boathouse at Forest Park", "Relaxed spot for a drink & casual dining with a waterside view, plus paddleboat rentals", "https://www.google.com/maps/dir/38.9329,-76.9988664/boathouse+at+forest+park/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5467b225aeb:0x757c053b7aa25117!2m2!1d-90.2847884!2d38.6397716", "https://boathousestl.com/");
//        list.add(attraction1);
//        list.add(attraction2);
//        list.add(attraction3);
//
//        return list;
//    }