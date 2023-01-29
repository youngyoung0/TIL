package com.in28minutes.learnspringframework.entity;

import lombok.Data;

@Data
public class Address {
    private String firstLine;
    private String city;

    public Address(String firstLine, String city) {
        this.firstLine = firstLine;
        this.city = city;
    }

    @Override
    public String toString(){
        return "Address[firstLine="+firstLine+", city="+city+"]";
    }
}
