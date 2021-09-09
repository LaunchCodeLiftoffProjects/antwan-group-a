package org.launchcode.StlAttractions.controllers;


import org.launchcode.StlAttractions.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class CategoryController {

    @GetMapping("categories")
    public String listCategories(Model model) {
        model.addAttribute("Museums");
        model.addAttribute("Restaurants");
        model.addAttribute("Events");
        model.addAttribute("Parks");
        model.addAttribute("Historical");
        return "categories";
    }
    @GetMapping("/restaurants")

    public String displayRestaurant(Model model) {
        List<Item> list = buildItems();
        List<Item> restaurantsList = list.stream().filter(line -> "Restaurants".equals(line.getItem_category())).collect(Collectors.toList());
        model.addAttribute("Restaurants", restaurantsList);

        return "/restaurants";
    }
    @GetMapping("/museums")

    public String displayMuseums(Model model) {
        List<Item> list = buildItems();
        List<Item> museumsList = list.stream().filter(line -> "Museums".equals(line.getItem_category())).collect(Collectors.toList());
        model.addAttribute("Museums", museumsList);
        return "/museums";
    }
    @GetMapping("/events")
    public String displayEvents(Model model) {
        List<Item> list = buildItems();
        List<Item> eventsList = list.stream().filter(line -> "Events".equals(line.getItem_category())).collect(Collectors.toList());
        model.addAttribute("Events", eventsList);
        return "/events";
    }

    @GetMapping("/parks")
    public String displayParks(Model model) {
        List<Item> list = buildItems();
        List<Item> parksList = list.stream().filter(line -> "Parks".equals(line.getItem_category())).collect(Collectors.toList());
        model.addAttribute("Parks", parksList);
        return "/parks";
    }

    @GetMapping("/historicalsites")
    public String displayHistoricalSites(Model model) {
        List<Item> list = buildItems();
        List<Item> historicalList = list.stream().filter(line -> "Historical".equals(line.getItem_category())).collect(Collectors.toList());
        model.addAttribute("Historical", historicalList);
        return "/historicalsites";
    }
    private List<Item> buildItems() {
        List<Item> list = new ArrayList<Item>();
        Item item1 = new Item("Restaurants", "Sauce on the side", "https://www.missouribotanicalgarden.org/");
        Item item2 = new Item("Restaurants","Tempus","https://www.tempusstl.com/");
        Item item3 = new Item("Restaurants","Boathouse at Forest Park","https://boathousestl.com/");
        Item item4 = new Item("Museums","Missouri History Museum","https://mohistory.org/museum");
       Item item5 = new Item("Museums","Saint Louis Art Museum","https://www.slam.org/");
       Item item6 = new Item("Museums","City Museum","https://www.citymuseum.org/");//
        Item item7 = new Item("Events","Saint Louis Science Center","https://www.slsc.org/");
        Item item8 = new Item("Events","Saint Louis Zoo","https://www.stlzoo.org/");
        Item item9 = new Item("Events","Missouri Botanical Garden","https://www.missouribotanicalgarden.org/");
        Item item10 = new Item("Parks","Citygarden Sculpture Park","http://www.citygardenstl.org/");
        Item item11 = new Item("Parks","Willmore Park","https://www.stlouis-mo.gov/government/departments/parks/parks/browse-parks/view-park.cfm?parkID=93&parkName=Willmore");
        Item item12 = new Item("Parks","Forest Park","https://forestparkmap.org/");
        Item item13 = new Item("Historical","Union Station","https://www.stlouisunionstation.com/");
       Item item14 = new Item("Historical","Campbell House Museum","http://www.campbellhousemuseum.org/");
        Item item15 = new Item("Historical","The Gateway Arch","https://www.gatewayarch.com/");
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
