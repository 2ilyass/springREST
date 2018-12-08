package com.ensa.Dao;

import com.ensa.entities.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FriendDao extends CrudRepository<Friend, Integer> {


    Optional<Friend> findByFirstNameAndLastName(String first, String last);


}
