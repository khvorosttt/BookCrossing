/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.domain;

import java.util.List;

/**
 * @author Lenovo
 */
public class Book {
    
    private Integer BCID;
    private String author;
    private String name;
    private int genre;
    private String tags;
    private String reader;
    private int access;
    private boolean status = true;
    private String country;
    private String city;
    private String street;
    private String house;

    public int getGenre(){
        return genre;
    }
    
    public void setGenre(int genre){
        this.genre=genre;
    }
    
    public String getTags(){
        return tags;
    }
    
    public void setTags(String tags){
        this.tags=tags;
    }
    
    public Integer getBCID() {
        return BCID;
    }

    public void setBCID(Integer BCID) {
        this.BCID = BCID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAutor(String author) {
        this.author = author;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = BCID * result + ((author == null) ? 0 : author.hashCode());
        result = BCID * result + ((name == null) ? 0 : name.hashCode());
        result = BCID * result + ((reader == null) ? 0 : reader.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Книга [autor=" + author + ", name=" + name + ", reader=" + reader + ", access" + access + ", status" + status + "]";
    }


}
