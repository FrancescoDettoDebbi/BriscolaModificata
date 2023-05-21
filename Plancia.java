package briscolaModificata;

public class Plancia {
	private Carta briscola;
	private Mazzo mazzo;
	private Giocatore bianco;
	private Giocatore nero;
	private Giocatore[] giocatori = new Giocatore[2];
	private PlayZone playZone = new PlayZone();
	private int turno = 0;
	
	Plancia(){
		
		mazzo = new Mazzo();
		bianco = new Giocatore(this.mazzo);
		nero  = new Giocatore(this.mazzo);
		giocatori[0] = bianco;
		giocatori[1] = nero;
		generateBriscola();
	}
	
	public void generateBriscola(){
		briscola = mazzo.generateBriscola();
	}
	/**
	 * This method resolves a single turn of the game.
	 * First each player draws a card and in hand effects activate (Draw Phase).
	 * Then each player choose which card to play and the hand resolves (Play Phase).
	 * Finally in deck and in pile effects activate (End Phase)
	 */
	public void playTurn() {
		// draw phase
		// each player draws a card if any is left in the deck.
		if (getMazzo().size() > 0) {
			giocatori[turno].getMano().draw(getMazzo());
			giocatori[(turno + 1) % 2].getMano().draw(getMazzo());
			}
		// in hand effects activate
		giocatori[turno].getMano().activateInMano();
		giocatori[(turno + 1) % 2].getMano().activateInMano();
		// hands are printed out.
		System.out.println("Briscola: " + getBriscola());
		if (turno == 0) {
			System.out.println("Bianco: " + getBianco().getMano());
			System.out.println("Nero: " + getNero().getMano());
		} else {
			System.out.println("Nero: " + getNero().getMano());
			System.out.println("Bianco: " + getBianco().getMano());
		}
		//play phase
		// each player select which card to play
		giocatori[turno].selectFromScanner();
		giocatori[(turno + 1) % 2].selectFromScanner();
		// the hand resolve
		if (!getPlayZone().resolvePlayZone(giocatori[turno], giocatori[(turno + 1) % 2], getBriscola().getSeme())) changeTurn();
		// end phase
		// in deck effects activate
		getMazzo().activateInMazzo();
		// in pile effects activate
		giocatori[turno].getPila().activateInScarti();
		giocatori[(turno + 1) % 2].getPila().activateInScarti();
	}
	
//	public void playTurn(int select) {
//		// draw phase
//		// each player draws a card if any is left in the deck.
//		if (getMazzo().size() > 0) {
//		getBianco().getMano().draw(getMazzo());
//		getNero().getMano().draw(getMazzo());
//		}
//		// in hand effects activate
//		getBianco().getMano().activateInMano();
//		getNero().getMano().activateInMano();	
//		//play phase
//		// each player select which card to play
//		getBianco().setSelezione(select);
//		getNero().setSelezione(select);
//		// the hand resolve
//		if (!getPlayZone().resolvePlayZone(giocatori[turno], giocatori[(turno + 1) % 2], getBriscola().getSeme())) changeTurn();
//		// end phase
//		// in deck effects activate
//		getMazzo().activateInMazzo();
//		// in pile effects activate
//		getBianco().getPila().activateInScarti();
//		getNero().getPila().activateInScarti();
//	}
	
	public void game() {
		while (getBianco().getMano().size() > 0 || getNero().getMano().size() > 0) {
			playTurn();
		}
		System.out.println("");
		System.out.println("Il Bianco ha totalizzato: " + getBianco().getPila().getPunti() + " Punti.");
		System.out.println("Il Nero ha totalizzato: " + getNero().getPila().getPunti() + " Punti.");
		if (getBianco().getPila().getPunti() < getNero().getPila().getPunti()) System.out.println("Ha vinto il Bianco!");
		else if (getBianco().getPila().getPunti() == getNero().getPila().getPunti()) System.out.println("Pareggio");
		else System.out.println("Ha vinto il Nero!");
	}
	
	public void changeTurn() {
		setTurno(getTurno() + 1);
	}
	
	public Carta getBriscola() {
		return briscola;
	}

	public Mazzo getMazzo() {
		return mazzo;
	}

	public void setMazzo(Mazzo mazzo) {
		this.mazzo = mazzo;
	}

	public Giocatore getBianco() {
		return bianco;
	}

	public void setBianco(Giocatore bianco) {
		this.bianco = bianco;
	}

	public Giocatore getNero() {
		return nero;
	}

	public void setNero(Giocatore nero) {
		this.nero = nero;
	}

	public PlayZone getPlayZone() {
		return playZone;
	}

	public void setPlayZone(PlayZone playZone) {
		this.playZone = playZone;
	}

	public void setBriscola(Carta briscola) {
		this.briscola = briscola;
	}

	public int getTurno() {
		return turno;
	}
	
	private void setTurno(int newTurno) {
		turno = newTurno % 2;
	}
}
