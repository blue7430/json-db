package com.jsontest.json;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JsonController {

    private final JsonRepository jsonRepository;

    @Transactional
    @PostMapping("/add")
    String addJson(Long user_id, String username, Integer post_count){
        Json json = new Json();
        json.setUser_id(user_id);
        json.setUsername(username);
        json.setPost_count(post_count);
        jsonRepository.save(json);
        return "redirect:/list";
    }

}
