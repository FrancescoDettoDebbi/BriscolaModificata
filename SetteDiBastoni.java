package briscolaModificata;

public class SetteDiBastoni extends CartaVanilla{
	
	SetteDiBastoni(){
		setSeme(Carta.Seme.BASTONI);
		setValore(Carta.Valore.SETTE);
	}
	
	public void inGioco() {
		System.out.print("La briscola è BASTONI!");
	}

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
	
	@Override
	public String toString() {
		return super.toString() + "@Se questa carta viene giocata per prima, la briscola è BASTONI per questa mano.";
	}
}
