package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1. 스프링 컨텍스트 시작
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // 2. spring에서 관리할 항목 구성 - @Configuration
        // HelloWoldConfiguration
        // name - @Bean

        // 3. 스프링이 관리하는 Bean 회수
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
    }
}
