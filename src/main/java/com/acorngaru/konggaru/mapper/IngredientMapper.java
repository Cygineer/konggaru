package com.acorngaru.konggaru.mapper;

import com.acorngaru.konggaru.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
public interface IngredientMapper {
    public List<Ingredient> searchIngredient(HashMap<String, String> map);
    public List<Ingredient> allIngredient();
    public int countIngredientByName(String name);
}
