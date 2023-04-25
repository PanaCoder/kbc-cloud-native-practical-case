package com.ezgroceries.shoppinglist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "cocktail_shopping_list")
public class CocktailShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "cocktail_id", nullable = false)
    private UUID cocktailId;
    @Column(name = "shopping_list_id", nullable = false)
    private UUID shoppingListId;
    @ManyToOne
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "id", updatable = false, insertable = false)
    private ShoppingList shoppingList;
    @ManyToOne
    @JoinColumn(name = "cocktail_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Cocktail cocktail;
}
