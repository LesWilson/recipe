package dev.leswilson.recipe.controllers;

import dev.leswilson.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"/list", ""})
    public String recipeList(Model model) {
        model.addAttribute("recipes", recipeService.list());
        return "recipes/list";
    }
}
