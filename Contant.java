public class Contant extends Betaalwijze {
    /** 
     * Methode om betaling af te handelen
     * @throws TeWeinigGeldException 
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
		// omitted
		if(saldo >= tebetalen){
			setSaldo(saldo - tebetalen);
		}
		else{
			throw new TeWeinigGeldException();
		}
	}
}