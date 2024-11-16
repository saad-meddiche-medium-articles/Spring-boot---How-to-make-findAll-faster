package com.example.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Getter @Setter @Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "author-seeder")
public class AuthorSeederProperties {
    private boolean enabled;
    private Integer authorCount;
    private Integer bookPerAuthor;
}
