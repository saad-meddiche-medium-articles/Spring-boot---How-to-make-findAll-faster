package com.example.demo.seeders;

import com.example.demo.conditions.AuthorSeederEnabledCondition;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.properties.AuthorSeederProperties;
import com.example.demo.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("local")
@RequiredArgsConstructor @Configuration
@Conditional(AuthorSeederEnabledCondition.class)
public class AuthorSeeder extends Seeder {

    private final AuthorRepository authorRepository;

    private final AuthorSeederProperties authorSeederProperties;

    private final Faker faker = new Faker();

    @Override
    public void seeding() {
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < authorSeederProperties.getAuthorCount(); i++) {
            authors.add(buildAuthor());
        }
        authorRepository.saveAll(authors);
    }

    private Author buildAuthor() {
        return Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .books(generateBooks())
                .build();
    }

    private Book buildBook() {
        return Book.builder()
                .title(faker.book().title())
                .price(faker.number().randomDouble(2, 10, 100))
                .build();
    }

    private List<Book> generateBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < authorSeederProperties.getBookPerAuthor(); i++) {
            books.add(buildBook());
        }
        return books;
    }
}
