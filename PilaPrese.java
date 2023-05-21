package briscolaModificata;

import java.util.ArrayList;
import java.util.List;

public class PilaPrese {
	
	// attributes
	/**
	 * The list of cards in a player points pile.
	 */
	private List<Carta> pila;
	
	// constructor
	/**
	 * This method creates a PilaPrese object.
	 */
	PilaPrese(){
		inizializzaPilaPrese();
	}
	
	// methods
	/**
	 * This method set the pila field to a ArrayList of Cards.
	 * The maximum size of this list is supposed to be 40;
	 */
	public void inizializzaPilaPrese() {
		pila = new ArrayList<>(40);
	}
	
	/**
	 * This method calculates the total score of the pile.
	 * @return the total score of the pile.
	 */
	public int getPunti(){
		int somma = 0;
		for(Carta c : pila) {
			somma += c.getValore().getPunteggio();
		}
		return somma;
	}
	
	/**
	 * this method add the cards in play into the pila list.
	 * @param presa
	 */
	public void prendi(List<Carta> presa) {
		presa.forEach(carta -> pila.add(carta));
	}
	
	public void activateInScarti() {
		getPila().forEach(carta -> carta.inScarti());
	}
// getter
	public List<Carta> getPila() {
		return pila;
	}
// setter
	public void setPila(List<Carta> pila) {
		this.pila = pila;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[-");
		pila.forEach(carta -> {s.append(carta); s.append("-");});
		s.append("]");
		return s.toString();
	}

}
