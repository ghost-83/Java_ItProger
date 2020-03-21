package org.ghost.controllers;

import org.ghost.models.Review;
import org.ghost.repositorys.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        model.put("name", "World");
        return "home";
    }

    @GetMapping("/music")
    public String music(Map<String, Object> model) {
        model.put("name", "Музыка");
        return "music";
    }

    @GetMapping("/moves")
    public String moves(Map<String, Object> model) {
        model.put("name", "Кино");
        return "moves";
    }
    @GetMapping("/move")
    public String move(Map<String, Object> model) {
        model.put("name", "Кино");
        return "move";
    }

    @GetMapping("/reviews")
    public String reviews(Map<String, Object> model) {
        Iterable<Review> reviews = reviewRepository.findAll();
        model.put("name", "World");
        model.put("reviews", reviews);
        return "reviews";
    }
}

