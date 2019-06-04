package Links;

import Parameters.TravelDisU;
import Places.Location;

public class SCLink implements Link, TravelLinks{
	
	private static Location origin;
	private static Location destination;
	private static float travelTime;
	private static float disutility;
	
	private int flows;
	
	public SCLink(Location origin,Location destination) {
		this.origin = origin;
		this.destination = destination;
		travelTime = 0;
		disutility = 0;
		flows = origin.getInFlow();
	}
	
	public float calculatingTravelTime() {

		travelTime = (float) (TravelDisU.FREE_FLOW_TRAVEL_TIME_PC_SC + 
				TravelDisU.N_A * Math.pow((flows/TravelDisU.CAPACITY), TravelDisU.CAPACITY));;
		return travelTime;
	}
	
	public float sc_Disutility() {
		
		disutility = (float) (/*TravelDisU.lamba_0*waitingTime +*/ TravelDisU.lamba_1*travelTime +
				TravelDisU.lamba_2*TravelDisU.CS_FEE*travelTime);
		
		return disutility;
	}
	
	public void updateDestination() {
		destination.update_sc_arrivalFlows(flows);
	}
	@Override
	public int getLinkDestinationId() {
		// TODO Auto-generated method stub
		return destination.getNodeId();
	}
	@Override
	public float getLinkDisutility() {
		// TODO Auto-generated method stub
		return disutility;
	}
	@Override
	public int getLinkOriginId() {
		// TODO Auto-generated method stub
		return origin.getNodeId();
	}
	@Override
	public float getTravelTime() {
		return travelTime;
	}
	@Override
	public void reset() {
		flows = 0;
	}
}
