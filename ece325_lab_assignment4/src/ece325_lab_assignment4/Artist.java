package ece325_lab_assignment4;

/**
 * The artist/band that is performing. You must finish this class.
 * @author corpaul
 *
 */
public class Artist implements ZooPerformer {
	/** 
	 * Indicates whether the artist is currently playing (= performing). 
	 */
	private boolean isPlaying;
	
	public Artist() {
		isPlaying = false;
	}
	
	/** 
	 * Feed the animal. Make sure to check whether we are allowed to feed this animal,
	 * and make sure to handle things correctly if we are not allowed to feed it. You are allowed
	 * to change this method's signature, if necessary.
	 * @throws AlreadyFedException 
	 * @throws NotPlayingException 
	 * 
	 */
	public void feed(ZooAnimal animal) throws AlreadyFedException, NotPlayingException {
		
			// check for music
			if(!isPlaying) {
				NotPlayingException np = new NotPlayingException();
				throw np;
			}	
			// check if already fed
			if(animal.isFedAlready()) {
				AlreadyFedException af = new AlreadyFedException(animal.getName());
				throw af;	
			}
			
			// allowed to feed if no exception
			animal.feed();

	}
	
	
	
	

	/**
	 * Sometimes, artists get distracted, so there is a 50% chance that they start
	 * playing when you call this method. 
	 * 
	 */
	public void startPlaying() {
		
		// if we are already playing, don't risk getting distracted again
		if(!this.isPlaying) {
			if (Math.random() > 0.5) {
				this.isPlaying = true;
				System.out.println("Playing starts");
			}
		}
	}
	
	public void stopPlaying() {		
		this.isPlaying = false;
		System.out.println("Playing stops");
	}
	
}
