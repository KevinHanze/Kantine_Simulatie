
import java.util.*;

/**
 * class Persoon - geef hier een beschrijving van deze class
 *
 * @author (Eric Low)
 * @version (19-05-2020)
 */
public class Persoon
{
    private Dienblad dienblad; 
    private Artikel artikel;

    private int bsn;
    private String voornaam;
    private String achternaam;
    private String geboortedatum;
    private int geboorteDag;
    private int geboorteMaand;
    private int geboorteJaar;
    private char geslacht;

    // Deze variabelen worden gebruikt voor een check.

    boolean geldigeDag;

    public static void main(String[] args) {
    }

    /**
     * Constructor voor objects van class Persoon
     */
    public Persoon(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht)
    {
     this.voornaam = voornaam;
     this.achternaam = achternaam; 
     this.geboorteDag = geboorteDag;
     this.geboorteMaand = geboorteMaand;
     this.geboorteJaar = geboorteJaar;
     this.geslacht = geslacht;
    }
    
    public Persoon(){
        
    }

    /**
     * Setter BurgerServiceNummer
     */
    public void setBsn (int Bsn){
        this.bsn = Bsn;
    }

    /**
     * Setter Voornaam
     */
    public void setVoornaam (String Voornaam){
        this.voornaam = Voornaam;
    }

    /**
     * setter Achternaam
     */
    public void setAchternaam (String Achternaam){
        this.achternaam = Achternaam;
    }

    /**
     * Setter GeboorteDatum
     * 
     * TO DO
     * Klasse Datum nodig 
     * 
     */
    public void setGeboorteDatum (int newgeboortedag,int newgeboortemaand,int newgeboortejaar){
        

        int maxdagen = 0; 
        switch (newgeboortemaand){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
            maxdagen = 31; 

            break;

            case 4: case 6: case 9: case 11:
            maxdagen = 30; 

            break;

            case 2:
            if(schrikkelJaar(newgeboortejaar)){
                maxdagen = 29; 
            }
            else {
                maxdagen = 28;
            }

        }

        if(newgeboortedag >= 1 && newgeboortedag <= maxdagen){

            geldigeDag = true; 
        }  
        else{
            geldigeDag = false;  
        }


        if(newgeboortemaand < 1 || newgeboortemaand > 12){
            geldigeDag = false; 
        }
        
        if(newgeboortejaar < 1900 || newgeboortejaar > 2100){
            geldigeDag = false;
        }
        
        if(geldigeDag){ 
           geboorteDag = newgeboortedag;
           geboorteMaand = newgeboortemaand;
           geboorteJaar = newgeboortejaar; 
        }
        else { 
            geboorteDag = 0;
            geboorteMaand = 0;
            geboorteJaar = 0;     
            System.out.println("dit is geen geldige geboortedatum"); 
        }
    
    }

    /**
     * Setter geslacht
     */
    public void set (char geslacht)
    {
        if (geslacht == 'm' || geslacht == 'v'){
            this.geslacht = geslacht;
        }
        else {
            this.geslacht = 'x';
            System.out.println ("Voer een geldig geslacht in. (M/V) ");
        }
    }

    //. opgave c
    /**
     * Getter geslacht
     * @return geslacht
     */
    public String getGeslacht (){
        if(geslacht == 'm') {
            return "man";
        }

        else if (geslacht == 'v'){
            return "vrouw";
        }
        else {
            return "onbekend";
        }        
    }

    /**
     * Getter Bsn
     * @return Bsn
     */
    public int getBsn (){
        return bsn;
    }

    /**
     * Getter Voornaam
     * @return Voornaam
     */
    public String getVootnaam (){
        return voornaam;
    }

    /**
     * Getter Achternaam
     * @return Achternaam
     */
    public String getAchternaam (){
        return achternaam;
    }

    /**
     * Getter geboortedatum
     * @return geboorteDatum
     * 
     * TO DO
     */

    public String getGeboorteDatum() {

        geboortedatum= geboorteDag+"-"+geboorteMaand+"-"+geboorteJaar; 

        return geboortedatum;
    }

    /**
     * Drukt de gegevens van persoon af
     */
    public void drukAf(){
        System.out.println(bsn);
        System.out.println(voornaam);
        System.out.println(achternaam);
        System.out.println(geboortedatum);
        System.out.println(getGeslacht());       
    }

    /**
     * Methode om dienblad te koppelen aan een persoon
     * @param dienblad
     */
    public void pakDienblad(Dienblad dienblad){
        this.dienblad = dienblad;
    }

    /**
     * retouneert de dienblad aan de klassen die hem nodig hebben zo dat die het kunnen ophalen. 
     * @return dienblad
     */
    public Dienblad getDienblad(){
        return dienblad;
    }

    public boolean schrikkelJaar(int jaar){ 

        if((jaar % 4 == 0) && !(jaar % 100 == 0)){  

            return true;

        }
        else if(jaar % 400 == 0) { 

            return true;
        }
        else {
            return false;   
        }
    }

}
