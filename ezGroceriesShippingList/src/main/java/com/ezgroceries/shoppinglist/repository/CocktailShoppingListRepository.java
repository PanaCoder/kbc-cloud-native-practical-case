package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.CocktailShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CocktailShoppingListRepository extends JpaRepository<CocktailShoppingList, UUID> {

}
