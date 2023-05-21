package briscolaModificata;

/**
 * The <code>SetteDiBastoni</code> class represents a specific card in the modified version of the game Briscola.
 * It extends the <code>CartaVanilla</code> class and represents the card "Sette di Bastoni".
 */
public class SetteDiBastoni extends CartaVanilla {
    
    /**
     * Constructs a <code>SetteDiBastoni</code> card.
     * Sets the suit to "BASTONI" and the value to "SETTE".
     */
    SetteDiBastoni() {
        setSeme(Carta.Seme.BASTONI);
        setValore(Carta.Valore.SETTE);
    }
    
    /**
     * Performs the in-game action for the card.
     * Prints "La briscola è BASTONI!" to indicate the suit of the card.
     */
    @Override
    public void inGioco() {
        System.out.print("La briscola è BASTONI!");
    }

    /**
     * Determines if this card wins against another card in the game.
     * Compares the suits and values of the two cards to determine the winner.
     * 
     * @param altraCarta The other card to compare against.
     * @param briscola The suit of the briscola card for the current hand.
     * @return <code>true</code> if this card wins, <code>false</code> otherwise.
     */
    @Override
    public boolean isWinning(Carta altraCarta, Carta.Seme briscola) {
        if (getSeme().equals(Carta.Seme.BASTONI) && !(altraCarta.getSeme().equals(Carta.Seme.BASTONI))) {
            return true;
        } else if (altraCarta.getSeme().equals(Carta.Seme.BASTONI) && !(getSeme().equals(Carta.Seme.BASTONI))) {
            return false;
        } else {
            if (getValore().getIndiceNumerico() > altraCarta.getValore().getIndiceNumerico()) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    /**
     * Returns a string representation of the card.
     * Includes the suit, value, and a special note for the card.
     * 
     * @return The string representation of the card.
     */
    @Override
    public String toString() {
        return super.toString() + "@Se questa carta viene giocata per prima, la briscola è BASTONI per questa mano.";
    }
}
