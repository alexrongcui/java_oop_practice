// Developer: Ronggang Cui
// This program measures the performance for two approaches of string concatenation
// It only has one string but many times of operations

package ece325_lab_assignment6;

public class CompareLargeStringConcatenation {
	
	/**
	 * Creates a String object, performs concatOperations operations on it and returns the resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the String.
	 * @return The resulting String.
	 */
	private static String concatString(int concatOperations) {
		String myStr = "";
		
		for(int i=0; i< concatOperations; i++)
			myStr = myStr + "a";
		
		return myStr;
		 
	}
	
	/**
	 * Creates a StringBuilder object, performs concatOperations operations on it, converts the StringBuilder to a String and returns the 
	 * resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the StringBuilder.
	 * @return The resulting String.
	 */
	private static String concatStringBuilder(int concatOperations) {
		
		StringBuilder myStrBuilder = new StringBuilder(); 
		
		for(int i=0; i< concatOperations; i++)
			myStrBuilder.append("a");
		 
		return myStrBuilder.toString();
	}
	
	/**
	 * Measure the performance for the String and StringBuilder approaches, print the results
	 * @param concatOperations The number of concatenation operations to perform on the StringBuilder.
	 */
	private void concatMeasure(int concatOperations) {
		
		MillisPerformanceMeasurement myMeasurement = new MillisPerformanceMeasurement();
		
		// measure the performance for the String approach
		myMeasurement.start();
		concatString(concatOperations);
		myMeasurement.end();
		System.out.print(myMeasurement.getResult());
		System.out.print("\t\t");
		myMeasurement.reset();
		
		// measure the performance for the StringBuilder approach
		myMeasurement.start();
		concatStringBuilder(concatOperations);
		myMeasurement.end();
		System.out.println(myMeasurement.getResult());
		myMeasurement.reset();
		
	}
	

	public static void main(String[] args) {
		
		CompareLargeStringConcatenation myLarge = new CompareLargeStringConcatenation();
		
		// Increase the number of operations and see the results
		System.out.println("String" + "\t\t" + "StringBuilder");
		myLarge.concatMeasure(10);
		myLarge.concatMeasure(100);
		myLarge.concatMeasure(1000);
		myLarge.concatMeasure(10000);
		myLarge.concatMeasure(100000);
		
		
		
	}
}
