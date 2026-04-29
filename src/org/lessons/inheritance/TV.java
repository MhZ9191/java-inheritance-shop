package org.lessons.inheritance;

import java.math.BigDecimal;

public class TV extends Prodotto{
    private float width;
    private float height;
    private boolean isSmart;

    //COSTRUTTORE
    public TV(String name,String brand,BigDecimal price,BigDecimal iva,float width,float height,boolean isSmart){
        super(name,brand,price,iva);

        if(width>0){
            this.width=width;
        }

        if(height>0){
            this.height=height;
        }

        this.isSmart=isSmart;
    }

    //GETTER & SETTER
    public float getWidth(){
        return this.width;
    }

    public void setWidth(float width){
        if(width>0){
            this.width=width;
        }
    }

    public float getHeight(){
        return this.height;
    }

    public void setHeight(float height){
        if(height>0){
            this.height=height;
        }
    }

    public boolean getIsSmart(){
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart){
        this.isSmart=isSmart;
    }
}
