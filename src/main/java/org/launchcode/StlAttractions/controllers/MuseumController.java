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
@RequestMapping("museums")
public class MuseumController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/index")

    public String displayMuseums(Model model) {
        List<Attraction> list = buildItems();
        List<Attraction> museumsList = list.stream().filter(line -> "Museums".equals(line.getAttractionCategory())).collect(Collectors.toList());
        model.addAttribute("Museums", museumsList);
        return "/museums/index";
    }
    private List<Attraction> buildItems() {
        List<Attraction> list = new ArrayList<Attraction>();
        Attraction attraction1 = new Attraction("Museums", "Missouri History Museum", "The Missouri History Museum in Forest Park, St. Louis, Missouri, showcases Missouri history. It is operated by the Missouri Historical Society, which was founded in 1866.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouri+history+museum/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b54ed1946807:0xec3f438953c3b266!2m2!1d-90.2857383!2d38.6452478", "https://mohistory.org/museum");
        Attraction attraction2 = new Attraction("Museums", "Saint Louis Art Museum", "The Saint Louis Art Museum is one of the principal U.S. art museums, with paintings, sculptures, cultural objects, and ancient masterpieces from all corners of the world", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+art+museum/@38.7514168,-92.639295,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5576e47b955:0x97a4b1dc139c963a!2m2!1d-90.2944911!2d38.6393062", "https://www.slam.org/");
        Attraction attraction3 = new Attraction("Museums", "City Museum", "City Museum is a museum whose exhibits consist largely of repurposed architectural and industrial objects, housed in the former International Shoe building in the Washington Avenue Loft District of St. Louis, Missouri, United States", "https://www.google.com/maps/dir//city+museum+st+louis/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b33dc2801e55:0xc97c4420308aca04?sa=X&ved=2ahUKEwjUq9uzyv_yAhUdSvEDHZqDAWUQ9Rd6BAhzEAU", "https://www.citymuseum.org/");
        list.add(attraction1);
        list.add(attraction2);
        list.add(attraction3);

        return list;
    }
    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Attraction());
        return "museums/add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute Attraction newAttraction, Errors errors){
        if(errors.hasErrors()){
            return "museums/add";
        }
        attractionRepository.save(newAttraction);
        return "redirect:/";
    }
}
