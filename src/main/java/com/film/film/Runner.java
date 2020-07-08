package com.film.film;

import com.film.film.model.Actor;
import com.film.film.model.Film;
import com.film.film.repository.ActorRepository;
import com.film.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    FilmRepository filmRepository;
    @Override
    public void run(String... args) throws Exception {
        Actor actor = new Actor("Emre","Varol","MALE",1996);
        Actor actor2 = new Actor("Ufuk","Güler","MALE",1996);
        List<Actor> actors = new ArrayList<>();
        actors.add(actor);
        actors.add(actor2);
        List<String> languages = new ArrayList<>();
        languages.add("EN");
        languages.add("TR");

        Film film = new Film("World War Z","2016","Action","Zombies","-",languages, actors);

        actorRepository.save(actor);
        actorRepository.save(actor2);

        filmRepository.save(film);
    }
}
