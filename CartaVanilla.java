package briscolaModificata;

/**
 * This class represents a vanilla card, which is a simple card used for testing purposes.
 * It extends the abstract class {@link Carta} and inherits its properties and methods.
 * The vanilla card contains a value and a suit.
 * 
 * <p>
 * Example usage:
 * <pre>{@code
 * CartaVanilla carta = new CartaVanilla();
 * carta.inMano();
 * System.out.println(carta);
 * }</pre>
 * Output: "inMano"
 * </p>
 * 
 * <p>
 * Example usage with custom value and suit:
 * <pre>{@code
 * Carta.Seme seme = Carta.Seme.COPPE;
 * Carta.Valore valore = Carta.Valore.ASSO;
 * CartaVanilla carta = new CartaVanilla(seme, valore);
 * carta.inGioco();
 * System.out.println(carta);
 * }</pre>
 * Output: "inGioco"
 * </p>
 * 
 * @see Carta
 * @author Francesco Debbi
 */
public class CartaVanilla extends Carta {
    
    /**
     * Default constructor for creating a CartaVanilla object.
     * This constructor is used in actual card classes.
     * The specific card classes will have predefined values for suit and value.
     */
    public CartaVanilla() {
        
    }
    
    /**
     * Constructor for creating a CartaVanilla object with the specified suit and value.
     * 
     * @param s The suit of the card.
     * @param v The value of the card.
     */
    public CartaVanilla(Carta.Seme s, Carta.Valore v) {
        setValore(v);
        setSeme(s);
    }
    
    /**
     * Placeholder implementation for the "inMano" method.
     * Prints "inMano" to the console.
     */
    public void inMano() {
        System.out.println("inMano");
    }
    
    /**
     * Placeholder implementation for the "inMazzo" method.
     * Prints "inMazzo" to the console.
     */
    public void inMazzo() {
        System.out.println("inMazzo");
    }
    
    /**
     * Placeholder implementation for the "inGioco" method.
     * Prints "inGioco" to the console.
     */
    public void inGioco() {
        System.out.println("inGioco");
    }
    
    /**
     * Placeholder implementation for the "inScarti" method.
     * Prints "inScarti" to the console.
     */
    public void inScarti() {
        System.out.println("inScarti");
    }
}
