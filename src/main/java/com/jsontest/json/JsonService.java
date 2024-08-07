package com.jsontest.json;

import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

    @Service
    public class JsonService {
        @Autowired
        private JsonRepository jsonRepository;


        //json 파일 경로지정
        public void init() {
            String jsonFilePath = "data.json";
            //data.json 자리에 다른 json 파일로 변경해서 다른 데이터 저장 가능

        Gson gson = new Gson();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(jsonFilePath)) {
            if(inputStream == null){
                throw new IOException("파일을 찾을수 없습니다: "+jsonFilePath);
            }
            Type jsonListType = new TypeToken<List<Json>>() {}.getType();
            List<Json> jsons = gson.fromJson(new InputStreamReader(inputStream), jsonListType);

            //데이터 저장
            jsonRepository.saveAll(jsons);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public  List<Json> getAllJsons(){
            return jsonRepository.findAll();
    }

    public int calculateSum(){
            List<Json> jsons = jsonRepository.findAll();
            return jsons.stream().mapToInt(Json::getcount).sum();
    }
}