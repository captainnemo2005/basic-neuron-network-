package Places;

import java.util.LinkedList;
import java.util.Queue;

public class Location implements  Node{
	
	public final int nodeId;
	public final int nodeUtility;
	public final int locationCapcity;
	public final int durationOfActivity;
	
	//public static Queue<Integer> peopleAtThisLocation ;
	public static int supply_CS;
	public static int demand_CS;
	public static int sc_inFlowsFromThisLocation; //  r
	
	// arrival flow of each mode at this location 
	public static int pc_arrivalFlows;			// u == v
	public static int sc_arrivalFlows;			// u
	public static int pt_arrivalFlows;			// u == v
	
	public static int sc_outFlowsToThisLocation; // v(*i)
	
	public Location(int nodeId, int nodeUtility,  int Supply_CS, int locationCapcity, int durationOfActivity ) {
		this.nodeId 				= nodeId;
		this.nodeUtility 			= nodeUtility;
		supply_CS  					= Supply_CS;
		this.locationCapcity 		= locationCapcity;
		this.durationOfActivity 	= durationOfActivity;
		
		//peopleAtThisLocation 		= new LinkedList<>();
		demand_CS 					= 0;
		sc_inFlowsFromThisLocation = 0;
		
		pc_arrivalFlows 			= 0;
		sc_arrivalFlows				= 0;
		pt_arrivalFlows				= 0;
		
		sc_outFlowsToThisLocation	= 0;
	}
	
	public void update_sc_arrivalFlows(int arrivalFlow) {
		sc_arrivalFlows = arrivalFlow;
	}
	
	public void update_pc_arrivalFlows(int arrivalFlow) {
		pc_arrivalFlows = arrivalFlow;
	}
	
	public void update_pt_arrivalFlows(int arrivalFlow) {
		pt_arrivalFlows = arrivalFlow;
	}
	
	public int getPhysicalFlows() {
		return (pc_arrivalFlows + sc_inFlowsFromThisLocation);
	}
	
	public int getPTFlows() {
		return pt_arrivalFlows;
	}
	
	public int getPCFlows() {
		return pc_arrivalFlows;
	}
	/// calculation the inflow for carsharing
	public void calculatingInFlow( int relocationFlow) {
		
		// Updating information for the location about carsharing function
		updateLocationInfo(relocationFlow);
		
		// initiating number of people that are waiting at this location == arrival flow
		//for(int i = 0 ; i < arrivalFlow ; i++) {
		//	peopleAtThisLocation.add(i);
		//}
		//System.out.println("There are " + peopleAtThisLocation.size() + " that are waiting at this location before checking stocks ");	
		// checking the carsharing suppply status
		int carSharingConstraint = checkCarSharingStock();
		
		//System.out.println(carSharingConstraint);
		
		// updating the inFlow Based on condition 
		
		if(carSharingConstraint == 1) {
			sc_inFlowsFromThisLocation = demand_CS;
			//supply_CS -= demand_CS;
			//demand_CS  = 0;
			// remove all people is waiting at the location for CS since now all the Demand are served
			//for(int i = 0 ; i < peopleAtThisLocation.size() ; i++) {
			//	peopleAtThisLocation.remove();
			//}
			System.out.println("The inFlow is " + sc_inFlowsFromThisLocation);
			return;
		}
			
		if(carSharingConstraint == 2) {
			sc_inFlowsFromThisLocation = supply_CS;
			//for(int i = 0 ; i < inFlow ; i++) {
			//	peopleAtThisLocation.remove();
			//}
			System.out.println("The inFlow is " + sc_inFlowsFromThisLocation);
			return;
		}
			
		if (carSharingConstraint == 0) {
			sc_inFlowsFromThisLocation = 0;
			//demand_CS += arrivalFlow;
			//for(int i = 0 ; i < demand_CS ; i++) {
			//	peopleAtThisLocation.add(i+peopleAtThisLocation.size());
			//}
			System.out.println("The inFlow is " + sc_inFlowsFromThisLocation);
			return;
		}
			
		else {
			System.out.println("calculatingInFlow has problem");
			System.out.println(" the carSharingConstraint is " + carSharingConstraint);
			return;
		}
			
		
	}
	
	/*public void updatePeopleInThisLocation(int arrivalFlow, int constraints) {
		switch(constraints) {
		/// this is unchecked
			case 1:
				for(int i = 0 ; i < inFlow ; i++)
					peopleAtThisLocation.remove();
			case 2:
				for(int i = 0 ; i < inFlow ; i++)
					peopleAtThisLocation.remove();
			case 3:
				for(int i = 0 ; i < arrivalFlow ; i++)
					peopleAtThisLocation.add(i);
			default: System.out.println("UpdatePeopleInThisLocation has problem");
		}
	} */
	
	// updating the location information based on the inflow , outflow and relocation flow from/to this location.
	public void updateLocationInfo(int relocationFlow) {
		updateSupply(relocationFlow);
		updateDemand();
	}
	
	// updating for carsharing supply(t) = supply(t-1) + v(t) - inFlow - relocationFLow
	public void updateSupply(int relocationFlow) {
		supply_CS = supply_CS + sc_outFlowsToThisLocation - sc_inFlowsFromThisLocation - relocationFlow;
	}
	// updating for carsharing demand(t) = demand(t-1) + u(t) - inFlow
	public void updateDemand() {
		demand_CS = demand_CS + sc_arrivalFlows - sc_inFlowsFromThisLocation;
	}
	
	
	/// constraint for carsharing.
	public int checkCarSharingStock() {
		// letting the arrival flow coming out 0 < demand(t) <= supply(t)
		if((supply_CS >= demand_CS) && (demand_CS >= 0)){
			//System.out.println("demand is " +  demand_CS + " Supply is " + supply_CS );
			return 1;
			}
		// letting SC coming out with 0 < supply(t) < demand(t)
		else if((demand_CS >supply_CS ) && (supply_CS >=0)) {
			//System.out.println("demand is " +  demand_CS + " Supply is " + supply_CS );
			return 2;
			}
			// if supply is zero so there is no more CS
		else if(supply_CS == 0){
			//System.out.println("demand is " +  demand_CS + " Supply is " + supply_CS );
			return 0;
			}
		// Error report
		System.out.println("CheckCarSharingStock has problem");
		return -1;
	}
	
	public int getSupply() {
		return supply_CS;
	}
	
	public int getDemand() {
		return demand_CS;
	}
	
	public int getInFlow() {
		return sc_inFlowsFromThisLocation;
	}
	//public int getNumOfPeopleWaiting() {
		//return peopleAtThisLocation.size();
	//}
	@Override
	public int getNodeUtility() {
		return nodeUtility;
	}
	
	@Override
	public int getNodeId() {
		return nodeId;
	}
	@Override
	public void reset() {
		supply_CS = 0;
		demand_CS = 0;
	}
}
