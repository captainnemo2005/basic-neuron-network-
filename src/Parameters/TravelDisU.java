package Parameters;

public class TravelDisU {
	
	// disUtilities Coefficient
	public static final double lamba_0 = 0.002; // no unit
	public static final double lamba_1 = 0.1; // disUtitlity/min
	public static final double lamba_2 = 0.15; //disUtility/$
	
	// Monentary cost fee
	public static final double PT_FEE = 0.1; // $/min
	public static final double CS_FEE = 0.09; // $/min
	public static final double C_FEE  = 0.1;
	      
	// parameters for public transport disutility
	public static final double CROWDING_PERCEPTION		= 0.5;	// v
	public static final int PT_CAPACITY 				= 200; 	// vehicles
	public static final int FREQUENCY 					= 15; 	// mins
	public static final int FREE_FLOW_TRAVEL_TIME_PT 	= 35; 	// mins
	public static final double N_A  					= 0.15;
	public static final int GAMMA_PT					= 4;
	
	// parameter for SC and PC disutility
	public static final int FREE_FLOW_TRAVEL_TIME_PC_SC = 30;	// mins
	public static final int GAMMA_PC_SC					= 1;
	public static final int CAPACITY					= 100;	// vehicles
}
