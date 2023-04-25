package com.ezgroceries.shoppinglist.model;

import com.ezgroceries.shoppinglist.util.StringSetConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "id_drink")
    private String idDrink;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients = new HashSet<>();
    @OneToMany(mappedBy = "cocktail")
    private Set<CocktailShoppingList> cocktailShoppingLists = new HashSet<>();
}
