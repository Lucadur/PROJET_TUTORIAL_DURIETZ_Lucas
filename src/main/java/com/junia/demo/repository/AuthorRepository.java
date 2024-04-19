package com.junia.demo.repository;

import com.junia.demo.repository.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long >{
    Author findByEmail(String email);
}