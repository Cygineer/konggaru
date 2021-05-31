package com.acorngaru.konggaru.controller;

import com.acorngaru.konggaru.model.Ingredient;
import com.acorngaru.konggaru.service.IngredientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    IngredientService service;

    @RequestMapping(value = "/order")
    public String Order(ModelAndView modelAndView) throws  Exception{
        return "ingredient/order";
    }


    @RequestMapping(value = "/Ingredient/selectAll")
    public void selectAll(HttpServletResponse response) throws Exception{

        String name = "items";
        List<Ingredient> list = service.allIngredient();
        HashMap<String,List<Ingredient>> data = new HashMap<>();
        data.put(name,list);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(data);

        PrintWriter out = response.getWriter();
        out.println(json);





    }















}
