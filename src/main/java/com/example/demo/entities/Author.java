package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Book> books;
}
