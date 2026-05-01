package org.lessons.inheritance;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        Prodotto[] prodotti= new Prodotto[0];
        String[] buoniSconto = {"ABC123","000ABC","AABBCC"};

        int userChoice=0;
        while(userChoice!=99){
            System.out.printf("Scegli un'opzione:%n%n%s%n%s%n%s%n%s%n%s%n%n-> "," 1 - Aggiungi prodotto"," 2 - Mostra prodotti nel carrello"," 3 - Mostra totale carrello"," 4 - Svuota carrello","99 - esci");
            userChoice=in.nextInt();
            in.nextLine();
            if(userChoice==1){

                
                String tipologia;
                System.out.print("Tipologia prodotto? : ");
                tipologia=in.nextLine();
                
                //NON HO INSERITO PER DEFAULT (PRODOTTO CHE NON RIENTRA IN TV , SMARTPHONE E CUFFIE)
                //NON HO GESTITO TUTTE LE VALIDAZIONI DEI CAMPI DA PARTE DELL'UTENTE
                switch(tipologia.toLowerCase().trim()){
                    case "tv":
                    case "televisore":
                        System.out.print("Inserisci NOME BRAND PREZZO IVA POLLICI ISSMART: ");
                        String tmp = in.nextLine();
                        String[] tmpTV = tmp.trim().split("\\s+");

                        if(tmpTV.length<6){
                            System.out.println("Input non valido");
                            return;
                        }

                        int pollici=Integer.parseInt(tmpTV[4]);

                        TV insertTV = new TV(
                            tmpTV[0],
                            tmpTV[1],
                            new BigDecimal(tmpTV[2]),
                            new BigDecimal(tmpTV[3]),
                            pollici,
                            Boolean.parseBoolean(tmpTV[5]));

                        prodotti=Functions.inserimento(prodotti, insertTV);

                        break;
                    
                    case "smartphone":
                    case "cellulare":
                    case "mobile":
                    case "telefonino":
                    case "telefono":
                        System.out.print("Inserisci NOME BRAND PREZZO IVA IMEI MEMORIA: ");
                        String tmpPho = in.nextLine();
                        String[] tmpPhone = tmpPho.trim().split("\\s+");

                        if(tmpPhone.length<6){
                            System.out.println("Input non valido");
                            return;
                        }

                        Smartphone insertSmartphone = new Smartphone(
                            tmpPhone[0],
                            tmpPhone[1],
                            new BigDecimal(tmpPhone[2]),
                            new BigDecimal(tmpPhone[3]),
                            tmpPhone[4],
                            Integer.parseInt(tmpPhone[5])
                        );

                        prodotti=Functions.inserimento(prodotti, insertSmartphone);

                        break;
                    
                    case "headphone":
                    case "cuffie":
                        System.out.print("Inserisci NOME BRAND PREZZO IVA COLORE ISWIRELESS: ");
                        String tmpHea = in.nextLine();
                        String[] tmpHead = tmpHea.trim().split("\\s+");

                        if(tmpHead.length<6){
                            System.out.println("Input non valido");
                            return;
                        }
                        
                        Headphone insertHeadphone = new Headphone(
                            tmpHead[0],
                            tmpHead[1],
                            new BigDecimal(tmpHead[2]),
                            new BigDecimal(tmpHead[3]),
                            tmpHead[4],
                            Boolean.parseBoolean(tmpHead[5])
                        ); 
                        
                        prodotti=Functions.inserimento(prodotti, insertHeadphone);

                        break;

                    default:
                        break;
                }

            }

            if(userChoice==2){
                System.out.println("CARRELLO:");
                for(int i=0;i<prodotti.length;i++){
                System.out.println(prodotti[i]);
            }
            }

            if(userChoice==3){
                String userPromo;
                System.out.print("Hai un buono sconto? Inseriscilo qui altrimenti premi invio -> ");
                userPromo=in.nextLine().toUpperCase().trim();

                boolean verify = Arrays.asList(buoniSconto).contains(userPromo);
                BigDecimal totale=new BigDecimal("0");
                
                
                for(int i=0;i<prodotti.length;i++){
                    BigDecimal tmpTot = prodotti[i].calculate(verify, prodotti[i]);
                    totale=totale.add(tmpTot);
                }

                
                System.out.println("Il totale del tuo carello è "+totale.setScale(2,RoundingMode.DOWN));
            }


            if(userChoice==4){
                prodotti=new Prodotto[0];
            }

        }


        in.close();
        System.out.println("GOODBYE");
    }
}
