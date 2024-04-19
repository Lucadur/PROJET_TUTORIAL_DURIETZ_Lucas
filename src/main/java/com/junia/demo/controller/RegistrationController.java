package com.junia.demo.controller;

import com.junia.demo.repository.AuthorRepository;
import com.junia.demo.repository.entity.Author;
import com.junia.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("author", new Author());
        return "registrationPage";
    }

    @PostMapping("/register")
    public String processRegistration(Author author, Model model) {
        // Vérifiez si l'e-mail de l'auteur est déjà enregistré
        if (authorService.findAuthor(author.getEmail()) != null) {
            // Si l'e-mail est déjà utilisé, ajoutez un message d'erreur au modèle
            model.addAttribute("error", "L'adresse e-mail est déjà utilisée.");
            return "registrationPage"; // Afficher à nouveau la page de formulaire d'inscription avec le message d'erreur
        }

        // Enregistrez le nouvel auteur dans la base de données
        authorService.createAuthor(author);

        // Redirigez vers la page de connexion
        return "redirect:/connexion";
    }
}
