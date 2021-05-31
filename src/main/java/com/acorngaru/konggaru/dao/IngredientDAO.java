package com.acorngaru.konggaru.dao;

import com.acorngaru.konggaru.mapper.IngredientMapper;
import com.acorngaru.konggaru.model.Ingredient;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Repository
public class IngredientDAO implements IngredientMapper {

    @Autowired
    private SqlSessionTemplate sqlSession;

    protected static final String NAMESPACE = "com.acorngaru.konggaru.mapper.IngredientMapper";

    @Override
    public List<Ingredient> searchIngredient(HashMap<String, String> map) {
        List<Ingredient> searchlist = sqlSession.selectList(NAMESPACE + ".searchIngredient", map);
        return searchlist;

    }
    @Override
    public List<Ingredient> allIngredient() {
        return sqlSession.selectList(NAMESPACE +".ingredientAllList");
    }

    @Override
    public int countIngredientByName(String name) {
        int amount = sqlSession.selectOne(NAMESPACE +".countIngredientByName","");
        return amount;
    }
}
