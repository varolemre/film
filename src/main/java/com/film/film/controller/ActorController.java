package com.film.film.controller;

import com.film.film.model.Actor;
import com.film.film.model.Film;
import com.film.film.repository.ActorRepository;
import com.film.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/actors")
    public String actorSayfasi(Model model) {
    List<String> actorFilms = new ArrayList<>();
    List<Film> filmList = filmRepository.findAll();
    List<Actor> actors2 = actorRepository.findAll();
    for (Actor actor : actors2){
        for (Film f: filmList){
            List<Actor> actors = f.getActors();
            for (Actor a: actors){
                if(a.getId()==actor.getId()){
                    actorFilms.add(f.getName());
                }
            }
            actor.setFilms(actorFilms);
        }
    }

   model.addAttribute("actors",actors2);
    return "actors";
    }
}
