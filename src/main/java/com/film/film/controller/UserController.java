package com.film.film.controller;

import com.film.film.model.User;
import com.film.film.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profil")
    public String profilSayfasi(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (principal instanceof UserDetails) ? ((UserDetails)principal).getUsername() : principal.toString();
        Optional<User> user = userRepository.findByUsername(username);
        model.addAttribute("user",user.get());
        return "profil";
    }
}
