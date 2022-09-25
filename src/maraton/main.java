package maraton;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws Exception {
		Ranking ranking = new Ranking();

		Runner itzel = new Runner("Itzel", "Maestro", 4, ranking);
		Runner diego = new Runner("Diego", "Profesional", 7, ranking);
		Runner sofia = new Runner("Sofia", "Principiante", 12, ranking);
		Runner aitza = new Runner("Aitza", "Profesional", 9, ranking);
		Runner foo = new Runner("Foo", "Experto", 28, ranking);
		Runner adolfo = new Runner("Adolfo", "Profesional", 14, ranking);
		Runner ramon = new Runner("Ramon", "Principiante", 21, ranking);
		Runner alonzo = new Runner("Alonzo", "Maestro", 1, ranking);
		Runner jose = new Runner("Jose", "Experto", 34, ranking);
		Runner carolina = new Runner("Carolina", "Maestro", 5, ranking);
		
		diego.start();
		itzel.start();
		sofia.start();
		aitza.start();
		foo.start();
		adolfo.start();
		ramon.start();
		alonzo.start();
		jose.start();
		carolina.start();
		
		diego.join();
		itzel.join();
		sofia.join();
		aitza.join();
		foo.join();
		adolfo.join();
		ramon.join();
		alonzo.join();
		jose.join();
		carolina.join();
		
		System.out.println("\u001B[32m" + "<-------------- Tabla de posiciones -------------->");
		ArrayList<String> rankingTable = ranking.getRanking();
		for(int i=0; i<rankingTable.size(); i++) {
			System.out.println(i+1+".- "+rankingTable.get(i));
		}
		System.out.println("\u001B[31m"+"<-------------- Tabla de incapacitados -------------->");
		ArrayList<String> loosersTable = ranking.getLoosers();
		for(int i=0; i<loosersTable.size(); i++) {
			System.out.println(i+1+".- "+loosersTable.get(i));
		}
	}

}
