
/**
 * class artikel - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Artikel
{
    String naam;
    int    prijs;

    public Artikel(String naam, int prijs){
        this.naam = naam;
        this.prijs = prijs; 
    }

    public Artikel(){
    }

    public String getNaam(){ 
        return naam;    
    }

    public int getPrijs(){
        return prijs;    
    }

    public void setNaam(String newNaam){
        naam = newNaam; 
    }

    public void setPrijs(int newPrijs){
        prijs = newPrijs;  
    }
}
