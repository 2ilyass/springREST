package com.ensa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Friend {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @JsonProperty("fist")
    private String firstName;


    @JsonProperty("last")
    private String lastName;

    private int age;


    @JsonIgnore
    private Boolean married;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "friend")
    List<Adresse> adresses;


    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Friend() {
    }


    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
