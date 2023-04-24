package com.ezgroceries.shoppinglist.model;


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
public class Cocktail {

    @Id
    UUID id;

    private String cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private List<String> ingredients = new ArrayList<>();

}
