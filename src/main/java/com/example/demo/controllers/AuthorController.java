package com.example.demo.controllers;

import com.example.demo.entities.Author;
import com.example.demo.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/entity-graph")
    public List<Author> findAllAuthorsUsingEntityGraph() {
        return authorService.findAllAuthorsUsingEntityGraph();
    }

}
