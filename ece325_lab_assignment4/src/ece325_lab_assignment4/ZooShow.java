package ece325_lab_assignment4;

import java.io.BufferedReader;
import java.io.FileReader;

public class ZooShow {
	
	public static void main(String[] args) {
		
		
		// create the artist
		Artist myArtist = new Artist();
		
		// create the zoo
		// Animals added in the constructor
		Zoo myZoo = new Zoo();
	
		// while there are animals that still need feeding,
		// randomly select an animal from the zoo
		// feed it
		// stop playing when all animals are fed

		
		while(!myZoo.allAnimalsFed()) {
			try {
				myArtist.feed(myZoo.getRandomAnimalToComeToStage());
			}
			catch (NotPlayingException np){
				System.err.println(np.getMessage());
				myArtist.startPlaying();
				//np.printStackTrace();
			}
			catch (AlreadyFedException af){
				System.err.println(af.getMessage());
				//af.printStackTrace();
			}
			
		}
		
		
		// stop playing when all animals are fed
		myArtist.stopPlaying();
		}
	
}
