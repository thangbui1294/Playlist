package Homework1;
/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates Playlist class to store all SongRecord objects that belong to a particular Playlist
 */


 
public class Playlist {
	private SongRecord[] songs;
	private int size;
	private final int MAX_LENGTH_OF_THE_LIST = 50;
	private String name;

	/** 
	 * Creates a new Playlist object with maximum capacity is 50 songs 
	 */
	public Playlist(){
		songs = new SongRecord[MAX_LENGTH_OF_THE_LIST];
	}

	/**
	 * Compares a particular object with a Playlist object; check for logical equivalence 
	 * @param obj
	 * the object to be compared with the current Playlist 
	 * @return 
	 * true if logically equivalent, false otherwise 
	 */
	public boolean equals(Object obj){
		if ((obj == null) || (!(obj instanceof Playlist)))
			return false;
		if (size != ((Playlist)obj).getSize()) 
			return false;
		for (int i = 0; i < size; i++){
			if (!(songs[i].equals(obj)))
				return false;
		}
		return true;
	}

	/**
	 * Receives the number of songs currently in a particular Playlist 
	 * @return
	 * the number of songs as an int  
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Receives the name of the Playlist
	 * @return
	 * the name will be returned as a String
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name for a particular Playlist
	 * @param name
	 * new name for the Playlist 
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Adds another song to a particular Playlist at specific position   
	 * @param song
	 * the SongRecord object to be added to current Playlist 
	 * @param position
	 * the position from the Playlist to add the SongRecord object to 
	 * @throws IllegalArgumentException 
	 * @throws FullPlaylistException 
	 * @throws IllegalArugmentException 
	 * if the position is not in valid range 
	 * @throws FullPlayListException 
	 * if the Playlist is full with 50 SongRecord songs 
	 */
	public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException {
		if (!((1 <= position) && (position <= this.size + 1)))
			throw new IllegalArgumentException("Invalid range");
		if (this.size == MAX_LENGTH_OF_THE_LIST) 
			throw new FullPlaylistException("Playlist is full");
		System.arraycopy(songs, position-1, songs, position, size-position+1);
		songs[position-1] = song;
		size++;
	}

	/**
	 * Removes a song from a particular Playlist 
	 * @param position 
	 * the position of the song to be deleted from the Playlist 
	 * @throws IllegalArugmentException
	 * if the position is not in valid range 
	 */
	public void removeSong(int position) throws IllegalArgumentException{
		if (!((1 <= position) && (position <= size)))
			throw new IllegalArgumentException("Invalid range");
		System.arraycopy(songs, position, songs, position - 1, size-position);
		songs[size] = null;
		size--;
	}

	/**
	 * Receives the song at a specific position  
	 * @param position
	 * position of the song will be returned 
	 * @return
	 * the song as a SongRecord 
	 * @throws IllegalArgumentException 
	 * if the position is not in valid range 
	 */
	public SongRecord getSong(int position) throws IllegalArgumentException {
		if (!((1 <= position) && (position <= size)))
			throw new IllegalArgumentException("Invalid range");
		return songs[position-1];
	}
	public void printAllSongs(){
		System.out.println(this.toString());
	}

	/**
	 * Receives songs having same artist from a particular Playlist  
	 * @param originalList
	 * the Playlist that the songs will be returned 
	 * @param artist
	 * the name of the artist of the songs 
	 * @return
	 * the new playlist with all the songs from the artist as a Playlist 
	 */
	public static Playlist getSongsByArtist(Playlist originalList, String artist)  {
		Playlist pl = new Playlist();
		try{
			if ((originalList == null) || (artist == null))
				return null;
			for (int i = 1; i <= originalList.getSize(); i++){
				if (((originalList.getSong(i)).getArtist()).equals(artist)){
					pl.addSong(originalList.getSong(i), pl.getSize() + 1);
				}
			}

		}
		catch (IllegalArgumentException ex){
			System.out.println("The position is not in valid range! ");
		}
		catch (FullPlaylistException ex){
			System.out.println("The playlist is full. Remove to add another one ");
		}
		return pl;

	}
	
	/**
	 * Copies all data from a particular Playlist into a new Playlist Reference
	 * Changing the original will not change the copy, and vice versa
	 * @return
	 * a copy of a Playlis as an Object
	 */
	public Object clone(){
		Playlist cloned = new Playlist();
		if (this.songs == null){
			cloned.songs = null;
		}
		else {
			for (int i = 1; i <= this.getSize();i++){
				try {
					SongRecord song = new SongRecord();
					song = (SongRecord)((this.getSong(i)).clone());
					cloned.addSong(song, i);
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position is not in valid range! ");
				}
				catch (FullPlaylistException ex){
					System.out.println("The playlist is full. Remove to add another one ");
				}

			}
		}
		cloned.size = this.size;
		return cloned;

	}
	/**
	 * Overrides toString method to print the Playlist as a table of songs  
	 * @return
	 * the contents of all songs in the playlist as a String 
	 */
	public String toString(){
		String s = String.format("%-10s%-30s%-30s%-10s\n","Song#","Title","Artist","Length");
		for (int i = 0; i < this.getSize(); i++){
			s = s + String.format("\n%-10d%-30s%-30s%-2d:%02d", i+1, songs[i].getTitle(),songs[i].getArtist(),songs[i].getMin(), songs[i].getSec());
		}
		return s;
	}	
}
