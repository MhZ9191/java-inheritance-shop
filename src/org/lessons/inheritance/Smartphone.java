package org.lessons.inheritance;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    
    private String imei;
    private int memory;


    //COSTRUTTORE

    public Smartphone(String name,String brand,BigDecimal price,BigDecimal iva,String imei,int memory){
        super(name,brand,price,iva);
        if(imei!=null&&imei.trim()!=""){
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
        if(imei!=null&&imei.trim()!=""){
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

}
