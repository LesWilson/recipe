package dev.leswilson.recipe.services;

import dev.leswilson.recipe.model.Difficulty;
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
//        Optional<Recipe> optionalRecipe = this.getById(1L);
//        if(optionalRecipe.isPresent()) {
//            Recipe recipe = optionalRecipe.get();
//            recipe.setDifficulty(Difficulty.HARD);
//            this.save(recipe);
//        }

        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
