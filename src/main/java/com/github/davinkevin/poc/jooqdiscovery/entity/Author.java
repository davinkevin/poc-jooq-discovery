package com.github.davinkevin.poc.jooqdiscovery.entity;

import lombok.Data;

import java.util.UUID;

/**
 * Created by kevin on 14/07/2017.
 */
@Data
public class Author {

    private UUID id;
    private String firstName;
    private String lastName;

}
