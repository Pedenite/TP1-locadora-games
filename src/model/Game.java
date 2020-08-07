package model;

public class Game {
	private String name;
	private double pricePerDay;
	private long startTime;
	private int locationDays;
	
	public Game(String name, double price) {
		this.name = name;
		this.pricePerDay = price;
	}
	
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public void setLocationDays(int i) {
		this.locationDays = i;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getEndTime() {
		return startTime + locationDays*86400000;
	}
	
	public double getTotalToPay() {
		return locationDays * pricePerDay;
	}
	
	@Override
	public String toString() {
		return "Game: " + this.name + " | Price per day: " + this.pricePerDay + " | LD: " + this.locationDays;
	}
}
