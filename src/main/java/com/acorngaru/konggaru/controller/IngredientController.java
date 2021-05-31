package com.acorngaru.konggaru.controller;

import com.acorngaru.konggaru.model.Page;
import com.acorngaru.konggaru.service.IngredientService;
import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Slf4j
@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IngredientService service;

    @PostMapping(value = "/list")
    public void showHome(
            @RequestParam("selectName") String name,
            @RequestParam("pageNo") int pageNo,
            HttpServletResponse res ) throws IOException {
        Page p = new Page();
        p.setPageCount(5);
        p.setCurrentPageNo(pageNo);
        HashMap<String,String> map = new HashMap<>();
        p.process(5,pageNo, service.countIngredientByName(name),service.allIngredient());

        map.put("first" , Integer.toString((p.getCurrentPageNo()-1)*p.getRows()+1));
        map.put("last", Integer.toString(p.getCurrentPageNo()*p.getRows()));
        map.put("name",name);
        System.out.println(map);
        System.out.println("=============================");
        p.setItems(service.searchIngredient(map));

        ObjectMapper om = new ObjectMapper();

        String json = om.writeValueAsString(p);

        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println(json);

    }
}
