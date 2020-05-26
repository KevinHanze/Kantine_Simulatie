import java.util.Stack;  
import java.util.Iterator; 
public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant; 
    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted 
        artikelen = new Stack<Artikel>(); 
    }

    public Dienblad(Persoon klant){
        this.klant = klant; 
        artikelen = new Stack<Artikel>();
    }

    public Persoon getKlant(){
        return klant;    
    }

    public void setKlant(Persoon newKlant){
        klant = newKlant;    
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {

        artikelen.add(artikel); 

    }
    public Iterator<Artikel> getIterator() {
        return artikelen.iterator();
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     *
    public int getAantalArtikelen() {
        int aantalartikelen = artikelen.size(); 
        return aantalartikelen; 
    }

    
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     
    public double getTotaalPrijs() {
        int totaal = 0; 
        for(Artikel a: artikelen){
            totaal = a.getPrijs() + totaal; 

        }
        return totaal; 
    } */
}
