package dev.leswilson.recipe.controllers;

import dev.leswilson.recipe.model.Recipe;
import dev.leswilson.recipe.services.RecipeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @InjectMocks
    RecipeController controller;
    @Mock
    Model model;
    @Mock
    RecipeServiceImpl service;

    @Test
    void recipeList() {
        // Given
        List recipes = Arrays.asList(new Recipe(), new Recipe());

        when(service.list()).thenReturn(recipes);

        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        String viewName = controller.recipeList(model);

        // Then
        assertThat(viewName, is("recipes/list"));
        verify(service, times(1)).list();
        verify(model, times(1)).addAttribute(eq("recipes"), anyList());
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        List<Recipe> list = argumentCaptor.getValue();
        assertThat(list, hasSize(2));
    }


    @Test
    public void getIndexPage() throws Exception {
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
        mvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/list"));

        mvc.perform(get("/recipes/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/list"));
    }
}