package Homework1;
/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 */
public class Playlist {
	private SongRecord[] songs;
	private int size;
	private final int MAX_LENGTH_OF_THE_LIST = 50;

	/** 
	 * Creates a new Playlist object with maximum capacity is 50 songs 
	 */
	public Playlist(){
		songs = new SongRecord[MAX_LENGTH_OF_THE_LIST];
	}
	//public Object clone(){

	//}

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
	 * Adds another song to a particular Playlist at specific position   
	 * @param song
	 * the SongRecord object to be added to current Playlist 
	 * @param position
	 * the position from the Playlist to add the SongRecord object to 
	 * @throws IllegalArugmentException 
	 * if the position is not in valid range 
	 * @throws FullPlayListException 
	 * if the Playlist is full with 50 SongRecord songs 
	 */
	public void addSong(SongRecord song, int position) throws FullPlaylistException, IllegalArgumentException{
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
	public SongRecord getSong(int position) throws IllegalArgumentException{
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
	 * @throws FullPlaylistException 
	 * if the Playlist is full with 50 SongRecord songs 
	 * @throws IllegalArgumentException
	 * if the position is not in valid range  
	 */
	public static Playlist getSongsByArtist(Playlist originalList, String artist) throws IllegalArgumentException, FullPlaylistException{
		if ((originalList == null) || (artist == null))
			return null;
		Playlist pl = new Playlist();
		for (int i = 1; i <= originalList.getSize(); i++){
			if (((originalList.getSong(i)).getArtist()).equals(artist)){
				pl.addSong(originalList.getSong(i), pl.getSize() + 1);
			}
		}
		return pl;

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

	class IllegalArgumentException extends Exception{
		/**
		 * Creates new default IllegalArgumentException exception
		 */
		public IllegalArgumentException(){
			super("Invalid range of the position");
		}

		/**
		 * Creates new IllegalArgumentException exception with a String parameter
		 * @param message
		 * the String for a new exception 
		 */
		public IllegalArgumentException(String message){
			super(message);
		}
	}

	class FullPlaylistException extends Exception{

		/**
		 * Creates new default FullPlaylistException exception
		 */
		public FullPlaylistException(){
			super("The Playlist is full");
		}

		/**
		 * Creates new FullPlaylistException exception with a String parameter
		 * @param message
		 * the String for a new exception 
		 */
		public FullPlaylistException(String message){
			super(message);
		}
	}
}