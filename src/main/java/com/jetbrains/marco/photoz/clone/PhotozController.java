package com.jetbrains.marco.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotozController {

    private List<Photo> db = List.of(new Photo("1","hello.jpg"));
    private Map<String, Photo> db_by_id = new HashMap<>(){{
        put("1", new Photo("1","hellp.jpg"));
    }};

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
    @GetMapping("/photoz")
    public List<Photo> get(){
        return db;
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db_by_id.get(id);
        if (photo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }
}
