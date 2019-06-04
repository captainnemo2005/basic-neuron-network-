package Agents;

public class Traveller implements Agents {
	
	public static double arrivalTime;
	
	public static double departureTime;
	
	public int id;
	
	public Traveller(int id ) {
		this.arrivalTime = 0;
		this.departureTime = 0;
		this.id = id;
	}
	
	public void updateArrivalTime(double t) {
		this.arrivalTime += t;
	}
	
	public void updateDepartureTime(double t) {
		this.departureTime += t;
	}
	
	@Override
	public double getArrivalTime() {
		return this.arrivalTime;
	}
	
	@Override
	public double getDepartureTime() {
		return this.departureTime;
	}
	
	@Override
	public int getAgentId() {
		return this.id;
	}
}
