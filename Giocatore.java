package briscolaModificata;

import java.util.Scanner;

/**
 * This class represents a player.
 * @author Francesco Debbi
 *
 */
public class Giocatore {
	
	// attributes
	/**
	 * the hand of the player.
	 */
	private Mano mano;
	
	/**
	 * the index of the card the player intends to play.
	 */
	private int selezione;
	
	/**
	 * the points pile of the player.
	 */
	private PilaPrese pilaPrese;
	
	//constructor
	/**
	 * this method creates the deck and the points pile.
	 * @param mazzo
	 */
	Giocatore(Mazzo mazzo){
		this.mano = new Mano(mazzo);
		this.pilaPrese = new PilaPrese();
	}
	
	//methods
	/**
	 * This method plays the selected card.
	 * @return the card played
	 */
	public Carta play() {
		return getMano().selection(selezione);
	}
	
	//getters
	/**
	 * 
	 * @return the hand
	 */
	public Mano getMano() {
		return mano;
	}
	
	/**
	 * 
	 * @return the pile
	 */
	public PilaPrese getPila() {
		return pilaPrese;
	}
	
	/**
	 * 
	 * @return the card selection index
	 */
	public int getSelezione() {
		return selezione;
	}

	//setters
	/**
	 * 
	 * @param selezione
	 */
	public void setSelezione(int selezione) {
		this.selezione = selezione;
	}
	
	public void selectFromScanner() {
		Scanner scanner = new Scanner(System.in);
		int input;
		do {
			System.out.println("Quale carta scegli?");
			while (!scanner.hasNextInt()) {
				System.out.println("Devi inserire un numero compreso tra 0  e " + getMano().size());
				scanner.next();
			}
			input = scanner.nextInt();
		}while(input < 0 || input > 2);
	}

}
