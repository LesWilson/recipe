package dev.leswilson.recipe.services;

import dev.leswilson.recipe.model.Recipe;
import dev.leswilson.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository repository;

    @BeforeEach
    void setUp() {
//        recipeService = new RecipeServiceImpl(repository);
    }

    @Test
    void list() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("My Recipe");
        when(repository.findAll()).thenReturn(Arrays.asList(recipe));
        Iterable<Recipe> list = recipeService.list();
        assertThat(list, is(notNullValue()));
        assertThat(list, hasItem(recipe));
        verify(repository, times(1)).findAll();
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }
}