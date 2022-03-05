// Developer: Ronggang Cui
// This program measures the performance for two approaches of string concatenation
// It only has many strings but a few times of operations

package ece325_lab_assignment6;

public class CompareManySmallStringsConcatenation {
	/**
	 * Creates numberOfStrings String objects and performs operationsPerString concatenation
	 * operations on every string. Note that you can create one string first, then perform all
	 * the operations on that string, then create the second string, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatString(int numberOfStrings, int concatOperationsPerString) {

		for(int i=0; i< numberOfStrings; i++) {
			String myStr = "";
			for(int j=0; j< concatOperationsPerString; j++)
				myStr = myStr + "a";
		}
		
	}

	/**
	 * Creates numberOfStrings StringBuilder objects and performs operationsPerString concatenation
	 * operations on every StringBuilder. Note that you can create one StringBuilder first, then 
	 * perform all the operations on that StringBuilder, then convert the StringBuilder to a String, 
	 * then create the second StringBuilder, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatStringBuilder(int numberOfStrings, int concatOperationsPerString) {

		for(int i=0; i< numberOfStrings; i++) {
			StringBuilder strBuilder = new StringBuilder(); 
			for(int j=0; j< concatOperationsPerString; j++) {
				strBuilder.append("a");
			}
		}

	}

	/**
	 * Measure the performance for the String and StringBuilder approaches, print the results
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private void concatMeasure(int numberOfStrings, int concatOperationsPerString) {

		MillisPerformanceMeasurement myMeasurement = new MillisPerformanceMeasurement();

		// measure the performance for the String approach
		myMeasurement.start();
		concatString(numberOfStrings, concatOperationsPerString);
		myMeasurement.end();
		System.out.print(myMeasurement.getResult());
		System.out.print("\t\t");
		myMeasurement.reset();

		// measure the performance for the StringBuilder approach
		myMeasurement.start();
		concatStringBuilder(numberOfStrings, concatOperationsPerString);
		myMeasurement.end();
		System.out.println(myMeasurement.getResult());
		myMeasurement.reset();

	}

	public static void main(String[] args) {
		
		CompareManySmallStringsConcatenation mySmall = new CompareManySmallStringsConcatenation();
		
		// the number of strings to be operated on concatenations
		int[] numberOfStrings = {1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000}; 
		// the number of operations for each string
		int[] numberOfOperations = {0, 1, 2, 3, 4};
		
		// format the output
		System.out.println("Number of Operations" + "\t" + "String" + "\t\t" + "StringBuilder");
		
		// loop through the combinations of the two arrays above
		for(int i=0; i< numberOfStrings.length; i++) {
			System.out.print("number of strings is: ");
			System.out.println(numberOfStrings[i]);
			for(int j=0; j< numberOfOperations.length; j++) {
				System.out.print(j);
				System.out.print("\t\t\t");
				mySmall.concatMeasure(numberOfStrings[i], numberOfOperations[j]);
			}
		}
		
		System.out.println("all done");
		
	}
}