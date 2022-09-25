package maraton;
import java.util.ArrayList;

public class Ranking{
	
	ArrayList<String> ranking = new ArrayList<String>();
	ArrayList<String> loosers = new ArrayList<String>();

	
	public void setRankingPosition (String name) {
		ranking.add(name);
	}
	
	public void setLoosers (String name) {
		loosers.add(name);
	}
	
	public ArrayList<String> getLoosers(){
		return loosers;
	}

	public ArrayList<String> getRanking () {
		return ranking;
	}
}
