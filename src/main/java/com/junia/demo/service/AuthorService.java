package com.junia.demo.service;

import com.junia.demo.repository.AuthorRepository;
import com.junia.demo.repository.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthor(String authorEmail) {
      return authorRepository.findByEmail(authorEmail);
    }
    public Author createAuthor(Author author) {
    return authorRepository.save(author);
    }
}
