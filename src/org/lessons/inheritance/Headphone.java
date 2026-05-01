package org.lessons.inheritance;

import java.math.BigDecimal;
import java.util.Arrays;

public class Headphone extends Prodotto {
    
    private String[] colors={"white","red","blue"};

    private String color;
    private boolean isWireless;

    //COSTRUTTORE

     public Headphone(String name,String brand,BigDecimal price,BigDecimal iva){
        super(name,brand,price,iva);
    }

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

    @Override
    public String toString(){
        return String.format("HEADPHONE INSERITO:%nnome:%s %nbrand:%s%nprezzo:%.2f%niva:%.0f%npollici:%d%nis smart:%s%n",super.getName(),super.getBrand(),super.getPrice(),super.getIva(),this.color,this.isWireless);
    }

    public BigDecimal calculate(boolean isPromo,Prodotto prodotto){
        if(!isPromo){
            return super.getPrice().add(super.getPrice().multiply(getIva()).divide(new BigDecimal("100")));
        }

        BigDecimal price = super.getPrice();
        BigDecimal discount = this.isWireless ? new BigDecimal("0.07") : new BigDecimal("0.02");
        BigDecimal iva = getIva().divide(new BigDecimal("100"));

        BigDecimal tmp = price
             .subtract(price.multiply(discount))
             .add(price.multiply(iva));
        

             return tmp;
    }

}
