package com.ensa.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Adresse {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;
    private String city;

    @JsonBackReference
    @ManyToOne
    Friend friend;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Adresse(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public Adresse() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
