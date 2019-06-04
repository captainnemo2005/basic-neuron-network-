package Links;

import Parameters.TravelDisU;
import Places.Location;

public class PTLink implements Link, TravelLinks{
	
	private static Location origin;
	private static Location destination;
	private static float travelTime;
	private static float disutility;
	private int flows;
	
	public PTLink(Location origin,Location destination) {
		this.origin = origin;
		this.destination = destination;
		travelTime = 0;
		disutility = 0;
		flows = origin.getPTFlows();
	}
	// just actually the crowding effect make IVT feel slightly longer
	public float pt_travelTime() {
		

		travelTime = (float) (TravelDisU.FREE_FLOW_TRAVEL_TIME_PT + 
				TravelDisU.N_A*Math.pow((Math.max(0, flows - 
						TravelDisU.CROWDING_PERCEPTION*TravelDisU.FREE_FLOW_TRAVEL_TIME_PT))/
						(TravelDisU.FREE_FLOW_TRAVEL_TIME_PT), TravelDisU.GAMMA_PT));
		return travelTime;
	}
	
	public float pt_Disutility(int currentFlowSize) {
		
		disutility = (float) (TravelDisU.lamba_1*travelTime + 
				TravelDisU.lamba_2*TravelDisU.PT_FEE*TravelDisU.FREE_FLOW_TRAVEL_TIME_PT);
		
		return disutility;
	}
	
	public void updateDestination() {
		destination.update_pt_arrivalFlows(flows);
	}
	
	
	@Override
	public int getLinkDestinationId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getLinkDisutility() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getLinkOriginId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getTravelTime() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void reset() {
		
	}
}
