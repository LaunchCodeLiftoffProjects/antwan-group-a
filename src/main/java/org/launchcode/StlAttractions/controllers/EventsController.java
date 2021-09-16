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
@RequestMapping("events")
public class EventsController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/index")
    public String displayEvents(Model model) {
        List<Attraction> list = buildItems();
        List<Attraction> eventsList = list.stream().filter(line -> "Events".equals(line.getAttractionCategory())).collect(Collectors.toList());
        model.addAttribute("Events", eventsList);
        return "/events/index";
    }
    private List<Attraction> buildItems() {
        List<Attraction> list = new ArrayList<Attraction>();
        Attraction attraction1 = new Attraction("Events", "Saint Louis Science Center", "The Saint Louis Science Center, founded as a planetarium in 1963, is a collection of buildings including a science museum and planetarium in St. Louis, Missouri, on the southeastern corner of Forest Park.", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+science+center/@38.7514168,-92.630554,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b51805d969d7:0xaf3c05404eeb4c78!2m2!1d-90.270419!2d38.6289922", "https://www.slsc.org/");
        Attraction attraction2 = new Attraction("Events", "Saint Louis Zoo", "The Saint Louis Zoo, officially the Saint Louis Zoological Park, is a zoo in Forest Park, St. Louis, Missouri. It is recognized as a leading zoo in animal management, research, conservation, and education", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+zoo/@38.7514168,-92.639295,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b55ccc04062d:0x6075080197e8e830!2m2!1d-90.2913381!2d38.6350239", "https://www.stlzoo.org/");
        Attraction attraction3 = new Attraction("Events", "Missouri Botanical Garden", "The Missouri Botanical Garden is a botanical garden located at 4344 Shaw Boulevard in St. Louis, Missouri. It is also known informally as Shaw's Garden for founder and philanthropist Henry Shaw.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouri+botanical+garden+address+link/@38.7514168,-92.6179286,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4ffa9d2cd81:0x60b0c580fcde5080!2m2!1d-90.2593798!2d38.6127672", "https://www.missouribotanicalgarden.org/");
        list.add(attraction1);
        list.add(attraction2);
        list.add(attraction3);

        return list;
        }
    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Attraction());
        return "events/add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute Attraction newAttraction, Errors errors){
        if(errors.hasErrors()){
            return "events/add";
        }
        attractionRepository.save(newAttraction);
        return "redirect:/";
    }
}


