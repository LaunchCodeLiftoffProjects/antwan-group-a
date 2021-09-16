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
@RequestMapping("parks")
public class ParkController {
    @Autowired
    private AttractionRepository attractionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/index")
    public String displayParks(Model model) {
        List<Attraction> list = buildItems();
        List<Attraction> parksList = list.stream().filter(line -> "Parks".equals(line.getAttractionCategory())).collect(Collectors.toList());
        model.addAttribute("Parks", parksList);
        return "/parks/index";
    }
    private List<Attraction> buildItems() {
        List<Attraction> list = new ArrayList<Attraction>();
        Attraction attraction1 = new Attraction("Parks", "Citygarden Sculpture Park", "Citygarden is an urban park and sculpture garden in St. Louis, Missouri owned by the City of St. Louis but maintained by the Gateway Foundation.", "https://www.google.com/maps/dir/38.9329,-76.9988664/city+garden+sculpture+park+st+louis/@38.7514168,-92.5854472,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b3197dd7cdf9:0xab91dcb20aeb6124!2m2!1d-90.1937073!2d38.6266804", "http://www.citygardenstl.org/");
        Attraction attraction2 = new Attraction("Parks", "Willmore Park", "Large, tranquil natural area with multiple lakes, sport fields & courts, picnic spots & play areas", "https://www.google.com/maps/dir/38.9329,-76.9988664/willmore+park/@38.7514168,-92.6395304,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4545bbb518b:0x3be971e61cc6f868!2m2!1d-90.3039214!2d38.5733606", "https://www.stlouis-mo.gov/government/departments/parks/parks/browse-parks/view-park.cfm?parkID=93&parkName=Willmore");
        Attraction attraction3 = new Attraction("Parks", "Forest Park", "Forest Park is a public park in western St. Louis, Missouri. It is a prominent civic center and covers 1,326 acres. Opened in 1876, more than a decade after its proposal, the park has hosted several significant events", "https://www.google.com/maps/dir/38.9329,-76.9988664/forest+park+st+louis/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5469178c4c9:0x9d27c5026db294aa!2m2!1d-90.2830635!2d38.6380167", "https://forestparkmap.org/");
        list.add(attraction1);
        list.add(attraction2);
        list.add(attraction3);

        return list;
    }
    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Attraction());
        return "parks/add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute Attraction newAttraction, Errors errors){
        if(errors.hasErrors()){
            return "parks/add";
        }
        attractionRepository.save(newAttraction);
        return "redirect:/";
    }
}
