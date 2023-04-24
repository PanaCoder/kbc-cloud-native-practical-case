package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.out.CocktailDBClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ezgroceries.shoppinglist.util.HttpParams.SEARCH;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailDBClient cocktailDBClient;

    @GetMapping("/cocktails")
    public ResponseEntity<List<Cocktail>> getCocktails(@RequestParam(value = SEARCH) String search) {
        log.info("--- LOG --- Getting cocktails...");
        return ResponseEntity.ok(cocktailDBClient.searchCocktails(search).toCocktails());
    }
}
