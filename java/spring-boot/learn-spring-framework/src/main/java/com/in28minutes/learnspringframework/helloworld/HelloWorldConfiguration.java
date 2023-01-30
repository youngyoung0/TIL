package com.in28minutes.learnspringframework.helloworld;

import com.in28minutes.learnspringframework.entity.Address;
import com.in28minutes.learnspringframework.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Ranga";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person Person3Parameters(String name, int age, Address address3){
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person Person4Parameters(String name, int age, Address address){
        return new Person(name, age, address);
    }

    @Bean
    @Qualifier
    public Person Person5QualifierString(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name, age, address);
    }

    @Bean(name="address2")
    @Primary
    public Address address(){
        return new Address("Baker Street", "London");
    }

    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("Motinagar", "Hyderabad");
    }
}
