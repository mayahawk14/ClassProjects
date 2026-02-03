package media;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException{
		
	ArrayList<String> listOfMedia = new ArrayList<String>();
	ArrayList<Media> All = new ArrayList<Media>();
	Manager m = new Manager();

	m.loadData("project1dataset.csv", listOfMedia, All);
	
	
	
	System.out.println(m.numOfProducts(All) + " total products");
	System.out.println(m.numOfMovies(All) + " total movies");
	System.out.println(m.numOfTVShows(All) + " total shows");
	System.out.println(m.numOfVideogames(All) + " total video games");
	System.out.println(m.numOfMusicAlbums(All) + " total music albums");
	System.out.println(m.oldestProduct(All) + " is the oldest product");
	System.out.println(m.popMusicAlbum(All) + " is the most popular album");
	System.out.println(m.popVideogame(All) + " is the most popular video game");
	System.out.println(m.averageRating(All) + " is the average age rating in film products");
	System.out.println(m.shortestMovie(All) + " is the shortest movie");
	System.out.println(m.shortestMusicAlbum(All) + " is the shortest album");
	
	}

}
