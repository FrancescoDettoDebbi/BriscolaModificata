package briscolaModificata;
/**
 * <p>This class is supposed to be abstract and then be extended by actual sigle card classes.<br>
 * All cards shall have one of more effects which will be activated either when they are
 * in hand, in play, in the deck or in the points pile.<br>
 * The abstract methods of this class will contain the just mentioned effects.<br>
 * @author Francesco Debbi
 * </p> 
 */
public abstract class Carta{
	/**
	 * <p>This field contains the card suit.</p>
	 */
	private Seme seme;
	/**
	 * <p>This field contains the card value.</p>
	 */
	private Valore valore;
	
	/**
	 * <p>This is the enum of the possible values a Seme can assume.</p>
	 */
	protected static enum Seme {
		BASTONI,
		COPPE,
		DENARI,
		SPADE;

	}

	/**
	 * <p>This is the enum of the possible values a Valore can assume.</p>
	 */
	protected static enum Valore {
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
		 * <p>This integer is used to check if a card is greater than another.<br>
		 * It is generally true that 2 < indiceNumerico < 12.<br>
		 * </p>
		 */
		private int indiceNumerico;

		/**
		 * <p>This integer represents the points a card is worth.<br>
		 * 2 to 7 except 3 are worth 0.<br>
		 * Fante is worth 2.<br>
		 * Cavallo is worth 3.<br>
		 * Re is worth 4.<br>
		 * 3 is worth 10.<br>
		 * Asso is worth 11.
		 * </p>
		 */
		private int punteggio;
		
		// constructor
		/**
		 * @param indiceNumerico {int}
		 * @param punteggio {int}
		 */
		Valore(int indiceNumerico, int punteggio){
			this.indiceNumerico = indiceNumerico;
			this.punteggio = punteggio;
			}

		// getter methods
		public int getIndiceNumerico() {
			return this.indiceNumerico;
			}
		
		public int getPunteggio() {
			return this.punteggio;
			}
		// setter methods
		public void setIndiceNumerico(int indiceNumerico) {
			this.indiceNumerico = indiceNumerico;
		}
		
		public void setPunteggio(int punteggio) {
			this.punteggio = punteggio;
		}

	}
	
	// getter methods
	public Seme getSeme() {
		return this.seme;
	}
	
	public Valore getValore() {
		return this.valore;
	}
	
	// setter methods
	public void setSeme(Seme seme) {
		this.seme = seme;
	}
	
	public void setValore(Valore valore) {
		this.valore = valore;
	}

	/**
	 * <p>The implementation of this method will describe the card effect when it is in hand.</p>
	 */
	public abstract void inMano();
	
	/**
	 * <p>The implementation of this method will describe the card effect when it is in the deck.</p>
	 */
	public abstract void inMazzo();
	
	/**
	 * <p>The implementation of this method will describe the card effect when it is in play.</p>
	 */
	public abstract void inGioco();
	
	/**
	 * <p>The implementation of this method will describe the card effect when it is in the points pile.</p>
	 */
	public abstract void inScarti();
	
	/**
	 * <p>
	 * This method returns true when this card isWinning during the "in play" phase of the game,
	 * it returns false in every other case.
	 * @param altraCarta {Carta}
	 * @param briscola {Carta.Seme}
	 * </p>
	 */
	public boolean isWinning(Carta altraCarta, Carta.Seme briscola) {
		if (getSeme().equals(briscola) && !(altraCarta.getSeme().equals(briscola))) {
			return true;
		} else if (altraCarta.getSeme().equals(briscola) && !(getSeme().equals(briscola))) {
			return false;
		} else {
			if (getValore().getIndiceNumerico() > altraCarta.getValore().getIndiceNumerico()) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String toString() {
		return getValore() + " di " + getSeme();
	}

	/**
	 * <p>
	 * This method returns true if and only if card values and suits match. 
	 * Else it returns false.
	 * </p>
	 * @param o {Object}
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Carta)) return false;
		if (!(((Carta) o).getSeme().equals(getSeme()))) return false;
		if (!(((Carta) o).getValore().equals(getValore()))) return false;
		return true;
	}

}
