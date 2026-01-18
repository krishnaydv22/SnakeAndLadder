package Models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	int noOfdice;
	int min = 1;
	int max = 6;
	
	public Dice(int num) {
		this.noOfdice = num;
	}
	
	
	public int rollDice() {
		
		
		int start = 0;
		int total = 0;
		while(start < noOfdice) {
			total += ThreadLocalRandom.current().nextInt(min, max + 1);
			start++;
		}
		return total;
		
		
	}

}
