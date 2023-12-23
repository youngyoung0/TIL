package com.vinsguru.protobuf;

import com.vinsguru.models.Person;

public class PersonDemo {
    public static void main(String[] args){
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();

        System.out.println(sam.toString());
    }
}
