package briscolaModificata;

/**
 * The Plancia class represents the game board for a modified version of the game Briscola.
 * It contains the deck, players, play zone, and handles the game flow.
 */
public class Plancia {
    private Carta briscola;
    private Mazzo mazzo;
    private Giocatore bianco;
    private Giocatore nero;
    private Giocatore[] giocatori = new Giocatore[2];
    private PlayZone playZone = new PlayZone();
    private int turno = 0;
    
    /**
     * Constructs a Plancia object. Initializes the deck, players, and generates the briscola.
     */
    public Plancia() {
        mazzo = new Mazzo();
        bianco = new Giocatore(this.mazzo);
        nero  = new Giocatore(this.mazzo);
        giocatori[0] = bianco;
        giocatori[1] = nero;
        generateBriscola();
    }
    
    /**
     * Generates a briscola card from the deck.
     */
    public void generateBriscola() {
        briscola = mazzo.generateBriscola();
    }
    
    /**
     * Plays a single turn of the game.
     * First, each player draws a card and activates in-hand effects (Draw Phase).
     * Then, each player chooses which card to play and resolves the hand (Play Phase).
     * Finally, in-deck and in-pile effects are activated (End Phase).
     */
    public void playTurn() {
        // Draw phase
        // Each player draws a card if any is left in the deck.
        if (getMazzo().size() > 0) {
            giocatori[turno].getMano().draw(getMazzo());
            giocatori[(turno + 1) % 2].getMano().draw(getMazzo());
        }
        
        // In-hand effects activate
        giocatori[turno].getMano().activateInMano();
        giocatori[(turno + 1) % 2].getMano().activateInMano();
        
        // Hands are printed out
        System.out.println("Briscola: " + getBriscola());
        if (turno == 0) {
            System.out.println("Bianco: " + getBianco().getMano());
            System.out.println("Nero: " + getNero().getMano());
        } else {
            System.out.println("Nero: " + getNero().getMano());
            System.out.println("Bianco: " + getBianco().getMano());
        }
        
        // Play phase
        // Each player selects which card to play
        giocatori[turno].selectFromScanner();
        giocatori[(turno + 1) % 2].selectFromScanner();
        
        // The hand is resolved
        if (!getPlayZone().resolvePlayZone(giocatori[turno], giocatori[(turno + 1) % 2], getBriscola().getSeme())) {
            changeTurn();
        }
        
        // End phase
        // In-deck effects activate
        getMazzo().activateInMazzo();
        
        // In-pile effects activate
        giocatori[turno].getPila().activateInScarti();
        giocatori[(turno + 1) % 2].getPila().activateInScarti();
    }
    
    /**
     * Starts the game and continues playing turns until no cards are left in the players' hands.
     * Prints the final scores and declares the winner or a draw.
     */
    public void game() {
        while (getBianco().getMano().size() > 0 || getNero().getMano().size() > 0) {
            playTurn();
        }
        
        System.out.println();
        System.out.println("Il Bianco ha totalizzato: " + getBianco().getPila().getPunti() + " Punti.");
        System.out.println("Il Nero ha totalizzato: " + getNero().getPila().getPunti() + " Punti.");
        
        if (getBianco().getPila().getPunti() < getNero().getPila().getPunti()) {
            System.out.println("Ha vinto il Bianco!");
        } else if (getBianco().getPila().getPunti() == getNero().getPila().getPunti()) {
            System.out.println("Pareggio");
        } else {
            System.out.println("Ha vinto il Nero!");
        }
    }
    
    /**
     * Changes the current turn to the next player.
     */
    public void changeTurn() {
        setTurno(getTurno() + 1);
    }
    
    /**
     * Returns the briscola card.
     * 
     * @return The briscola card.
     */
    public Carta getBriscola() {
        return briscola;
    }
    
    /**
     * Returns the deck of cards.
     * 
     * @return The deck of cards.
     */
    public Mazzo getMazzo() {
        return mazzo;
    }
    
    /**
     * Sets the deck of cards.
     * 
     * @param mazzo The deck of cards.
     */
    public void setMazzo(Mazzo mazzo) {
        this.mazzo = mazzo;
    }
    
    /**
     * Returns the player Bianco.
     * 
     * @return The player Bianco.
     */
    public Giocatore getBianco() {
        return bianco;
    }
    
    /**
     * Sets the player Bianco.
     * 
     * @param bianco The player Bianco.
     */
    public void setBianco(Giocatore bianco) {
        this.bianco = bianco;
    }
    
    /**
     * Returns the player Nero.
     * 
     * @return The player Nero.
     */
    public Giocatore getNero() {
        return nero;
    }
    
    /**
     * Sets the player Nero.
     * 
     * @param nero The player Nero.
     */
    public void setNero(Giocatore nero) {
        this.nero = nero;
    }
    
    /**
     * Returns the play zone.
     * 
     * @return The play zone.
     */
    public PlayZone getPlayZone() {
        return playZone;
    }
    
    /**
     * Sets the play zone.
     * 
     * @param playZone The play zone.
     */
    public void setPlayZone(PlayZone playZone) {
        this.playZone = playZone;
    }
    
    /**
     * Sets the briscola card.
     * 
     * @param briscola The briscola card.
     */
    public void setBriscola(Carta briscola) {
        this.briscola = briscola;
    }
    
    /**
     * Returns the current turn number.
     * 
     * @return The current turn number.
     */
    public int getTurno() {
        return turno;
    }
    
    /**
     * Sets the current turn number.
     * 
     * @param newTurno The new turn number.
     */
    private void setTurno(int newTurno) {
        turno = newTurno % 2;
    }
}
