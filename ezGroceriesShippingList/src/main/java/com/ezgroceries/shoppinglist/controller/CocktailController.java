package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.model.Cocktail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.ezgroceries.shoppinglist.util.HttpParams.SEARCH;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CocktailController {

    @GetMapping("/cocktails")
    public ResponseEntity<List<Cocktail>> getCocktails(@RequestParam(value = SEARCH) String search) {
        log.info("--- LOG --- Getting cocktails...");
        return ResponseEntity.ok().body(getCocktails());
    }

    private List<Cocktail> getCocktails() {
        return List.of(
                new Cocktail()
                        .setCocktailId(UUID.randomUUID().toString())
                        .setName("Margerita")
                        .setGlass("Cocktail glass")
                        .setInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..")
                        .setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")
                        .setIngredients(List.of("Tequila", "Triple sec", "Lime juice", "Salt")),
                new Cocktail()
                        .setCocktailId(UUID.randomUUID().toString())
                        .setName("Blue Margerita")
                        .setGlass("Cocktail glass")
                        .setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..")
                        .setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg")
                        .setIngredients(List.of("Tequila", "Blue Curacao", "Lime juice", "Salt")));
    }
}
