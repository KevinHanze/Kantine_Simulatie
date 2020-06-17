import java.util.*;

public class KantineSimulatie {
    //persoon
    private Persoon persoon;
    // dienblad
    private Dienblad dienblad; 
    // kantine
    private Kantine kantine;
    private Administratie administratie; 
    // kantineaanbod
    private KantineAanbod kantineaanbod;
    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
        {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10,
            1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);

    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen; 
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        double[] gemiddeldeWinst = new double[dagen]; 
        int[] gemiddeldeKlanten = new int[dagen]; 
        double[]  winstPerDag = new double[dagen]; 
        for (int i = 0; i < dagen; i++) {
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG) ;
            int aantalStudenten = 0;
            int aantalDocenten = 0;
            int aantalMedewerkers = 0;

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {
                int randomValue = getRandomValue(0,100);
                // maak persoon(89% kans op student, 10% kans op docent, 1% kans op medewerker) en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                if(randomValue < 90) {
                    persoon = new Student();   
                    dienblad = new Dienblad();
                    dienblad.setKlant(persoon);
                    aantalStudenten++; 
                }
                else if(randomValue >= 90 && randomValue < 100){
                    persoon = new Docent();   
                    dienblad = new Dienblad();
                    dienblad.setKlant(persoon); 
                    aantalDocenten++;
                }
                else{
                    persoon = new KantineMedewerker();   
                    dienblad = new Dienblad();
                    dienblad.setKlant(persoon); 
                    aantalMedewerkers++; 
                }
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON); 

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN-1); 

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

                //betaalwijze bepalen en toewijzen aan de persoon
                Betaalwijze betaalwijze;
                String typeBetaalwijze;
                int random = getRandomValue(1, 2);
                if (random == 1) {
                    persoon.setBetaalwijze(new Contant());
                    persoon.getBetaalwijze().setSaldo(1200);
                }
                else{
                 persoon.setBetaalwijze(new Pinpas());    
                persoon.getBetaalwijze().setSaldo(1200);
                }
                
            }
            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            gemiddeldeWinst[i]= kantine.getKassa().hoeveelheidGeldInKassa();  
            gemiddeldeKlanten[i] = aantalpersonen; 

            // druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            System.out.println("---------------------------------");
            System.out.println("Er hebben vandaag " + aantalStudenten + " studenten, " + aantalDocenten + " docenten, en " + aantalMedewerkers + " mederwerker(s) besteld.");
            System.out.println("Dag omzet: €" + Math.floor(kantine.getKassa().hoeveelheidGeldInKassa()*100)/100 + ",-"); 
            System.out.println("Dagtotaal artikelen: " + kantine.getKassa().aantalArtikelen()); 

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();  
        }
        System.out.println(); 
        System.out.println("De gemmidelde omzet per dag over " + dagen + " dagen = €" + Math.floor(administratie.berekenGemiddeldeOmzet(gemiddeldeWinst)*100)/100 + ",-");
        System.out.println("Het gemiddelde aantal klanten per dag = " + Math.round(administratie.berekenGemiddeldAantal(gemiddeldeKlanten))); 
    }
}