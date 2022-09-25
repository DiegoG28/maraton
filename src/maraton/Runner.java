package maraton;
import java.lang.Thread;
import java.lang.Math;

public class Runner extends Thread {
	
	String name;
	String state;
	int runnerNumber;
	int speed;
	Ranking ranking;
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[35m";

	
	public Runner (String name, String speed, int number, Ranking ranking) {
		this.name = name;
		this.ranking = ranking;
		this.runnerNumber = number;
		this.state = "Ideal";
		
		if (speed == "Principiante") {
			this.speed = 150;
		} else if (speed == "Experto") {
			this.speed = 240;
		} else if (speed == "Maestro") {
			this.speed = 280;
		} else if (speed == "Profesional") {
			this.speed = 300;
		}
	}

	public void move(int m) throws InterruptedException {
		checkSpeed();
		Thread.sleep(5000 - (speed*10));
		System.out.println(ANSI_YELLOW + name + " ha avanzado " + m + " mts.");
	}
	
	public void setState() {
		double probability = Math.random();
		
		if (probability <= 0.5) {
			state = "Ideal";
		} else if (probability <= 0.8) {
			state = "Lesionado";
		} else if (probability <= 0.95) {
			state = "Cansado";
		} else if (probability <= 1) {
			state = "Fracturado";
		}
		
		setSpeed();
	}
	
	public void setSpeed() {
		if (state == "Lesionado") {
			 speed = speed / 2;
		} else if (state == "Cansado") {
			speed = speed - 10;
		} else if (state == "Fracturado") {
			speed = 0;
		}
	}
	
	public void checkSpeed() {
		if (speed <= 0) {
			ranking.setLoosers(name + " No. " + String.valueOf(runnerNumber));
			stop();
		}
	}
	
	public void run() {
		System.out.println("Arranca " + name);
		for(int i=1; i<=10; i++) {
			try {
				move(i);
				if (i != 10) {
					setState();
					System.out.println(ANSI_PURPLE + name + " está: " + state + ":" + speed);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 3) {
				System.out.println(name + " está descansando en la estación A");
			} else if (i == 6) {
				System.out.println(name + " está descansando en la estación B");
			} else if (i == 9 ) {
				System.out.println(name + " está descansando en la estación C");
			}
		}
		System.out.println(ANSI_GREEN + "---------" + name + " ha llegado a la meta." + "---------");
		ranking.setRankingPosition(name + " No. " + String.valueOf(runnerNumber));
	}
}
