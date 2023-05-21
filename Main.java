package briscolaModificata;

public class Main {

	public static void main(String[] args) {
		Plancia plancia = new Plancia();
		Carta.Seme briscola = plancia.generateBriscola();
		plancia.game();
//		System.out.println(plancia.getBriscola());
//		System.out.println(plancia.getBianco().getMano());
//		System.out.println(plancia.getNero().getMano());
//		for (int i = 0; i < 17; i ++ ) {
//			plancia.getBianco().getMano().activateInMano();
//			plancia.getNero().getMano().activateInMano();
//			plancia.getBianco().setSelezione((int) (Math.random() * 3));
//			plancia.getNero().setSelezione((int) (Math.random() * 3));
//			System.out.println(plancia.getBianco().getSelezione());
//			System.out.println(plancia.getNero().getSelezione());
//			plancia.getPlayZone().resolvePlayZone(plancia.getBianco(), plancia.getNero(), briscola);
//			System.out.println("punti Bianco: " + plancia.getBianco().getPila().getPunti());
//			System.out.println("punti Nero: " + plancia.getNero().getPila().getPunti());
//			plancia.getBianco().getMano().draw(plancia.getMazzo());
//			plancia.getNero().getMano().draw(plancia.getMazzo());
//			System.out.println(plancia.getBianco().getMano());
//			System.out.println(plancia.getNero().getMano());
//		}
//		for (int i = 0; i < 3; i ++ ) {
//
//			plancia.getBianco().setSelezione((int) (Math.random() * plancia.getBianco().getMano().size()));
//			plancia.getNero().setSelezione((int) (Math.random() * plancia.getBianco().getMano().size()));
//			System.out.println(plancia.getBianco().getSelezione());
//			System.out.println(plancia.getNero().getSelezione());
//			plancia.getPlayZone().resolvePlayZone(plancia.getBianco(), plancia.getNero(), briscola);
//			System.out.println("punti Bianco: " + plancia.getBianco().getPila().getPunti());
//			System.out.println("punti Nero: " + plancia.getNero().getPila().getPunti());
//			
//		}
	}

}
