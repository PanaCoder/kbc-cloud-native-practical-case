package com.ezgroceries.shoppinglist.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String shoppingListId;
    private String name;
    private List<Cocktail> cocktails = new ArrayList<>();
    private List<String> ingredients = getIngredients();

    //    @JsonProperty("ingredients")
    public List<String> getIngredients() {
        return List.of("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao");
    }
}
