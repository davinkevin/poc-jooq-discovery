package com.github.davinkevin.poc.jooqdiscovery.controller.api;

import com.github.davinkevin.poc.jooqdiscovery.entity.Author;
import com.github.davinkevin.poc.jooqdiscovery.repository.AuthorRepository;
import io.vavr.collection.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by kevin on 14/07/2017.
 */
@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("{id}")
    public Author findOne(@PathVariable("id") UUID id) {
        return authorRepository.findOne(id);
    }

    @GetMapping
    public Set<Author> findAll() {
        return authorRepository.findAll();
    }

    @PostMapping()
    public Author create(@RequestBody Author author) {
        return authorRepository.create(author);
    }

    @PutMapping("{id}")
    public Author update(@RequestBody Author author, @PathVariable("id") UUID id) {
        author.setId(id);
        return authorRepository.update(author);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        authorRepository.delete(id);
    }

}
