package Homework1;

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