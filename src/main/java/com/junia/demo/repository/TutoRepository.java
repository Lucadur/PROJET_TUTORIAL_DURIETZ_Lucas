package com.junia.demo.repository;

import com.junia.demo.repository.entity.Tutorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoRepository extends CrudRepository<Tutorial, Long> {

}
