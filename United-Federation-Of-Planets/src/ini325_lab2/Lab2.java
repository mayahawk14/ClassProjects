package ini325_lab2;

/*
 * Lab2 is a Java class containing a main method to run your program when completed.
 * This class will not compile until you have completed the requirements outlined in 
 * the lab description.
 * 
 * @author CS3443
 * 
 **/

public class Lab2 {
	
	public static void main( String[] args ) {
		
		Fleet unitedFederation = new Fleet( "United Federation of Planets" );
		
		try {
			unitedFederation.loadStarships( "data" );
			
		}catch( Exception e ) {
			// this is a try/catch which will show any errors to the console (more on these in coming weeks!)
			e.printStackTrace();
		}
			
		System.out.println( unitedFederation );
		
	}

}