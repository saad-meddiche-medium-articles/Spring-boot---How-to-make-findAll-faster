package com.example.demo.conditions;

import org.springframework.context.annotation.Profile;

@Profile("local")
public class AuthorSeederEnabledCondition extends SeederEnabledCondition {

    @Override
    protected String key() {
        return "author-seeder.enabled";
    }

}
