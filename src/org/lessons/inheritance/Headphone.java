package org.lessons.inheritance;

import java.math.BigDecimal;
import java.util.Arrays;

public class Headphone extends Prodotto {
    
    private String[] colors={"white","red","blue"};

    private String color;
    private boolean isWireless;

    //COSTRUTTORE
    public Headphone(String name,String brand,BigDecimal price,BigDecimal iva, String color, boolean isWireless){
        super(name,brand,price,iva);

        if(Arrays.asList(colors).contains(color)){
            this.color=color;
        }else{
            this.color="black";
        }

        this.isWireless=isWireless;

    }

    //GETTER & SETTER  

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        if(color!=null &&
           color.trim().isEmpty() &&
           Arrays.asList(colors).contains(color)){
            this.color=color;
        }
    }

    public boolean getIsWireless(){
        return this.isWireless;
    }

    public void setIsWireless(boolean isWireless){
        this.isWireless=isWireless;
    }

}
