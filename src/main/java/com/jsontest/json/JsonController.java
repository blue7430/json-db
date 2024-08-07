package com.jsontest.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class JsonController {
    @Autowired
    private JsonService jsonService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/save-json")
    @ResponseBody
    public String saveJsonData(){
        jsonService.init();
        return "Data saved successfully!";
    }

    @GetMapping("/jsons")
    @ResponseBody
    public List<Json> getAllJsons(){
        return jsonService.getAllJsons();

    }

}
