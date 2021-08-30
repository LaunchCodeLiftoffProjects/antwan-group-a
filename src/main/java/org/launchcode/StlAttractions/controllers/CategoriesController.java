package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoriesController {

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Item> list = buildItems();
        List<Item> museumsList = list.stream().filter(line -> "Museums".equals(line.getItem_category())).collect(Collectors.toList());
        List<Item> restList = list.stream().filter(line -> "Restaurants".equals(line.getItem_category())).collect(Collectors.toList());
        List<Item> eventList = list.stream().filter(line -> "Events".equals(line.getItem_category())).collect(Collectors.toList());
        List<Item> parkList = list.stream().filter(line -> "parks".equals(line.getItem_category())).collect(Collectors.toList());
        List<Item> historicalList = list.stream().filter(line -> "Historical".equals(line.getItem_category())).collect(Collectors.toList());

        model.addAttribute("Museums", museumsList);
        model.addAttribute("Restaurants", restList);
        model.addAttribute("Events", eventList);
        model.addAttribute("Parks", parkList);
        model.addAttribute("Historical", historicalList);
        return "categories";
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