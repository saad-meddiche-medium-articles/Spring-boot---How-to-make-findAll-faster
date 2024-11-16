package com.example.demo.repositories;

import com.example.demo.entities.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModifiedAuthorRepository extends JpaRepository<Author,Long> {

    @Override @EntityGraph(attributePaths = {"books"})
    List<Author> findAll();
}
