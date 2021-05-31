package com.acorngaru.konggaru.service;

import com.acorngaru.konggaru.dao.IngredientDAO;
import com.acorngaru.konggaru.model.Ingredient;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public class IngredientService {
    @Autowired
    IngredientDAO dao ;



    public List<Ingredient> searchIngredient(HashMap<String, String> map) {
        List<Ingredient> searchlist = dao.searchIngredient(map);
        return searchlist;
    }
    public List<Ingredient> allIngredient() {
        return dao.allIngredient();
    }
    public int countIngredientByName(String name) {
        int amount = dao.countIngredientByName(name);
        return amount;
    }

}