
/**
 * class Docent - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (09-06-2020)
 */
public class Docent extends Persoon
{
    // instance variables - vervang deze door jouw variabelen
    private String afkorting;
    private String afdeling;
    /**
     * Constructor voor objects van class Docent
     */
    public Docent(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, String afkorting, String afdeling){
     super(bsn,voornaam,achternaam,geboorteDag,geboorteMaand,geboorteJaar,geslacht);
     this.afkorting = afkorting;
     this.afdeling = afdeling; 
    }
    
    public Docent(){
        
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}
