package Links;

import java.util.ArrayList;

public class ATP {
	
	private final ArrayList<TravelLink> activityTravelParttern;
	
	private int flow;
	
	private double totalUtility;
	
	private double waitingTime;
	
	public ATP(ArrayList<TravelLink> activityTravelParttern, int flow,double waitingTime) {
		
		this.activityTravelParttern = activityTravelParttern;
		this.flow = flow;
		this.totalUtility = 0;
		this.waitingTime = waitingTime;
	}
	
	public double getTotalDisUtility() {
		
		for(TravelLink link : activityTravelParttern) {
			totalUtility += link.getLinkDisutility(flow, waitingTime);
		}
		return totalUtility;
	}
}
