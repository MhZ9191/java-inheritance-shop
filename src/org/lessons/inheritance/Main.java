package org.lessons.inheritance;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        
        // Prodotto test = new Prodotto("Hello","World",new BigDecimal("10"),new BigDecimal("22"));
        // System.out.println(test.totalPrice());
    
        Smartphone cellulare = new Smartphone("n-213", "nokia", new BigDecimal("150"), new BigDecimal("22"), "CD-12323-AFK", 12);
        System.out.printf("smartphone %s prezzo: %.2f%n",cellulare.getName(),cellulare.totalPrice());
        System.out.printf("smartphone %s IMEI : %s%n",cellulare.getName(),cellulare.getImei());

        Headphone cuffie = new Headphone("A-23VB","ASTRO",new BigDecimal("89.99"),new BigDecimal("22"),"red",false);
        System.out.printf("cuffie %s prezzo : %.2f%n",cuffie.getName(),cuffie.totalPrice());
        System.out.printf("cuffie %s color : %s%n",cuffie.getName(),cuffie.getColor());
    }
}
