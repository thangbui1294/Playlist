package Homework1;
import java.util.*;
/**
 * Thang Bui  
 * 108848430
 * Homework #1
 * thang.bui@stonybrook.edu 
 * CSE 214 Recitation R03
 * Phil Ammirato
 * @author thangbui 
 * Creates class PlaylistOperations to test the methods of Playlist class 
 */

public class PlaylistOperations implements Cloneable{
	/**
	 * Operation Method 
	 * @param args
	 */
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Playlist pl1 = new Playlist();
		//System.out.println("Enter the name for playlist: ");
		//pl1.setName(s.nextLine());
		Playlist curr = pl1;
		int count = 0;
		while (count == 0) {
			System.out.print("MENU OPTION: \nA) Add Song  \nB) Print Songs by Artist \nG) Get Song \nR) Remove Song  \nP) Print All Songs  \nS) Size  \nQ) Quit   \nSelect a menu option: ");
			char menu = (s.nextLine()).toCharArray()[0] ;
			switch (menu) {
			case 'a':
			case 'A': {
				try{
					SongRecord song = new SongRecord();
					System.out.print("Enter the song title: ");
					song.setTitle(s.nextLine());
					System.out.print("Enter the song artist: ");
					song.setArtist(s.nextLine());
					System.out.print("Enter the song length (min): ");
					song.setMin(s.nextInt());
					System.out.print("Enter the song length (sec): ");
					song.setSec(s.nextInt());
					System.out.print("Enter the position: ");
					curr.addSong(song, s.nextInt());
					System.out.println("Song added: "+ song.getTitle() + " by " + song.getArtist());
					System.out.println("# of song in the current Playlist " + curr.getSize());
				}
				catch (SecondInputException ex){
					System.out.println("Wrong input for second");
				}
				catch (MinuteInputException ex){
					System.out.println("Wrong input for min");
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position is not in valid range! ");
				}
				catch (FullPlaylistException ex){
					System.out.println("The playlist is full. Remove to add another one ");
				}
				catch (InputMismatchException ex){
					System.out.println("Wrong input type");
				}
				break;
			}
			case 'r':
			case 'R': {
				try {
					System.out.print("Enter the song's position you want to remove: ");
					curr.removeSong(s.nextInt());
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position is not in valid range! ");
				}
				break;
			}
			case 's':
			case 'S': {
				System.out.println("Number of songs currently in the playlist: "+curr.getSize());
				break;
			}
			case 'q':
			case 'Q': {
				System.out.println("You have quitted!");
				count++;
				break;
			}
			case 'p':
			case 'P': {
				curr.printAllSongs();
				break;
			}
			case 'b':
			case 'B':{
				System.out.print("Enter name of artist: ");
				Playlist pl2 = new Playlist();
				pl2 = Playlist.getSongsByArtist(curr, s.nextLine());
				pl2.printAllSongs();
				break;
			}
			case 'g':
			case 'G':{
				try{
					System.out.print("Enter the postion of the song: ");
					System.out.println(curr.getSong(s.nextInt()));
				}
				catch (IllegalArgumentException ex){
					System.out.println("The position is not in valid range! ");
				}
				break;
			}
			default: System.out.println("Invalid menu option! Try again");
			}
		}

	}

}
