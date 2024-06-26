package com.junia.demo.controller;

import com.junia.demo.repository.AuthorRepository;
import com.junia.demo.repository.TutoRepository;
import com.junia.demo.repository.entity.Author;
import com.junia.demo.repository.entity.Tutorial;
import com.junia.demo.service.AuthorService;
import com.junia.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;

@Controller
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/tutorials")
    public String displayTutorialList(Model model){
        Iterable<Tutorial> tutorialList = tutorialService.fetchTuto();
        model.addAttribute("newTutorial", new Tutorial("", LocalDate.now(), 0L, "", new Author()));
        model.addAttribute("tutos", tutorialList);
        return "tutoList";
    }

    @PostMapping("/createTutorial")
    public String addTutorial(@ModelAttribute Tutorial newTutorial,
                              @RequestParam("authorEmail") String authorEmail) {
        // Recherche de l'auteur par email
        Author author = authorService.findAuthor(authorEmail);
        if (author == null) {
            // Gérer le cas où l'auteur n'existe pas
            return "redirect:/tutorials";
        }

        // Associer l'auteur au tutoriel
        newTutorial.setAuthor(author);

        // Ajouter le nouveau tutoriel à la base de données
        tutorialService.addNewTutorial(newTutorial);
        return "redirect:/tutorials";
    }

    @PostMapping("/deleteTutorial")
    public String deleteTutorial(@RequestParam("id") Long id) {
        // Supprimer le tutoriel de la base de données en utilisant son ID
        tutorialService.deleteTutorial(id);
        return "redirect:/tutorials";
    }

    @PostMapping("/updateTutorial")
    public String updateTutorial(@ModelAttribute Tutorial updatedTutorial,
                                 @RequestParam("authorEmail") String authorEmail) {
        // Recherche de l'auteur par email
        Author author = authorService.findAuthor(authorEmail);
        if (author == null) {
            // Gérer le cas où l'auteur n'existe pas
            return "redirect:/tutorials";
        }

        // Associer l'auteur au tutoriel
        updatedTutorial.setAuthor(author);

        // Mettre à jour le tutoriel dans la base de données en utilisant la méthode save
        tutorialService.modifyTutorial(updatedTutorial);
        return "redirect:/tutorials";
    }

}
