package Homework1;
/**
 * Thang Bui 
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates an exception class to throw if the playlist is full and cannot add more song
 */
public class FullPlaylistException extends Exception{

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