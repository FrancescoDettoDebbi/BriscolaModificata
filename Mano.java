package briscolaModificata;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class represents the Hand of a Player.
 * </p>
 * 
 * @author Francesco Debbi
 *
 */
public class Mano {

	// attributes
	/**
	 * <p>
	 * This field is the list of cards in the hand of a player.<br>
	 * The maximum size of this list shall be 3.
	 * </p>
	 */
	private List<Carta> mano;
	
	//constructor
	/**
	 * <p>
	 * This method creates the hand of a player and deals 2 cards to it from the deck.
	 * </p>
	 * @param mazzo
	 */
	Mano(Mazzo mazzo){
		mano = new ArrayList<>();
		for (int i = 0; i < 2; i ++) {
			draw(mazzo);
		}
	}
	/**
	 * <p>
	 * This method activates the in hand effect of all the cards in the hand.
	 * </p>
	 */
	public void activateInMano() {
		for (Carta c : mano) {
			c.inMano();
		}
	}

	/**
	 * <p>
	 * This method draws a card from a deck.
	 * </p>
	 */
	public void draw(Mazzo mazzo) {
		mano.add(mazzo.deal());
	}
	
	/**
	 * this method select a card from the hand of a player and returns it.
	 * @param index
	 * @return the card that is supposed to be played by the player.
	 */
	public Carta selection(int index) {
		return mano.remove(index);
	}
	
	/**
	 * 
	 * @return the size of the hand
	 */
	public int size() {
		return mano.size();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[ ");
		mano.forEach(carta -> {s.append(carta); s.append(", ");});
		s.replace(s.lastIndexOf(","), s.lastIndexOf(",") + 1, "");
		s.append("]");
		return s.toString();
	}

	// getter
	
	public List<Carta> getMano() {
		return mano;
	}
	
	//setter
	/**
	 * 
	 * @param mano
	 */
	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	
}
