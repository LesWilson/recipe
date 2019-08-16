package dev.leswilson.recipe.repositories;

import dev.leswilson.recipe.model.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository repository;

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> teaspoon = repository.findByDescription("Teaspoon");
        assertThat(teaspoon.isPresent(), is(true));
        assertThat(teaspoon.get().getDescription(), is("Teaspoon"));
    }
}