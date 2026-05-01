package org.lessons.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TV extends Prodotto{
    private int pollici;
    private boolean isSmart;

    //COSTRUTTORE
    public TV(String name,String brand,BigDecimal price,BigDecimal iva){
        super(name,brand,price,iva);
    }

    public TV(String name,String brand,BigDecimal price,BigDecimal iva,int pollici,boolean isSmart){
        super(name,brand,price,iva);

        if(pollici>0){
            this.pollici=pollici;
        }

        this.isSmart=isSmart;
    }

    //GETTER & SETTER
    public int getPollici(){
        return this.pollici;
    }

    public void setPollici(int pollici){
        if(pollici>0){
            this.pollici=pollici;
        }
    }

    public boolean getIsSmart(){
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart){
        this.isSmart=isSmart;
    }

    @Override
    public String toString(){
        return String.format("TV INSERITA:%nnome:%s %nbrand:%s%nprezzo:%.2f%niva:%.0f%npollici:%d%nis smart:%s%n",super.getName(),super.getBrand(),super.getPrice(),super.getIva(),this.pollici,this.isSmart);
    }  

    @Override
    public BigDecimal calculate(boolean isPromo,Prodotto prodotto){
        if(!isPromo){
            return super.getPrice().add(super.getPrice().multiply(getIva()).divide(new BigDecimal("100")));
        }
        //PRIMA APPLICO LO SCONTO SUL PREZZO SENZA IVA, POI APPLICO L'IVA
        BigDecimal price = super.getPrice();
        BigDecimal discount = this.isSmart ? new BigDecimal("0.10") : new BigDecimal("0.02");
        BigDecimal iva = getIva().divide(new BigDecimal("100"));

        BigDecimal tmp = price
             .subtract(price.multiply(discount))
             .add(price.multiply(iva));
        

             return tmp;

        }
}
