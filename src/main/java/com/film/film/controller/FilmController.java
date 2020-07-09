package com.film.film.controller;


import com.film.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/films")
    public String filmSayfasi(Model model){
        model.addAttribute("films",filmRepository.findAll());
        System.out.println(filmRepository.findAll().toString());
        return "films";
    }
}
