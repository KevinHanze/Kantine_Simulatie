
/**
 * class Administratie - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Administratie {  

    static final int DAYS_IN_WEEK = 7;

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde  
     * @param aantal
     * @return het gemiddelde  
     */
    public static double berekenGemiddeldAantal(int[] aantal) {  

        if (aantal.length > 0) 
        {
            double somGetallen = 0;
            double gemiddeldeArtikelenPerDag = 0;

            for (int getal : aantal) {
                somGetallen += getal;
            }

            gemiddeldeArtikelenPerDag = somGetallen / aantal.length;
            return gemiddeldeArtikelenPerDag;
        } else 
        {
            return 0;
        }
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde 
     * @param omzet
     * @return het gemiddelde 
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        if (omzet.length > 0) 
        {
            double somOmzet = 0;
            double gemiddeldeOmzetPerDag = 0;

            for (double bedrag : omzet) {
                somOmzet += bedrag;
            }

            gemiddeldeOmzetPerDag = somOmzet / omzet.length;
            return gemiddeldeOmzetPerDag; 
        } else 
        {
            return 0;
        }
    }

    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet 
     * @return array (7 elementen) met dagomzetten  
     */ 
    public static double[] berekenDagOmzet(double[] omzet) { 
        double[] temp = new double[DAYS_IN_WEEK]; 
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            while ((i+DAYS_IN_WEEK*j)<omzet.length) { 
                temp[i] += omzet[i + DAYS_IN_WEEK * j]; 
                j++;
            }
        }
        return temp;
    }
}


