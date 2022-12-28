package test.step2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import step2.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator cal = new Calculator();

    @BeforeEach
    public void setup(){
        cal = new Calculator();
        System.out.println("before");
    }

    @Test
    public void add(){
        assertEquals(9,(cal.add(6,3)));
        System.out.println("add");
    }

    @Test
    public void minus(){
        assertEquals(3,cal.minus(6,3));
        System.out.println("minus");
    }

    @AfterEach
    public void teardown(){
        System.out.println("teardown");
    }

    @Test
    public void stringCalculatorTest(){
        String requestNumber= "//;\n1;2;3";
        int sum = 0;
        if(!requestNumber.isEmpty()){
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(requestNumber);
            if(m.find()){
                String customDelimeter = m.group(1);
                String[] tokens = m.group(2).split(customDelimeter);

                for(String number : tokens){
                    sum+=Integer.parseInt(number);
                }
            }

        }
        System.out.println(sum);
    }

}