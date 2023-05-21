package briscolaModificata;

/**
 * <p>
 * This class represents a specific card called "Quattro di Coppe".<br>
 * It extends the {@link CartaVanilla} class and inherits its properties and methods.<br>
 * The card has a suit of COPPE and a value of QUATTRO.<br>
 * When the card is in hand, it has a 25% chance of gaining one point.
 * </p>
 * <p>
 * Example usage:
 * <pre>{@code
 * QuattroDiCoppe carta = new QuattroDiCoppe();
 * carta.inMano();
 * System.out.println(carta);
 * }</pre>
 * Output: "QUATTRO di COPPE@IN MANO: ha il 25% di probabilità di ottenere un punto"
 * </p>
 * </p>
 * @see CartaVanilla
 * @author Francesco Debbi
 */
public class QuattroDiCoppe extends CartaVanilla {
    
    /**
     * <p>
     * Default constructor for creating a QuattroDiCoppe object.<br>
     * Sets the suit to COPPE and the value to QUATTRO.
     * </p>
     */
    QuattroDiCoppe() {
        setSeme(Seme.COPPE);
        setValore(Valore.QUATTRO);
    }
    
    /**
     * <p>
     * This method represents the effect of the card when it is in hand.<br>
     * It has a 25% chance of increasing the point value by 1.
     * </p>
     */
    public void inMano() {
        if ((int) (Math.random() * 4) == 3) {
            this.getValore().setPunteggio(getValore().getPunteggio() + 1);
        }
    }
    
    /**
     * <p>
     * Returns a string representation of the card.<br>
     * Includes the card's value, suit, and information about its effect in hand.
     * </p>
     * @return the string representation of the card
     */
    @Override
    public String toString() {
        return super.toString() + "@IN MANO: ha il 25% di probabilità di ottenere un punto";
    }
}
