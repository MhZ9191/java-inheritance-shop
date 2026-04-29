package org.lessons.inheritance;


import java.math.BigDecimal;
import java.util.Random;
import java.math.RoundingMode;

public class Prodotto {
  
private int code;
private String name;
private String brand;
private BigDecimal price;
private BigDecimal iva;

//COSTRUTTORE
public Prodotto(String name,String brand,BigDecimal price,BigDecimal iva){
    Random rnd = new Random();
    this.code=rnd.nextInt(1000,9999)*rnd.nextInt(10,20);
    if(name!=null&&name.trim().isEmpty()){
        this.name=name;
    }

    if(brand!=null&&brand.trim().isEmpty()){
        this.brand=brand;
    }

    if(price.compareTo(BigDecimal.ZERO)==1){
        this.price=price.setScale(2,RoundingMode.DOWN);
    }

    if(iva.compareTo(BigDecimal.ZERO)>=0){
        this.iva=iva.setScale(2,RoundingMode.DOWN);
    }
}

//GETTER & SETTER

public int getCode(){
    return this.code;
}

public String getName(){
    return this.name;
}

public void setName(String name){
    if(name!=null&&name.trim().isEmpty()){
        this.name=name;
    }
}

public String getBrand(){
    return this.brand;
}

public void setBrand(String brand){
    if(brand!=null&&brand.trim().isEmpty()){
        this.brand=brand;
    }
}

public BigDecimal getPrice(){
    return this.price;
}

public void setPrice(BigDecimal price){
    if(price.compareTo(BigDecimal.ZERO)==1){
        this.price=price;
    }
}

public BigDecimal getIva(){
    return this.iva;
}

public void setIva(BigDecimal iva){
    if(iva.compareTo(BigDecimal.ZERO)==1){
        this.iva=iva;
    }
}


//METODI AGGIUNTIVI
public BigDecimal totalPrice(){
    return this.price.add(this.price.multiply(iva).divide(new BigDecimal("100"))).setScale(2,RoundingMode.DOWN);
}

}
