package dev.leswilson.recipe.services;

import dev.leswilson.recipe.model.Recipe;

import java.util.Optional;

public interface RecipeService {
    Iterable<Recipe> list();
    Optional<Recipe> getById(Long id);
    Recipe save(Recipe recipe);
}
