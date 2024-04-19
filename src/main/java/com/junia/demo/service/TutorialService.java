package com.junia.demo.service;

import com.junia.demo.repository.TutoRepository;
import com.junia.demo.repository.entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    @Autowired
    private TutoRepository tutoRepository;
   public List<Tutorial> fetchTuto() {
        return (List<Tutorial>) tutoRepository.findAll();
    }
    public Tutorial addNewTutorial(Tutorial newTutorial) {
    return tutoRepository.save(newTutorial);
    }

    public void deleteTutorial( Long id){
     tutoRepository.deleteById(id);
    }

    public Tutorial modifyTutorial(Tutorial updatedTutorial) {
        return tutoRepository.save(updatedTutorial);
    }
}
