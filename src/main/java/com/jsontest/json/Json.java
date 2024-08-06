package com.jsontest.json;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Json {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private Integer post_count;

    public Long getId(){
        return user_id;
    }
    public void setId(Long user_id){
        this.user_id = user_id;
    }
    public String getname(){
        return username;
    }
    public void setname(String username){
        this.username = username;
    }
    public Integer getcount(){
        return post_count;
    }
    public void setcount(Integer post_count){
        this.post_count = post_count;
    }
}
