package com.example.demo.services;

import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.ModifiedAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final ModifiedAuthorRepository modifiedAuthorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> findAllAuthorsUsingEntityGraph(){
        return modifiedAuthorRepository.findAll();
    }
}
