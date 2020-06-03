import java.util.ArrayList; 
public class KassaRij {
    
    private ArrayList<Dienblad> rij; 
    /*
     * Constructor
     */
    public KassaRij() {
        
        rij = new ArrayList<Dienblad>(); 
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad dienblad) {
        rij.add(dienblad);  
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        Dienblad eersteklant = null;

        if(rij == null || rij.isEmpty()){
            return eersteklant;
        }

        for(int i = 0; i < rij.size(); i++){
            if(rij.get(i) != null){
                eersteklant = rij.get(i);  

                rij.remove(i); 
                break; 
            }
        }

        return eersteklant; 
    }
    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {

        if(rij.isEmpty() || rij == null){
            return false;    
        }
        return true; 
    }

    public int getLengteRij(){
        return rij.size();    
    }
    
}
