package com.jsontest.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {
    @Autowired
    private JsonService jsonService;

    @GetMapping("/jsons")
    public List<Json> getAllJsons(){
        return jsonService.getAllJsons();

    }

}
