package briscolaModificata;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class represents the play zone of the game.
 * @author Francesco Debbi
 *
 */
public class PlayZone {
	// attributes
	/**
	 * A simple list of the 2 cards that are played.
	 * The implementation of this class will need to be changed if 
	 * a 4 play game mode is intended to be developed.
	 */
	List<Carta> playZone = new ArrayList<>(2);
	
	
	// methods
	/**
	 * This method takes the card played by each player
	 * and after a comparison, add both of them to the pile
	 * of the player who won the hand.
	 * @param g1
	 * @param g2
	 * @param briscola
	 */
	public boolean resolvePlayZone(Giocatore g1, Giocatore g2, Carta.Seme briscola) {
		List<Carta> presa = new ArrayList<>();
		playZone.add(g1.play());
		playZone.add(g2.play());
		for (Carta c : playZone) {
			c.inGioco();
		}
		presa.add(playZone.remove(0));
		presa.add(playZone.remove(0));
		if (presa.get(0).isWinning(presa.get(1), briscola)) {
			g1.getPila().prendi(presa);
			return true;
		} else g2.getPila().prendi(presa);
		return false;
	}

}
