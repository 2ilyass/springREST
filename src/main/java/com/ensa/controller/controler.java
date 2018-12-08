package com.ensa.controller;


import com.ensa.Dao.FriendDao;
import com.ensa.entities.Friend;
import com.ensa.errorHandling.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class controler {


    @Autowired
    FriendDao dao;


    /* Getting All friends */

            @GetMapping("/friend")
            Iterable<Friend> allFriends(){
                return dao.findAll();
            }


    /* Adding a friend exception handlling methode 2

            @PostMapping("/friend")
            public Friend addFriend(@RequestBody Friend fr) throws ValidationException {
                if(fr.getId()==0 && fr.getFirstName()!= null && fr.getLastName()!= null  && fr.getAdresses()!= null) {
                    return dao.save(fr);
                } else
                    throw new ValidationException("friend cannot be created fill in the blank fields");
            }
    */


    /* Adding a friend exception handlling methode 3*/

            @PostMapping("/friend")
            public Friend addFriend(@Valid @RequestBody Friend fr)  {
                return dao.save(fr);
            }

            @ResponseStatus(HttpStatus.BAD_REQUEST)
            @ExceptionHandler(MethodArgumentNotValidException.class)
            List<ErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
                List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
                List<ErrorMessage> fieldErrodMessage = fieldErrors
                        .stream()
                        .map(fieldError ->  new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

            return fieldErrodMessage;
            }


    /* Modifying a friend*/

            @PutMapping("/friend")
            public ResponseEntity<Friend> changeFriend(@RequestBody  Friend fr){
                if(dao.findById(fr.getId()).isPresent())
                    return new ResponseEntity(dao.save(fr), HttpStatus.OK);
                else
                    return new ResponseEntity(fr , HttpStatus.BAD_REQUEST);
            }


    /* Deleting a friend*/

            @DeleteMapping("/friend/{id}")
            public void DeleteFriend(@PathVariable int id){
                dao.deleteById(id);
            }


    /* Getting  a friend by ID */

            @GetMapping("/friend/{id}")
            public Optional<Friend> findByid(@PathVariable int id){
                return dao.findById(id);
            }


    /* Getting a friend by First and Last name*/

            @GetMapping("/friend/search")
            public Optional<Friend> findByFirstNameAndLastName(@RequestParam String first,@RequestParam  String last){
                return dao.findByFirstNameAndLastName(first, last);
            }


/*=======================================================================================*/



















}
