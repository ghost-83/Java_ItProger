package com.itproger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/music")
    public String music(Model model) {
        return "music";
    }

    @GetMapping("/moves")
    public String moves(Model model) {
        return "moves";
    }

    @GetMapping("/move")
    public String move(Model model) {
        return "move";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registr(Model model) {
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "user";
    }

    @PostMapping("/user")
    public String userSave(Model model) {
        return "redirect:/";
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        return "posts";
    }

    @GetMapping("/postSpring")
    public String getPostSpring(Model model){
        return "postSpring";
    }

    @GetMapping("/postFX")
    public String getPostsFX(Model model){
        return "postFX";
    }

    @GetMapping("/postAndroid")
    public String getPostsAndroid(Model model){
        return "postAndroid";
    }

    @GetMapping("/post")
    public String post(Model model){
        return "post";
    }

    @GetMapping("/post/new")
    public String newPosts(Model model){
        return "post-new";
    }

    @PostMapping("/post/new")
    public String newPostsSave(Model model){
        return "redirect:/posts";
    }

}

