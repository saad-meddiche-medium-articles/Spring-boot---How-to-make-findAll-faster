package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private Long id;

    private String firstName;

    private String lastName;
}
