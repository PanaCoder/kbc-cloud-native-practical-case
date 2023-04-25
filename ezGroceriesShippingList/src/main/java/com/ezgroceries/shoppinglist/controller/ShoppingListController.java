package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShoppingListController {
//
//    @PostMapping("/shopping-lists")
//    public ResponseEntity<Void> createShoppingList(@RequestBody ShoppingList shoppingList) {
//        log.info("--- LOG --- POST cocktails...");
//        if (!Objects.nonNull(shoppingList.getName()))
//            shoppingList.setName("ShopingListName");
//
//        var newResource = new ShoppingList()
//                .setShoppingListId(UUID.randomUUID().toString())
//                .setName(shoppingList.getName());
//        return entityWithLocation(newResource.getShoppingListId());
//    }
//
//    @PostMapping("/shopping-lists/{shoppingListId}/cocktails")
//    public ResponseEntity<Void> addCocktailToShoppingList(@PathVariable String shoppingListId,
//                                                          @RequestBody Cocktail cocktail) {
//        log.info("--- LOG --- add cocktails to shopping list...");
//        if (!Objects.nonNull(cocktail.getIdDrink()))
//            cocktail.setIdDrink(UUID.randomUUID().toString());
//
//        return entityWithLocation(cocktail.getIdDrink());
//    }
//
//    @GetMapping("/shopping-lists/{shoppingListId}")
//    public ResponseEntity<ShoppingList> getShoppingList(@PathVariable String shoppingListId) {
//        log.info("--- LOG --- GET shopping list...");
//        return ResponseEntity.ok().body(getShoppingList());
//    }
//
//    @GetMapping("shopping-lists")
//    public ResponseEntity<List<ShoppingList>> getAllShoppingLists() {
//        log.info("--- LOG --- GET all shopping lists...");
//        return ResponseEntity.ok().body(getShoppingLists());
//    }
//
//    private ShoppingList getShoppingList () {
//        return new ShoppingList()
//                .setShoppingListId("90689338-499a-4c49-af90-f1e73068ad4f")
//                .setName("Stephanie's birthday");
//    }
//
//    private List<ShoppingList> getShoppingLists() {
//        return List.of(
//                new ShoppingList()
//                        .setShoppingListId("4ba92a46-1d1b-4e52-8e38-13cd56c7224c")
//                        .setName("Stephanie's birthday"),
//                new ShoppingList()
//                        .setShoppingListId("6c7d09c2-8a25-4d54-a979-25ae779d2465")
//                        .setName("My Birthday"));
//    }
//
//    private ResponseEntity<Void> entityWithLocation(Object resourceId) {
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequestUri()
//                .path("/{resourceId}")
//                .buildAndExpand(resourceId)
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
}
