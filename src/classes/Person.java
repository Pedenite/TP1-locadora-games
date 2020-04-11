package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.ExistingIdException;

public class Person {
	private static final Set<Integer> ids = new HashSet<Integer>();

	private String name;
	private int id;
	private String cpf;
	private String email;
	private String phone;
	private List<Game> rentedGames;
	
	public Person (String name, int id, String cpf, String email, String phone) throws ExistingIdException{
		if (!ids.add(id))
             throw new ExistingIdException("Repeated ID");
		this.name = name;
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		rentedGames = new ArrayList<>();
	}
	
	public void rentGame(Game g, int i) {
		rentedGames.add(g);
		g.setLocationDays(i);
		long time = System.currentTimeMillis();
		g.setStartTime(time);
		SimpleDateFormat sdfD = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfT = new SimpleDateFormat("hh:mm:ss");
		Date inicio = new Date(time);
		Date fim = new Date(g.getEndTime());
		System.out.println("Game " + g.getName() + " rented for " + i + " days from " + sdfD.format(inicio) + " until " + sdfD.format(fim) + "\nTime of the service: " + sdfT.format(time));
	}
	
	public void returnGame(Game g) {
		rentedGames.remove(g);
		System.out.println(this.name + " returned the game " + g.getName() + "!\nThe client must pay $" + g.getTotalToPay());
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		
		return "Name:\t" + this.name + "\nID:\t" + this.id + "\nCPF:\t" + this.cpf + "\nE-mail:\t" + 
				this.email + "\nPhone:\t" + this.phone + "\nGames:\t" + this.rentedGames;
	}
}
