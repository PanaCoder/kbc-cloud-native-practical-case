package com.ezgroceries.shoppinglist.out;

import com.ezgroceries.shoppinglist.model.Cocktail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class CocktailDBResponse {

    @Getter
    @Setter
    private List<DrinkResource> drinks = new ArrayList<>();

    public List<Cocktail> toCocktails() {
        return drinks.stream()
                .map(DrinkResource::toCocktail)
                .toList();
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class DrinkResource {
        private String idDrink;
        private String strDrink;
        private String strGlass;
        private String strInstructions;
        private String strDrinkThumb;
        private String strIngredient1;
        private String strIngredient2;
        private String strIngredient3;
        private String strIngredient4;
        private String strIngredient5;

        public Cocktail toCocktail() {
            return new Cocktail()
                    .setIdDrink(idDrink)
                    .setName(strDrink)
                    .setGlass(strGlass)
                    .setInstructions(strInstructions)
                    .setImage(strDrinkThumb)
                    .setIngredients(Stream.of(
                            strIngredient1,
                            strIngredient2,
                            strIngredient3,
                            strIngredient4,
                            strIngredient5)
                            .filter(StringUtils::isNoneBlank)
                            .collect(Collectors.toSet()));
        }
    }
}
