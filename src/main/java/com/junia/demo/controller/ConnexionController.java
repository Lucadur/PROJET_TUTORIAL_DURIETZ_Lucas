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
public class ConnexionController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/connexion")
    public String showConnexionForm(Model model) {
        model.addAttribute("author", new Author());
        return "connexionPage";
    }

    @PostMapping("/login")
    public String processLogin(Author author, Model model) {
        // Vérifiez si l'e-mail de l'auteur existe dans la base de données
        Author existingAuthor = authorService.findAuthor(author.getEmail());
        if (existingAuthor == null || !existingAuthor.getPassword().equals(author.getPassword())) {
            // Si l'e-mail n'existe pas ou si le mot de passe est incorrect, affichez un message d'erreur
            model.addAttribute("error", "Adresse e-mail ou mot de passe incorrect.");
            return "connexionPage"; // Afficher à nouveau la page de connexion avec le message d'erreur
        }

        // Authentification réussie, redirigez vers une page de profil ou une autre page sécurisée
        return "redirect:/tutorials";
    }
}
