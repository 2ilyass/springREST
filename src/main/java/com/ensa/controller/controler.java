package com.ensa.controller;


import com.ensa.Dao.FriendDao;
import com.ensa.entities.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class controler {


    @Autowired
    FriendDao dao;

    @GetMapping("/friend")
    Iterable<Friend> allFriends(){
        return dao.findAll();
    }

    @PostMapping("/friend")
    public Friend addFriend(@RequestBody Friend fr){
        return dao.save(fr);
    }

    @PutMapping("/friend")
    public Friend changeFriend(@RequestBody  Friend fr){
        return dao.save(fr);
    }

    @DeleteMapping("/friend/{id}")
    public void DeleteFriend(@PathVariable int id){
        dao.deleteById(id);
    }


    @GetMapping("/friend/{id}")
    public Optional<Friend> findByid(@PathVariable int id){
        return dao.findById(id);
    }

    @GetMapping("/friend/search")
    public Optional<Friend> findByFirstNameAndLastName(@RequestParam String first,@RequestParam  String last){
        return dao.findByFirstNameAndLastName(first, last);
    }






















}
