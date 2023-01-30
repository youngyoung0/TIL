package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.entity.Address;
import com.in28minutes.learnspringframework.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean(name="address2")
    public Address address(){
        return new Address("Baker Street", "London");
    }

    @Bean(name="address3")
    public Address address3(){
        return new Address("Motinagar", "Hyderabad");
    }
}
