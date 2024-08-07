package com.jsontest.json;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Json {
    @Id
    @Setter
    private Long user_id;
    private String username;
    private Integer post_count;

    public Long getuserId(){
        return user_id;
    }
    public void setuserId(Long user_id){
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
