package briscolaModificata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class represents a deck of cards.
 * </p>
 * @author Francesco Debbi
 *
 */
public class Mazzo {
	// attributes
	/**
	 * <p> The list of the cards in the deck.</p>
	 */
	private List<Carta> mazzo;
	
	// constructor
	public Mazzo() {
		inizializzaMazzo();
	}
	/**
	 * <p> This method set the deck to a ArrayList of Cards. 
	 * For each combination of suit and value, the combination is added to the deck
	 * except for the actual card classes.
	 * ideally this method will change in adding only actual cards.
	 * </p>
	 */
	private void inizializzaMazzo() {
		mazzo = new ArrayList<>(40);
		for (Carta.Seme s : Carta.Seme.values()) {
			for (Carta.Valore v : Carta.Valore.values()) {
				if (s.equals(Carta.Seme.COPPE) && v.equals(Carta.Valore.QUATTRO)) mazzo.add(new QuattroDiCoppe());
				else mazzo.add(new CartaVanilla(s, v));
			}
		}
		mescolaMazzo();
	}
	
	/**
	 * <p> This method shuffles the deck.</p>
	 */
	public void mescolaMazzo() {
		Collections.shuffle(mazzo);
	}
	
	/**
	 * <p>This method remove the first card from the deck and returns it.</p>
	 * @return the removed card.
	 */
	public Carta deal() {
		return mazzo.remove(0);
	}
	
	/**
	 * the last card of the deck is the "Briscola".
	 * @return the Briscola card
	 */
	public Carta generateBriscola() {
		return this.mazzo.get(mazzo.size() - 1);
	}
	
	/**
	 * this method is used to activate in deck effects
	 */
	public void activateInMazzo() {
		mazzo.forEach(carta -> carta.inMano());
	}
	
	/**
	 * 
	 * @return the number of card left in the deck.
	 */
	public int size() {
		return mazzo.size();
	}

}
