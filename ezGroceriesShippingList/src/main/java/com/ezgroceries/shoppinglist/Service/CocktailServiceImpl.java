package com.ezgroceries.shoppinglist.Service;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CocktailServiceImpl implements CocktailService {

    private final CocktailRepository cocktailRepository;

    @Override
    public List<Cocktail> create(List<Cocktail> cocktailList) {
        var existingDbCocktails = getDbCocktails(cocktailList);

        var cocktailsToPersist = cocktailList.stream()
                .filter(cocktail -> existingDbCocktails.get(cocktail.getIdDrink()) == null)
                .toList();

        return cocktailRepository.saveAll(cocktailsToPersist);
    }

    private Map<String, Cocktail> getDbCocktails(List<Cocktail> cocktailList) {
        var cocktailIds = cocktailList.stream()
                .map(Cocktail::getIdDrink)
                .toList();
        return cocktailRepository.findAllByIdDrinkIn(cocktailIds).stream()
                .collect(Collectors.toMap(Cocktail::getIdDrink, o -> o, (o, o2) -> o));
    }
}
