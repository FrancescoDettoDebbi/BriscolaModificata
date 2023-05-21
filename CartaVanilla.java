package briscolaModificata;

/**
 * <p>
 * This class is supposed to be helpful in doing tests.<br>
 * This is a concrete class that implements placeholder implementation of all the abstract methods.<br>
 * While not all the 40 card classes will be written, it is possible to put vanilla cards 
 * in deck to perform tests.<br>
 * The card simply contains a Value and a suit.
 * </p>
 * @author Francesco Debbi
 */
public class CartaVanilla extends Carta {
	
	/**
	 * <p>
	 * Default constructor will be used in actual Card classes: 
	 * That is because the Quattro di Spade Class will always have a value of 4 and a suit of Spade, 
	 * so there is no need to list suit and value in the constructor. 
	 * </p>
	 */
	public CartaVanilla() {
		
	}
	
	/**
	 * <p>
	 * This constructor creates a VanillaCard object with value and suit given.
	 * </p>
	 * @param s {Carta.Seme}
	 * @param v {Carta.Valore}
	 */
	public CartaVanilla(Carta.Seme s, Carta.Valore v){
		setValore(v);
		setSeme(s);
	}
	
	/**
	 * <p>
	 * This is a placeholder.
	 * </p>
	 */
	public void inMano() {
		System.out.println("inMano");
	}

	/**
	 * <p>
	 * This is a placeholder.
	 * </p>
	 */
	public void inMazzo() {
		System.out.println("inMzzo");
	}

	/**
	 * <p>
	 * This is a placeholder.
	 * </p>
	 */
	public void inGioco() {
		System.out.println("inGioco");
	}

	/**
	 * <p>
	 * This is a placeholder.
	 * </p>
	 */
	public void inScarti() {
		System.out.println("inScarti");
	}

}
