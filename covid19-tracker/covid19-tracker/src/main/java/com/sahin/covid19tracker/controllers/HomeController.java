package com.sahin.covid19tracker.controllers;

import com.sahin.covid19tracker.models.LocationStates;
import com.sahin.covid19tracker.services.Covid19DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Covid19DataServices covid19DataServices;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStates> allStates = covid19DataServices.getAllStates();
        int totalGlobalCases = allStates.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStates.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("totalGlobalCases",totalGlobalCases);
        model.addAttribute("locationStates", allStates);
        model.addAttribute("totalNewCases",totalNewCases);
        return "home";
    }

    @GetMapping("/deaths")
    public String deaths(Model model) {
        List<LocationStates> allStates = covid19DataServices.getAllStates();
        int totalGlobalCases = allStates.stream().mapToInt(stat -> stat.getLatestTotalDeaths()).sum();
        model.addAttribute("totalGlobalCases",totalGlobalCases);
        model.addAttribute("locationStates", allStates);
        return "deaths";
    }

    @GetMapping("/recovered")
    public String recovered(Model model) {
        List<LocationStates> allStates = covid19DataServices.getAllStates();
        int totalGlobalCases = allStates.stream().mapToInt(stat -> stat.getLatestTotalRecovered()).sum();
        model.addAttribute("totalGlobalCases",totalGlobalCases);
        model.addAttribute("locationStates", allStates);
        return "recovered";
    }

}
