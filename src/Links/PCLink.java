package Links;

import Parameters.TravelDisU;
import Places.Location;

public class PCLink implements Link, TravelLinks{
	
	private static Location origin;
	private static Location destination;
	private static float travelTime;
	private static float disutility;
	private int flows;
	
	public PCLink(Location origin,Location destination) {
		this.origin = origin;
		this.destination = destination;
		travelTime = 0;
		disutility = 0;
		flows = origin.getPhysicalFlows();
	}
	
	public float calculatingTravelTime() {

		travelTime = (float) (TravelDisU.FREE_FLOW_TRAVEL_TIME_PC_SC + 
				TravelDisU.N_A * Math.pow((flows/TravelDisU.CAPACITY), TravelDisU.CAPACITY));;
		return travelTime;
	}
	
	public float calculatingDisUtility() {
		disutility = (float) ((TravelDisU.lamba_1+ 
				TravelDisU.lamba_2*TravelDisU.C_FEE)*travelTime);		
		return disutility;
	}
	
	
	// after travelling time ==> the flow reach the destination
	public void updateDestination(){
		destination.update_pc_arrivalFlows(flows);
	}
	
	
	
	public float getDisutility() {
		return disutility;
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
