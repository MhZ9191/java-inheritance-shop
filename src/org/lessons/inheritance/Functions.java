package org.lessons.inheritance;

public class Functions {
    
    public static Prodotto[] inserimento(Prodotto[] prodotti,Prodotto prodotto){
        Prodotto[] tmp = new Prodotto[prodotti.length+1];

        for(int i=0;i<prodotti.length;i++){
            tmp[i]=prodotti[i];
        }

        tmp[tmp.length-1]=prodotto;
        return tmp;
    }

}
