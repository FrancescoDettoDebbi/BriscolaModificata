package briscolaModificata;

public class QuattroDiCoppe extends CartaVanilla {
	
	QuattroDiCoppe(){
		setSeme(Seme.COPPE);
		setValore(Valore.QUATTRO);
		
	}
	
	public void inMano() {
		if ((int) (Math.random() * 4) == 3) this.getValore().setPunteggio(getValore().getPunteggio() + 1);
	}
	
	@Override
	public String toString() {
		return "El Quattrero della Chupa";
	}
	

}
