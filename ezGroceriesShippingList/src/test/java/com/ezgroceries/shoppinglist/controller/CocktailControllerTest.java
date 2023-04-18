package com.ezgroceries.shoppinglist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CocktailController.class)
@AutoConfigureMockMvc(addFilters = false)
class CocktailControllerTest {

    private final static String SEARCH = "search";
    private final static String NAME = "name";
    private final static String COCKTAIL_ID = "cocktailId";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCocktails() throws Exception {

        mockMvc.perform(get("/cocktails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param(SEARCH, "Margarita"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*]", hasSize(2)))
                .andExpect(jsonPath("$.[0].name").value("Margerita"))
                .andExpect(jsonPath("$.[1].name").value("Blue Margerita"));
    }

//    @Test
//    void createShoppingList() throws Exception {
//
//        mockMvc.perform(post("/shopping-lists")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .param(NAME, "Stephanie's birthday"))
//                .andExpect(status().isCreated());
//    }

//    @Test
//    void addCocktailsToShoppingList() throws Exception {
//
//        mockMvc.perform(post("/shopping-lists/123/cocktails")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .param(COCKTAIL_ID, "cocktail123"))
//                .andExpect(status().isCreated());
//    }
}