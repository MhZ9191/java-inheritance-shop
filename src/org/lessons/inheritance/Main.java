package org.lessons.inheritance;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        
        Prodotto test = new Prodotto("jasmin","diesel",new BigDecimal("10"),new BigDecimal("22"));

        System.out.println(test.totalPrice());
    }
}
