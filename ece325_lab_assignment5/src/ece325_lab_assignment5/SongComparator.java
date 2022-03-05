package ece325_lab_assignment5;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {
		
		int i1 = Integer.compare(o1.getPopularity(), o2.getPopularity());
		if(i1 != 0) {
			// put - sign to make it high to low
			return -i1;
		}
		
		int i2 = o1.getTitle().compareTo(o2.getTitle());
		if(i2 != 0) {
			return i2;
		}
		return -o1.getReleaseDate().compareTo(o2.getReleaseDate());
	}
	
}
