package org.lessons.inheritance;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        
        // Prodotto test = new Prodotto("jasmin","diesel",new BigDecimal("10"),new BigDecimal("22"));
        // System.out.println(test.totalPrice());
    
        Smartphone cellulare = new Smartphone("n-213", "nokia", new BigDecimal("150"), new BigDecimal("22"), "CD-12323-AFK", 12);
        System.out.printf("smartphone %s prezzo: %.2f%n",cellulare.getName(),cellulare.totalPrice());
        System.out.printf("smartphone %s IMEI : %s%n",cellulare.getName(),cellulare.getImei());

        TV televisore = new TV("SM-M13","samsung",new BigDecimal("1340.34"),new BigDecimal("22"),134.21F,100.00F,true);
        System.out.printf("televisore %s prezzo : %.2f%n",televisore.getName(),televisore.totalPrice());
        System.out.printf("televisore %s is smart : %s%n",televisore.getName(),televisore.getIsSmart());
    }
}
