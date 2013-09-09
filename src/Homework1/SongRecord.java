package Homework1;
/**
 * Thang Bui  
 * 108848430
 * Homework #1
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 */
public class SongRecord {
	private String title;
	private String artist;
	private int min;
	private int sec;
	
	/**
	 * Creates a new default SongRecord 
	 */
	public SongRecord(){
	}
	
	//public Object clone(){
	//	SongRecord cloned = new SongRecord();
	//}
	
	/**
	 * Receives the title of a particular SongRecord
	 * @return
	 * the title of a SongRecord as a String
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Sets title for a particular SongRecord 
	 * @param title
	 * new title for the SongRecord  
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * Receives the artist's name of a particular SongRecord 
	 * @return
	 * the artist's name of SongRecord as a String  
	 */
	public String getArtist(){
		return artist;
	}
	
	/**
	 * Sets artist's name for a particular SongRecord 
	 * @param artist
	 * the artist's name of the SongRecord 
	 */
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	/**
	 * Receives the length in second of a particular SongRecord 
	 * @return
	 * the length in second of the SongRecord as an int 
	 */
	public int getSec(){
		return sec;
	}
	
	/**
	 * Sets the length of a particular SongRecord in second 
	 * @param sec
	 * the length of the SongRecord in second 
	 */
	public void setSec(int sec) throws SecondInputException{
		if ((sec < 0) || (sec > 59))
			throw new SecondInputException("Invalid second");
		else
			this.sec = sec;
	}
	
	/**
	 * Receives the length of a particular SongRecord in minute 
	 * @return
	 * the length of the SongRecord in minute 
	 */
	public int getMin(){
		return min;
	}
	
	/**
	 * Sets the length of a particular SongRecord in minute 
	 * @param min
	 * the length of the SongRecord in minute 
	 */
	public void setMin(int min) throws MinuteInputException{
		if (min < 0)
			throw new MinuteInputException("Invalid minute");
		this.min = min;
	}
	
	/**
	 * Compares a particular object with a SongRecord object; check for logical equivalence 
	 * @param obj
	 * the object to be compared with the current SongRecord 
	 * @return
	 * true if logically equivalent, false otherwise 
	 */
	public boolean equals(Object obj){
		if (!(obj instanceof SongRecord)){
			return false;
		}
		if (!(title.equals(((SongRecord)(obj)).getTitle())))
			return false;
		if (!(artist.equals(((SongRecord)(obj)).getArtist())))
			return false;
		if (min != ((SongRecord)(obj)).getMin())
			return false;
		if (sec != ((SongRecord)(obj)).getSec())
			return false;
		return true;
	}
	
	/**
	 * Copies all data from a particular SongRecord into a new SongRecord Reference
	 * Changing the original will not change the copy, and vice versa
	 * @return
	 * a copy of a SongRecord as an Object
	 */
	public Object clone(){
		SongRecord cloned = new SongRecord();
		if (this.title == null){
			cloned.title = null;
		}
		else {
			cloned.title = this.getArtist();
		}
		if (this.artist == null){
			cloned.artist = null;
		}
		else {
			cloned.artist = this.getArtist();
		}
		cloned.min = this.getMin();
		cloned.sec = this.getSec();
		return cloned;
	}
	
	
	public String toString(){
		return "Song: " + this.getTitle() + " Artist: " + this.getArtist() + " Length: " + this.getMin() + ":" + this.getSec();
	}
	
}



