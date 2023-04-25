package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.Service.CocktailService;
import com.ezgroceries.shoppinglist.Service.CocktailServiceImpl;
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
    private final CocktailService cocktailService;

    @GetMapping("/cocktails")
    public ResponseEntity<List<Cocktail>> getCocktails(@RequestParam(value = SEARCH) String search) {
        log.info("--- LOG --- Getting cocktails...");
        var cocktailsList = cocktailDBClient.searchCocktails(search).toCocktails();

        return ResponseEntity.ok(cocktailService.create(cocktailsList));
    }
}
