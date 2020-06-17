public class Pinpas extends Betaalwijze {

    private double kredietlimiet; 

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietLimiet) {
        kredietlimiet = kredietLimiet; 
    }

    /**
     * Methode om betaling af te handelen
     * @throws TeWeinigGeldException
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(saldo+kredietlimiet >= tebetalen){
			setSaldo(saldo - tebetalen);	
		}
		else{
			throw new TeWeinigGeldException();
		}
	}
}