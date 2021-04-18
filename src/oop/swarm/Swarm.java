package oop.swarm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oop.birds.Bird;


public class Swarm extends oop.birds.Bird {
	
	
	public List<Bird> getAllBirds() { /* ... */ return Collections.emptyList();  }
	
	public static void main(String[] args) {
		Bird b = new Bird();
		//b.test();
		
		Swarm s = new SuperSwarm();
		s.test();
	System.out.println(s.getAllBirds());
	}
	
	
	
	
	
	
	void help() {
		Bird b = new Bird();
		
	}

}
class SuperSwarm extends Swarm {
	@Override
	 public ArrayList<Bird> getAllBirds() { /* ... */ return null;}


	
}