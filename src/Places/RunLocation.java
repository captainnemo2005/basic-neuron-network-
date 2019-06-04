package Places;

public class RunLocation {
	
	public static void main(String [] args) {
		
		// Location contains id 1 , 
		// utility 20,
		// initial supply for CS is 10,
		// Location capacity 200,
		// duration of activity is 30 mins
		Location home = new Location(1,20,10,200,30);
		System.out.println("Initially");
		System.out.println("demand " + home.getDemand());
		System.out.println("supply " + home.getSupply());

		
		home.calculatingInFlow( 0); 
		
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
		

		home.calculatingInFlow( 0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());

		home.calculatingInFlow(0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
		
		home.calculatingInFlow( 0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
		
		home.calculatingInFlow( 0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
		
		home.calculatingInFlow(0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
		
		home.calculatingInFlow(0); 
		System.out.println("After that ");
		System.out.println("supply " + home.getSupply());
		System.out.println("demand " + home.getDemand());
	/**/}
}
