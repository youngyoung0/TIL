package sample.cafekiosk.unit.beverages;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AmericanoTest {

    @Test
    void printName(){
        Americano americano = new Americano();
        assertEquals(americano.getName(),"아메리카노");
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    void printPrice(){
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);
    }
}