package com.film.film.controller;

import com.film.film.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/actor")
    public String actorSayfasi(Model model){
        return "actor";
    }
}
