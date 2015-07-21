package tools;

import java.util.Random;


/** 
 * Used to produce a {@link Random} RNG object <br>
 * The RNG seed can be set by a command line parameter - the array of strings should be passed into the constructor<br>
 * If no parameter is passed or if the first parameter is not a valid integer then a default value of 0 is used
 * to seed the RNG
 * @author J Paul Gibson
 * @version 1
 */
public class SeedRNGCommandLine {

	/** 
	 * @param args is the array of strings read in from the command line
	 * @returns an appropriately seeded {@link Random} RNG object
	 */
	public static Random getRandom(String[] args){
	/**
	 * The seed for generating random tests is, by default, set to 0; but can be over-ridden by a command line parameter
	 */
	    long rngSeed = 0;
			
			if (args.length ==0) {
		      	System.out.println("The seed used for the random number generator in the test is "+rngSeed+
		      			           ".\nYou can override this value by passing an integer value as a main argument parameter," +
		      			           " if you so wish.\n");  	
		    }
		    
		    else try{rngSeed = Integer.parseInt(args[0]);
		              System.out.println("The seed  used for the random number generator in the test is "+ rngSeed);}
	             catch (NumberFormatException exc){
	            	   System.out.println("First argument was not an integer");  
	            	   System.out.println("The seed  used for the random number generator in the test is "+ rngSeed);  
	             }
	            
	return new Random(rngSeed);
	}
}
