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
        Author author = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();

        author.setBooks(generateBooks(author));

        return author;
    }

    private Book buildBook(Author author) {
        return Book.builder()
                .title(faker.book().title())
                .price(faker.number().randomDouble(2, 10, 100))
                .author(author)
                .build();
    }

    private List<Book> generateBooks(Author author) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < authorSeederProperties.getBookPerAuthor(); i++) {
            books.add(buildBook(author));
        }
        return books;
    }
}
