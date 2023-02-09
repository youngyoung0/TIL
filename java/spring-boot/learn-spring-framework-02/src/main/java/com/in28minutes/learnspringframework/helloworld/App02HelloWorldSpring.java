package com.in28minutes.learnspringframework.helloworld;

import com.in28minutes.learnspringframework.entity.Address;
import com.in28minutes.learnspringframework.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1. 스프링 컨텍스트 시작
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 3. 스프링이 관리하는 Bean 회수
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("Person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("Person5QualifierString"));

        }


        // 2. spring에서 관리할 항목 구성 - @Configuration
        // HelloWoldConfiguration
        // name - @Bean


        /* 1. 빈에 대한 사용자 지정 이름을 구성할 수 있다는 사실
        *  2. 스프링 컨텍스트에서 빈을 여러번 검색할 수 있다는 사실
        *  3. Spring에서 관리하는 기존 빈을 사용할 수 있다는 것
        */
    }
}
