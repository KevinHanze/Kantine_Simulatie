public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan() {
        Persoon p1 = new Persoon(123, "henk", "henksma", 15, 9, 1998, 'm'); 
        Dienblad d1 = new Dienblad(p1); 
        
        p1.pakDienblad(d1); 
        
        Artikel a1 = new Artikel("pindas", 150);
        Artikel a2 = new Artikel("mel", 100); 

        d1.voegToe(a1);
        d1.voegToe(a2);

        kassarij.sluitAchteraan(p1);   
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij() == true) {
            kassa.rekenAf(kassarij.eerstePersoonInRij()); 
        }
    }
    public Kassa getKassa(){
       return kassa;  
    }

}
