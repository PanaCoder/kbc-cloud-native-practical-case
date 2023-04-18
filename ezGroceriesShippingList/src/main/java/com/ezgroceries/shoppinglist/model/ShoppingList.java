package com.ezgroceries.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
public class ShoppingList {

    private String shoppingListId;
    private String name;
    private List<Cocktail> cocktails = new ArrayList<>();
    private List<String> ingredients = getIngredients();

    //    @JsonProperty("ingredients")
    public List<String> getIngredients() {
        return List.of("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao");
    }
}
