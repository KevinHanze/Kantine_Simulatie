public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private Persoon persoon; 
    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
         
    }

    /**
     * In deze methode wordt een dienblad met artikelen in
     * de kassarij geplaatst. 
     * 
     * @param dienblad 
     */
    public void loopPakSluitAan(Dienblad dienblad , String[] artikelnamen) {
        for(int i = 0; i < artikelnamen.length; i++){
           Artikel artikel = kantineaanbod.getArtikel(artikelnamen[i]);   
           dienblad.voegToe(artikel);  
           
        }
        kassarij.sluitAchteraan(dienblad);     
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
    public KantineAanbod getKantineAanbod() {
     return kantineaanbod;    
    }
    public void setKantineAanbod(KantineAanbod newAanbod) {
     kantineaanbod = newAanbod;    
    }
}
