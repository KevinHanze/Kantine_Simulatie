/**
 * class KantineMedewerker - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (09-06-2020)
 */
public class KantineMedewerker extends Persoon implements  KortingskaartHouder 
{
    // instance variables - vervang deze door jouw variabelen
    private String medewerkersNummer;
    private boolean kassaRechten;

    /**
     * Constructor voor objects van class KantineMedewerker
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, String nummer, boolean kassa){
        super(bsn,voornaam,achternaam,geboorteDag,geboorteMaand,geboorteJaar,geslacht);
        medewerkersNummer = nummer;
        kassaRechten = kassa; 
    }

    public KantineMedewerker(){

    }

    public String getMedewerkersNummer() {
        return medewerkersNummer;
    }

    public void setMedewerkersNummer(String medewerkersNummer) {
        this.medewerkersNummer = medewerkersNummer;
    }

    public boolean isKassaRechten() {
        return kassaRechten;
    }

    public void setKassaRechten(boolean kassaRechten) {
        this.kassaRechten = kassaRechten;
    }

    public double geefKortingsPercentage(){
        return 35;    
    }

    public boolean heeftMaximum(){
        return false;    
    }

    public double geefMaximum(){
        return 100000000.00; 
    }
}