package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AttractionsController {
    List<Item> matchedItems = new ArrayList<Item>();
    @GetMapping("/attractions")
    public String attractions(Model model) {
        model.addAttribute("items", matchedItems);
        return "attractions";
    }


    @PostMapping("search")
    public String processCreateEventForm(@RequestParam String searchTerm, Model model) {

        List<Item> items = buildItems();
        matchedItems = items.stream().
                filter(p -> p.getItem_name().toLowerCase().contains(searchTerm.toLowerCase())).
                collect(Collectors.toList());
        model.addAttribute("items", matchedItems);
        return "redirect:attractions";
    }

    private List<Item> buildItems(){
        List<Item> list = new ArrayList<Item>();
        Item item1 = new Item("Restaurants","Sauce on the side","https://www.missouribotanicalgarden.org/");
        Item item2 = new Item("parks","Forest Park","https://forestparkmap.org/");
        Item item3 = new Item("Historical","The Gateway Arch","https://www.gatewayarch.com/");
        Item item4 = new Item("Restaurants","Tempus","https://www.tempusstl.com/");
        Item item5 = new Item("Restaurants","Boathouse at Forest Park","https://boathousestl.com/");
        Item item6 = new Item("Museums","Missouri History Museseum","https://mohistory.org/museum");
        Item item7 = new Item("Museums","Saint Louis Art Museum","https://www.slam.org/");
        Item item8 = new Item("Museums","City Museum","https://www.citymuseum.org/");
        Item item9 = new Item("parks","Citygarden Sculpture Park","http://www.citygardenstl.org/");
        Item item10 = new Item("parks","Willmore Park","https://www.stlouis-mo.gov/government/departments/parks/parks/browse-parks/view-park.cfm?parkID=93&parkName=Willmore");
        Item item11 = new Item("Events","Saint Louis Science Center","https://www.slsc.org/");
        Item item12 = new Item("Events","Saint Louis Zoo","https://www.stlzoo.org/");
        Item item13 = new Item("Events","Missouri Botanical Garden","https://www.missouribotanicalgarden.org/");
        Item item14 = new Item("Historical","Union Station","https://www.stlouisunionstation.com/");
        Item item15 = new Item("Historical","Campbell House Museum","http://www.campbellhousemuseum.org/");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);
        list.add(item9);
        list.add(item10);
        list.add(item11);
        list.add(item12);
        list.add(item13);
        list.add(item14);
        list.add(item15);

        return list;
    }
}
