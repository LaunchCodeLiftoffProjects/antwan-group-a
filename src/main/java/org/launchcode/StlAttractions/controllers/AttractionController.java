package org.launchcode.StlAttractions.controllers;

import org.launchcode.StlAttractions.models.Attraction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class AttractionController {
//    List<Attraction> matchedItems = new ArrayList<Attraction>();
//    @GetMapping("/attractions")
//    public String attractions(Model model) {
//        model.addAttribute("attractions", matchedItems);
//        return "attractions";
//    }
//
//
//    @PostMapping("search")
//    public String processCreateEventForm(@RequestParam String searchTerm, Model model) {
//
//        List<Attraction> attractions = buildAttractions();
//        matchedItems = attractions.stream().
//                filter(p -> p.getAttractionName().toLowerCase().contains(searchTerm.toLowerCase())).
//                collect(Collectors.toList());
//        model.addAttribute("items", matchedItems);
//        return "redirect:attractions";
//    }
//
//    private List<Attraction> buildAttractions(){
//        List<Attraction> list = new ArrayList<Attraction>();
//        Attraction attraction1 = new Attraction("Museums", "Missouri History Museum", "The Missouri History Museum in Forest Park, St. Louis, Missouri, showcases Missouri history. It is operated by the Missouri Historical Society, which was founded in 1866.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouri+history+museum/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b54ed1946807:0xec3f438953c3b266!2m2!1d-90.2857383!2d38.6452478", "https://mohistory.org/museum");
//        Attraction attraction2 = new Attraction("Museums", "Saint Louis Art Museum", "The Saint Louis Art Museum is one of the principal U.S. art museums, with paintings, sculptures, cultural objects, and ancient masterpieces from all corners of the world", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+art+museum/@38.7514168,-92.639295,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5576e47b955:0x97a4b1dc139c963a!2m2!1d-90.2944911!2d38.6393062", "https://www.slam.org/");
//        Attraction attraction3 = new Attraction("Museums", "City Museum", "City Museum is a museum whose exhibits consist largely of repurposed architectural and industrial objects, housed in the former International Shoe building in the Washington Avenue Loft District of St. Louis, Missouri, United States", "https://www.google.com/maps/dir//city+museum+st+louis/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b33dc2801e55:0xc97c4420308aca04?sa=X&ved=2ahUKEwjUq9uzyv_yAhUdSvEDHZqDAWUQ9Rd6BAhzEAU", "https://www.citymuseum.org/");
//        Attraction attraction4 = new Attraction("Restaurants", "Sauce on the side", "We think there’s something special about fresh food. That’s why we make everything from scratch here at Sauce on the Side. Our handmade calzones. Our salad dressings. Even our desserts. It’s all made right here.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouribotanicalgarden/@38.7514168,-92.6179286,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4ffa9d2cd81:0x60b0c580fcde5080!2m2!1d-90.2593798!2d38.6127672", "https://www.missouribotanicalgarden.org/");
//        Attraction attraction5 = new Attraction("Restaurants", "Tempus", "Opened in fall 2020, Tempus is the highly anticipated restaurant by acclaimed chef Ben Grupe", "https://www.google.com/maps/dir/38.9329,-76.9988664/tempus+stl/@38.7514168,-92.6168587,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b544bd25e4c1:0xa3bc1f101969f942!2m2!1d-90.259435!2d38.6265236", "https://www.tempusstl.com/");
//        Attraction attraction6 = new Attraction("Restaurants", "Boathouse at Forest Park", "Relaxed spot for a drink & casual dining with a waterside view, plus paddleboat rentals", "https://www.google.com/maps/dir/38.9329,-76.9988664/boathouse+at+forest+park/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5467b225aeb:0x757c053b7aa25117!2m2!1d-90.2847884!2d38.6397716", "https://boathousestl.com/");
//        Attraction attraction7 = new Attraction("Events", "Saint Louis Science Center", "The Saint Louis Science Center, founded as a planetarium in 1963, is a collection of buildings including a science museum and planetarium in St. Louis, Missouri, on the southeastern corner of Forest Park.", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+science+center/@38.7514168,-92.630554,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b51805d969d7:0xaf3c05404eeb4c78!2m2!1d-90.270419!2d38.6289922", "https://www.slsc.org/");
//        Attraction attraction8 = new Attraction("Events", "Saint Louis Zoo", "The Saint Louis Zoo, officially the Saint Louis Zoological Park, is a zoo in Forest Park, St. Louis, Missouri. It is recognized as a leading zoo in animal management, research, conservation, and education", "https://www.google.com/maps/dir/38.9329,-76.9988664/saint+louis+zoo/@38.7514168,-92.639295,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b55ccc04062d:0x6075080197e8e830!2m2!1d-90.2913381!2d38.6350239", "https://www.stlzoo.org/");
//        Attraction attraction9 = new Attraction("Events", "Missouri Botanical Garden", "The Missouri Botanical Garden is a botanical garden located at 4344 Shaw Boulevard in St. Louis, Missouri. It is also known informally as Shaw's Garden for founder and philanthropist Henry Shaw.", "https://www.google.com/maps/dir/38.9329,-76.9988664/missouri+botanical+garden+address+link/@38.7514168,-92.6179286,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4ffa9d2cd81:0x60b0c580fcde5080!2m2!1d-90.2593798!2d38.6127672", "https://www.missouribotanicalgarden.org/");
//        Attraction attraction10 = new Attraction("Parks", "Citygarden Sculpture Park", "Citygarden is an urban park and sculpture garden in St. Louis, Missouri owned by the City of St. Louis but maintained by the Gateway Foundation.", "https://www.google.com/maps/dir/38.9329,-76.9988664/city+garden+sculpture+park+st+louis/@38.7514168,-92.5854472,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b3197dd7cdf9:0xab91dcb20aeb6124!2m2!1d-90.1937073!2d38.6266804", "http://www.citygardenstl.org/");
//        Attraction attraction11 = new Attraction("Parks", "Willmore Park", "Large, tranquil natural area with multiple lakes, sport fields & courts, picnic spots & play areas", "https://www.google.com/maps/dir/38.9329,-76.9988664/willmore+park/@38.7514168,-92.6395304,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b4545bbb518b:0x3be971e61cc6f868!2m2!1d-90.3039214!2d38.5733606", "https://www.stlouis-mo.gov/government/departments/parks/parks/browse-parks/view-park.cfm?parkID=93&parkName=Willmore");
//        Attraction attraction12 = new Attraction("Parks", "Forest Park", "Forest Park is a public park in western St. Louis, Missouri. It is a prominent civic center and covers 1,326 acres. Opened in 1876, more than a decade after its proposal, the park has hosted several significant events", "https://www.google.com/maps/dir/38.9329,-76.9988664/forest+park+st+louis/@38.7514168,-92.6300663,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b5469178c4c9:0x9d27c5026db294aa!2m2!1d-90.2830635!2d38.6380167", "https://forestparkmap.org/");
//        Attraction attraction13 = new Attraction("Historical", "Union Station", "The city known for being the gateway to the West suddenly became a gateway to all of America. Over the next several years, Union Station would become one of the largest and busiest passenger rail terminals in the world.", "https://www.google.com/maps/dir//union+station+st+louis/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b346a315791d:0x6204ffe04ef3d2d3?sa=X&ved=2ahUKEwjp9_32zv_yAhV4GFkFHSb0DF0Q9Rd6BAgMEAU", "https://www.stlouisunionstation.com/");
//        Attraction attraction14 = new Attraction("Historical", "The Gateway Arch", "Gateway Arch National Park is an American national park located in St. Louis, Missouri, near the starting point of the Lewis and Clark Expedition", "https://www.google.com/maps/dir/38.9329,-76.9988664/the+gateway+arch+national+park/@38.7514168,-92.5800578,5z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x87d8b2e26e15bcb5:0xf8383c57426ed4f1!2m2!1d-90.1837533!2d38.6274334", "https://www.gatewayarch.com/");
//        Attraction attraction15 = new Attraction("Historical", "Campbell House Museum", "The Campbell House Museum opened on February 6, 1943, and is in the Greater St. Louis area, in the U.S. state of Missouri.", "https://www.google.com/maps/dir//campbell+house+museum/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x87d8b315f6e5c041:0x46c6bf0a7ce22447?sa=X&ved=2ahUKEwjey9_Cz__yAhWBGFkFHbsgCKgQ9Rd6BAhyEAU", "http://www.campbellhousemuseum.org/");
//        list.add(attraction1);
//        list.add(attraction2);
//        list.add(attraction3);
//        list.add(attraction4);
//        list.add(attraction5);
//        list.add(attraction6);
//        list.add(attraction7);
//        list.add(attraction8);
//        list.add(attraction9);
//        list.add(attraction10);
//        list.add(attraction11);
//        list.add(attraction12);
//        list.add(attraction13);
//        list.add(attraction14);
//        list.add(attraction15);
//
//
//        return list;
//    }
//}