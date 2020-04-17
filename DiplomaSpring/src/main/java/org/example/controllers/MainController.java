package org.example.controllers;

import org.example.models.Link;
import org.example.repositorys.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private LinkRepository linkRepository;

    String message = "";

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Link> links = linkRepository.findAll();
        model.addAttribute("links", links);
        model.addAttribute("message", message);
        message = "";
        return "home";
    }

    @PostMapping("/")
    public String linkSave(@RequestParam String title, @RequestParam String link, Model model) {
        System.out.println(title);
        if (title != "" && link != "") {
            Iterable<Link> lincDb = linkRepository.findAll();
            for(Link t : lincDb){
                if (title.equals(t.getTitle())){
                    model.addAttribute("message", "Введите другое имя для ссылки.");
                    model.addAttribute("links", lincDb);
                    model.addAttribute("title", title);
                    model.addAttribute("link", link);
                    return "home";
                }
            }

            Link dbLink = new Link();
            dbLink.setTitle(title);
            dbLink.setLink(link);

            linkRepository.save(dbLink);
            message = "Готово";
        }
        else
            message = "Заполните поля!";
        return "redirect:/";
    }
}

