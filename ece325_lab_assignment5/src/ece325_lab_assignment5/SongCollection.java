package ece325_lab_assignment5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.io.*;
import java.util.Scanner;

/**
 * This class represents a Song. A Song has a title, release date, and a popularity score.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class SongCollection {
	// not allowed to change anything after this until the indicated line
	private TreeSet<Song> collection;
	
	public SongCollection() {
		collection = new TreeSet<Song>();
	}
	
	public static LocalDate parseLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(str, formatter);
	}
	
	public void addSong(Song s) {
		collection.add(s);
	}	
	
	public String toString() {
		String str = "[SongCollection: " + collection.size() + " songs: \n";
		for(Song s : collection) {
			str += "\t" + s + "\n";
		}
		return str + "]";
	}
	
	// this function load the songs to the collection in the txt file with a song on each line
	public void loadSongs(String filename) throws FileNotFoundException{
		
		Scanner s = null;
		BufferedReader in; 
		in = new BufferedReader(new FileReader(filename));
		String line;
		
		try {
			while((line = in.readLine())!= null) {
				
				// read the line into the lineArray
				ArrayList<String> lineArray = new ArrayList<>();
				s = new Scanner(line); 
				s.useDelimiter(","); 
				while(s.hasNext())
					lineArray.add(s.next());

				
				// check for garbage
				if (lineArray.size() != 3) {
					System.out.println("There is a grabage line.");
					continue;
				}
				
				// convert and check for garbage
				try {
					String title = lineArray.get(0);
					LocalDate releaseDate = parseLocalDate(lineArray.get(2));
					int popularity = Integer.parseInt(lineArray.get(1));
					
					Song mySong = new Song(title, releaseDate, popularity);
					collection.add(mySong);
				}
				catch(Exception e) {
					System.out.println("There is a grabage line.");
					continue;
				}
			}
		} catch (IOException e) {
			System.err.println("readLine() misfunction");
		}
	}
	
	
	
	public List<Song> sort(Comparator<Song> comp) {
		ArrayList<Song> mySongArray = new ArrayList<Song>(collection);
		Collections.sort(mySongArray, new SongComparator());
		return mySongArray;
	}
	
	
	public static void main(String[] args) {
		
		SongCollection myCollection = new SongCollection();
		
		// deal with the exception of wrong file name
		try {
			myCollection.loadSongs("/Users/alexcui/Desktop/A ECE 325/Labs/Lab5/ece325_lab_assignment5/songs.txt");
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
		
		// print based on the natural sort, title then release date
		System.out.println(myCollection);
		
		// sort myCollection in the order of popularity
		List<Song> mySongArray = myCollection.sort(new SongComparator());
		
		System.out.println(mySongArray);
			
		
	}
}
