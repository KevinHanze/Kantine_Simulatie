import java.util.Iterator; 
/**
 * class kassa - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */

public class Kassa {
    private double hoeveelheidGeldInKassa; 
    private int aantalArtikelen; 

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        hoeveelheidGeldInKassa = 0;
        aantalArtikelen = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     * @throws TeWeinigGeldException Als er te weinig geld is om te betalen.
     */
    public void rekenAf(Dienblad dienblad) {
        Persoon klant = dienblad.getKlant(); 
        aantalArtikelen += artikelenOpDienblad(dienblad); 
        Betaalwijze betaalwijze = klant.getBetaalwijze(); 
        double teBetalen = totaalPrijsDienblad(dienblad); 

        if(klant instanceof KortingskaartHouder){
            double korting = teBetalen * (((KortingskaartHouder)klant).geefKortingsPercentage() * 0.01); 
            if(((KortingskaartHouder)klant).heeftMaximum()){
                if(korting > ((KortingskaartHouder)klant).geefMaximum()){
                    korting = ((KortingskaartHouder)klant).geefMaximum(); 

                }
            }
            teBetalen -= korting; 
        }

        try {
            betaalwijze.betaal(teBetalen);

            hoeveelheidGeldInKassa += teBetalen;
        }
        catch(TeWeinigGeldException e) {
            System.out.println(klant.getVootnaam() + " " + klant.getAchternaam() +" kan de artikelen niet betalen.");
            //dieblad + artikelen terug
        }

    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {

        return aantalArtikelen; 
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return hoeveelheidGeldInKassa; 
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        hoeveelheidGeldInKassa = 0; 
    }

    public double totaalPrijsDienblad(Dienblad dienblad){
        double prijs = 0.0; 
        if(dienblad.getIterator() == null){ 
            System.out.println("dit dienblad is leeg");
            return prijs;
        }
        else {
            Iterator<Artikel> it = dienblad.getIterator(); 
            while(it.hasNext()){
                prijs += it.next().getPrijs();  
            }
            return prijs;  
        }
    }

    public int artikelenOpDienblad(Dienblad dienblad){
        int i = 0;
        if(dienblad.getIterator() == null){     
            System.out.println("dit dienblad is leeg");
            return i;
        }
        else {
            Iterator<Artikel> it = dienblad.getIterator();
            while(it.hasNext()) {
                it.next();
                i++;
            }
            return i;
        }
    }
}