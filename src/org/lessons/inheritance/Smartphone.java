package org.lessons.inheritance;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    
    private String imei;
    private int memory;


    //COSTRUTTORE
 public Smartphone(String name,String brand,BigDecimal price,BigDecimal iva){
        super(name,brand,price,iva);
    }

    public Smartphone(String name,String brand,BigDecimal price,BigDecimal iva,String imei,int memory){
        super(name,brand,price,iva);
        if(imei!=null&&imei.trim().isEmpty()){
            this.imei=imei;
        }
        if(memory>0){
            this.memory=memory;
        }
    }

    //GETTER & SETTER

    public String getImei(){
        return this.imei;
    }

    public void setImei(String imei){
        if(imei!=null&&imei.trim().isEmpty()){
            this.imei=imei;
        }
    }

    public int getMemory(){
        return this.memory;
    }

    public void setMemory(int memory){
        if(memory>0){
            this.memory=memory;
        }
    }

    @Override
    public String toString(){
        return String.format("SMARTPHONE INSERITO:%nnome:%s %nbrand:%s%nprezzo:%.2f%niva:%.0f%npollici:%d%nis smart:%s%n",super.getName(),super.getBrand(),super.getPrice(),super.getIva(),this.imei,this.memory);
    }

    @Override
    public BigDecimal calculate(boolean isPromo,Prodotto prodotto){
        if(!isPromo){
            return super.getPrice().add(super.getPrice().multiply(getIva()).divide(new BigDecimal("100")));
        }

        BigDecimal price = super.getPrice();
        BigDecimal discount = this.memory<32 ? new BigDecimal("0.05") : new BigDecimal("0.02");
        BigDecimal iva = getIva().divide(new BigDecimal("100"));

        BigDecimal tmp = price
             .subtract(price.multiply(discount))
             .add(price.multiply(iva));
        

             return tmp;
    }

}
