package com.jsontest.json;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JsonController {
    private final JsonRepository jsonRepository;

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
    String Jsons(Model model){
        List<Json> result = jsonRepository.findAll();
        model.addAttribute("jsons", result);
        return "jsons";
    }

    @GetMapping("/sum")
    public String getSum(Model model){
        int sum = jsonService.calculateSum();
        model.addAttribute("sum", sum);
        return "sum";
    }


}
