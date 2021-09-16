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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("historical")
public class HistoricalController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/index")
    public String displayHistoricalSites(Model model) {
        List<Attraction> list = buildItems();
        List<Attraction> historicalList = list.stream().filter(line -> "Historical".equals(line.getAttractionCategory())).collect(Collectors.toList());
        model.addAttribute("Historical", historicalList);
        return "/historical/index";
    }
    private List<Attraction> buildItems() {
        List<Attraction> list = new ArrayList<Attraction>();
        Attraction attraction1 = new Attraction("Historical", "Union Station", "The city known for being the gateway to the West suddenly became a gateway to all of America. Over the next several years, Union Station would become one of the largest and busiest passenger rail terminals in the world.", "https://www.google.com/maps/dir//union+station+st+louis/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b346a315791d:0x6204ffe04ef3d2d3?sa=X&ved=2ahUKEwjp9_32zv_yAhV4GFkFHSb0DF0Q9Rd6BAgMEAU", "https://www.stlouisunionstation.com/");
        Attraction attraction2 = new Attraction("Historical", "The Gateway Arch", "Gateway Arch National Park is an American national park located in St. Louis, Missouri, near the starting point of the Lewis and Clark Expedition", "https://www.google.com/maps/dir/38.9329,-76.9988664/the+gateway+arch+national+park/@38.7514168,-92.5800578,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b2e26e15bcb5:0xf8383c57426ed4f1!2m2!1d-90.1837533!2d38.6274334", "https://www.gatewayarch.com/");
        Attraction attraction3 = new Attraction("Historical", "Campbell House Museum", "The Campbell House Museum opened on February 6, 1943, and is in the Greater St. Louis area, in the U.S. state of Missouri.", "https://www.google.com/maps/dir//campbell+house+museum/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b315f6e5c041:0x46c6bf0a7ce22447?sa=X&ved=2ahUKEwjey9_Cz__yAhWBGFkFHbsgCKgQ9Rd6BAhyEAU", "http://www.campbellhousemuseum.org/");
        list.add(attraction1);
        list.add(attraction2);
        list.add(attraction3);

        return list;
        }
    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Attraction());
        return "historical/add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute Attraction newAttraction, Errors errors){
        if(errors.hasErrors()){
            return "historical/add";
        }
        attractionRepository.save(newAttraction);
        return "redirect:/";
    }
    }

