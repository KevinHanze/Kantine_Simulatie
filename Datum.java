
/**
 * class Datum - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Datum {

    private int dag;
    private int maand;
    private int jaar;

    /**
     * Constructor
     */
    public Datum(int dag, int maand, int jaar){
        if(bestaatDatum(this.dag, this.maand, this.jaar)){
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar; 

        }
        else {
            dag = 0;
            maand = 0;
            jaar = 0;
        }
    }

    public Datum(){
        dag = 0;
        maand = 0;
        jaar = 0;
    }
    

    public boolean bestaatDatum(int day, int month, int year) { 
        int maxdagen = 0;

        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:    
            maxdagen = 31;
            break;

            case 2: 
            if(schrikkelJaar(year)){ 
                maxdagen = 29;
            }
            else {
                maxdagen = 28;
            }
            break;

            case 4: case 6: case 9: case 11:
            maxdagen = 30; 
        }

        if(day < 1){
            return false;  
        }
        else if(month < 1 || month > 12){
            return false;    
        }
        else if(year < 1900 || year > 2100){
            return false;   
        }
        else if(day > maxdagen){
            return false;
        }
        else{
            return true;   
        }
    }

    public void testDatum(){
        if(bestaatDatum(dag, maand, jaar)) {
            System.out.println("werkt prima");  
        }
    }

    public boolean schrikkelJaar(int jaar){  
        this.jaar = jaar;
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

    /**
     * Getter voor Sting weergave van datum
     *
     * @return Geboortedatum
     */
    public String getDatumAsString() {
        // to do
        return "";
    }

    public int getDag(){ 
        return dag;    
    }

    public int getMaand(){
        return maand;    
    }

    public int getJaar(){ 
        return jaar;    
    }

    public void setDag(int newDag){
        dag = newDag; 
    }

    public void setMaand(int newMaand){
        maand = newMaand;  
    }

    public void setJaar(int newJaar){
        jaar = newJaar;  
    }

}