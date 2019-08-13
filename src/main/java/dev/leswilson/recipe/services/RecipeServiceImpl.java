package dev.leswilson.recipe.services;

import dev.leswilson.recipe.model.Recipe;
import dev.leswilson.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> list() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }
}
