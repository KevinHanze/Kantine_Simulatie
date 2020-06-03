
/**
 * class artikel - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Artikel
{
    String naam;
    double prijs; 

    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs; 
    }

    public Artikel(){
    }

    public String getNaam(){ 
        return naam;    
    }

    public double getPrijs(){
        return prijs;     
    }

    public void setNaam(String newNaam){
        naam = newNaam; 
    }

    public void setPrijs(int newPrijs){
        prijs = newPrijs;  
    }
}
