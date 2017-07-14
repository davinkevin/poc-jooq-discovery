package com.github.davinkevin.poc.jooqdiscovery.repository;

import com.github.davinkevin.poc.jooqdiscovery.entity.Author;
import io.vavr.collection.Set;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.github.davinkevin.poc.jooqdiscovery.h2.Tables.AUTHOR;
import static io.vavr.collection.HashSet.collector;

/**
 * Created by kevin on 14/07/2017.
 */
@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final DSLContext dsl;

    public Set<Author> findAll() {
        return dsl
                .selectFrom(AUTHOR).fetch()
                .into(Author.class)
                .stream()
                .collect(collector());
    }

    public Author findOne(UUID id) {
        return dsl.selectFrom(AUTHOR)
                .where(AUTHOR.ID.equal(id))
                .fetchOneInto(Author.class);
    }

    public Author create(Author author) {
        UUID id = UUID.randomUUID();

        dsl
                .insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .values(id, author.getFirstName(), author.getLastName())
                .execute();

        return findOne(id);
    }

    public Author update(Author author) {
        dsl.update(AUTHOR)
            .set(AUTHOR.FIRST_NAME, author.getFirstName())
            .set(AUTHOR.LAST_NAME, author.getLastName())
            .execute();

        return findOne(author.getId());
    }

    public void delete(UUID id) {
        dsl.deleteFrom(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .execute();
    }
}
