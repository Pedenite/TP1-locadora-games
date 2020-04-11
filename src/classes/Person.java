package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
	private String name;
	private int id;
	private String cpf;
	private String email;
	private String phone;
	private List<Game> rentedGames;
	
	public Person (String name, int id, String cpf, String email, String phone) {
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
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date inicio = new Date(time);
		Date fim = new Date(g.getEndTime());
		System.out.println("Game " + g.getName() + " rented for " + i + " days from " + sdf.format(inicio) + " until " + sdf.format(fim));
	}
	
	public void returnGame(Game g) {
		rentedGames.remove(g);
		System.out.println("The client must pay $" + g.getTotalToPay());
	}
	
	@Override
	public String toString() {
		
		return "Name:\t" + this.name + "\nID:\t" + this.id + "\nCPF:\t" + this.cpf + "\nE-mail:\t" + 
				this.email + "\nPhone:\t" + this.phone + "\nGames:\t" + this.rentedGames;
	}
}
