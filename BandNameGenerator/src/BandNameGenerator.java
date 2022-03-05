// Student Name: Ronggang Cui
// Student ID: 1617665
// Lab 2


package band.name.generator;

import java.io.BufferedReader;
import java.io.FileReader;

public class BandNameGenerator {
	
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;

	// Take the file names from the constructor
	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;
	}

	// Load the adjective file into the string array
	public void loadAdjectives() {
		
		adjectives = loadTxt(adjectivesFile);
		
		// change the flag if loaded successful
		if (adjectives.length != 0) {
			adjectivesLoaded = true;
		}
	}

	// Load the noun file into the string array
	public void loadNouns() {
		
		nouns = loadTxt(nounsFile);
		
		// change the flag if loaded successful
		if (nouns.length != 0) {
			nounsLoaded = true;
		}
	
	}

	/**
	 * Randomly generates and returns a band name that consists of an adjective followed by a noun.
	 * Returns "UNINITIALIZED" if the adjectives or nouns were not (correctly) loaded. 
	 * @return The generated band name
	 */
	public String generate() {
		
		
		loadAdjectives();
		loadNouns();
		
		// if both files are successfully loaded
		if (adjectivesLoaded && nounsLoaded) {
			
			int selectAdjNum = (int)(Math.random() * adjectives.length);
			int selectNounNum = (int)(Math.random() * nouns.length);
			
			
			return adjectives[selectAdjNum] + " " + nouns[selectNounNum];
			
		}		
		
		// if there is a problem loading the files
		return "UNINITIALIZED";
	}
	
	/**
	 * We have not discussed I/O (reading/writing files) yet, so you can use this
	 * function to load the adjectives and nouns text files.
	 * 
	 * @param file: a String that contains the name of the file you want to read. 
	 * @return
	 */
	private String[] loadTxt(String file) {
		// Initialize the data we will return to a real array so our compiler won't complain.
		// Don't worry - later in the course we will look at better ways to do this. 
		String[] data = new String[0];
		
		// We did not talk about exceptions yet but for now read the following part as follows:
		// If an error occurs during the execution of the code in the try block, the program will 
		// execute the code in the catch block, otherwise it will skip the catch block. 
		try {
			// Create a stream to read from the file
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			// The first line of the file contains an integer that represents the number of rows,
			// the rest of the file contains one word on every line
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			// Read the file and store it in the data that we will return
			while ((line = in.readLine()) != null) {
				data[i] = line;
				i++;

			}
			// Only execute the following block if a problem occurred during reading the file
		} catch (Exception e) {
			// Print some details that should help you solve the problem.
			System.err.println("Problem while reading the data for file: " + file);
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Run the program and randomly generate 20 (no more, no less) band names every time you execute it.
	 * The names may be different across runs. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Relative directory:
		// System.out.println("Working Directory = " + System.getProperty("user.dir"));
		// System.getProperty("user.dir")+"/bin/adjectives.txt"
		
		// In the case of correct directory and file names
		BandNameGenerator bandName = new BandNameGenerator("/Users/alexcui/eclipse-workspace/NameGenerator/bin/adjectives.txt", "/Users/alexcui/eclipse-workspace/NameGenerator/bin/nouns.txt");
		
		// In the case of bad directory or file names
		//BandNameGenerator bandName = new BandNameGenerator("ABC","ABC");
		
		for(int i = 0; i < 20 ; i++) {
		
			System.out.println(bandName.generate());
		
		}
	}

}
