package com.capgemini.wsb.fitnesstracker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FitnessTrackerController {

    @GetMapping("/")
    public String FitnessTracker() {
        return "index"; // Zwraca nazwę widoku, np. index.html
    }
}

