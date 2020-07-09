package com.film.film;

import com.film.film.model.Actor;
import com.film.film.model.Film;
import com.film.film.model.User;
import com.film.film.repository.ActorRepository;
import com.film.film.repository.FilmRepository;
import com.film.film.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
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

        User user = new User();
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("fbfbfb333"));
        user.setActive(true);
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);
        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(new BCryptPasswordEncoder().encode("fbfbfb333"));
        user2.setActive(true);
        user2.setRole("ROLE_USER");
        userRepository.save(user2);
    }
}
