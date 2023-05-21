package briscolaModificata;

/**
 * This abstract class represents a generic card in the modified Briscola game.
 * It is intended to be extended by actual single card classes.
 * All cards have one or more effects that are activated when they are in hand, in play, in the deck, or in the points pile.
 * The abstract methods of this class will contain the descriptions of these effects.
 * 
 * <p>
 * Example usage:
 * <pre>{@code
 * Carta carta = new QuattroDiCoppe();
 * carta.inMano();
 * System.out.println(carta);
 * }</pre>
 * </p>
 * 
 * The Card class has two properties: the card suit (Seme) and the card value (Valore).
 * It also provides methods to get and set these properties.
 * 
 * The Seme and Valore properties are defined as enumerations that enumerate the possible values they can assume.
 * The Valore enumeration contains additional properties to represent the numerical index and the score value of each card value.
 * 
 * The Card class also provides abstract methods for the different card effects when the card is in hand, in the deck, in play, or in the points pile.
 * It also includes a method to determine if the card is winning during the "in play" phase of the game.
 * The class overrides the equals() and toString() methods for custom comparison and string representation of the Card object.
 * </p>
 * 
 * @see QuattroDiCoppe
 * @see CartaVanilla
 * @author Francesco Debbi
 */
public abstract class Carta {
    
    /**
     * This enumeration lists the possible values a card suit (seme) can assume.
     */
    protected enum Seme {
        BASTONI,
        COPPE,
        DENARI,
        SPADE;
    }
    
    /**
     * This enumeration lists the possible values a card value (valore) can assume.
     * It also includes properties for the numerical index and score value of each card value.
     */
    protected enum Valore {
        ASSO(12, 11),
        DUE(2, 0),
        TRE(11, 10),
        QUATTRO(4, 0),
        CINQUE(5, 0),
        SEI(6, 0),
        SETTE(7, 0),
        FANTE(8, 2),
        CAVALLO(9, 3),
        RE(10, 4);
        
        /**
         * The numerical index of the card value.
         */
        private int indiceNumerico;
        
        /**
         * The score value of the card value.
         */
        private int punteggio;
        
        /**
         * Constructs a Valore object with the specified indiceNumerico and punteggio values.
         * 
         * @param indiceNumerico The numerical index of the card value.
         * @param punteggio The score value of the card value.
         */
        Valore(int indiceNumerico, int punteggio) {
            this.indiceNumerico = indiceNumerico;
            this.punteggio = punteggio;
        }
        
        /**
         * Returns the numerical index of the card value.
         * 
         * @return The numerical index.
         */
        public int getIndiceNumerico() {
            return this.indiceNumerico;
        }
        
        /**
         * Returns the score value of the card value.
         * 
         * @return The score value.
         */
        public int getPunteggio() {
            return this.punteggio;
        }
        
        /**
         * Sets the numerical index of the card value.
         * 
         * @param indiceNumerico The new numerical index.
         */
        public void setIndiceNumerico(int indiceNumerico) {
            this.indiceNumerico = indiceNumerico;
        }
        
        /**
         * Sets the score value of the card value.
         * 
         * @param punteggio The new score value.
         */
        public void setPunteggio(int punteggio) {
            this.punteggio = punteggio;
        }
    }
    
    /**
     * The card suit (seme).
     */
    private Seme seme;
    
    /**
     * The card value (valore).
     */
    private Valore valore;
    
    /**
     * Returns the card suit (seme) of the Card object.
     * 
     * @return The card suit.
     */
    public Seme getSeme() {
        return this.seme;
    }
    
    /**
     * Returns the card value (valore) of the Card object.
     * 
     * @return The card value.
     */
    public Valore getValore() {
        return this.valore;
    }
    
    /**
     * Sets the card suit (seme) of the Card object.
     * 
     * @param seme The new card suit.
     */
    public void setSeme(Seme seme) {
        this.seme = seme;
    }
    
    /**
     * Sets the card value (valore) of the Card object.
     * 
     * @param valore The new card value.
     */
    public void setValore(Valore valore) {
        this.valore = valore;
    }
    
    /**
     * The implementation of this method should describe the effect of the card when it is in hand.
     */
    public abstract void inMano();
    
    /**
     * The implementation of this method should describe the effect of the card when it is in the deck.
     */
    public abstract void inMazzo();
    
    /**
     * The implementation of this method should describe the effect of the card when it is in play.
     */
    public abstract void inGioco();
    
    /**
     * The implementation of this method should describe the effect of the card when it is in the points pile.
     */
    public abstract void inScarti();
    
    /**
     * Determines if this card is winning during the "in play" phase of the game, given another card and the briscola suit.
     * 
     * @param altraCarta The other card to compare.
     * @param briscola The briscola suit.
     * @return True if this card is winning, false otherwise.
     */
    public boolean isWinning(Carta altraCarta, Seme briscola) {
        if (getSeme().equals(briscola) && !(altraCarta.getSeme().equals(briscola))) {
            return true;
        } else if (altraCarta.getSeme().equals(briscola) && !(getSeme().equals(briscola))) {
            return false;
        } else {
            return getValore().getIndiceNumerico() > altraCarta.getValore().getIndiceNumerico();
        }
    }
    
    /**
     * Returns a string representation of the Card object.
     * 
     * @return The string representation.
     */
    @Override
    public String toString() {
        return getValore() + " di " + getSeme();
    }
    
    /**
     * Checks if this card is equal to another object.
     * The comparison is based on the card values and suits.
     * 
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carta)) {
            return false;
        }
        Carta otherCard = (Carta) o;
        return getSeme().equals(otherCard.getSeme()) && getValore().equals(otherCard.getValore());
    }
}
