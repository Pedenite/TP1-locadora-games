package test;

import classes.Game;
import classes.Person;

public class TestSystem {
	public static void main(String args[]) {
		Person p = new Person("a", 1, "b", "c", "d");
		Game g = new Game("God of War", 10);
		
		p.rentGame(g, 15);
		
		System.out.println(p);
		
		p.returnGame(g);
	}
}