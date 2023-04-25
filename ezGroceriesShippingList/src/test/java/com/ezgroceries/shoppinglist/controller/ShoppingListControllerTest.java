package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShoppingListController.class)
@AutoConfigureMockMvc(addFilters = false)
class ShoppingListControllerTest {

    private final static String COCKTAIL_ID = "123";
    private static ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createShoppingList() throws Exception {
        var requestBody = objectMapper.writeValueAsString(new ShoppingList()
                .setName("shoppingListName"));

        mockMvc.perform(post("/shopping-lists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    void addCocktailToShoppingList() throws Exception {
        var requestBody = objectMapper.writeValueAsString(new Cocktail()
                .setIdDrink("123"));

        mockMvc.perform(post("/shopping-lists/{cocktailId}}/cocktails", COCKTAIL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    void getShoppingList() throws Exception {
        mockMvc.perform(get("/shopping-lists/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllShoppingLists() throws Exception {
        mockMvc.perform(get("/shopping-lists")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}