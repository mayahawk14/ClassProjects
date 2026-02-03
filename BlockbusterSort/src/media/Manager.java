package media;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager {
		
	public void loadData(String fileName, ArrayList listOfMedia, ArrayList All) throws FileNotFoundException{
		File f = new File(fileName);
		Scanner scnr = new Scanner(f);
	
	
		while(scnr.hasNextLine()) {
			String str = scnr.nextLine();
			listOfMedia.add(str);
			String[] arr = str.split(",");
			
		}
		for (int i = 0; i < (listOfMedia.size()-3); i++) {
			String[] arr = ((String) listOfMedia.get(i)).split(","); 
			
			if (arr[1].contains("Movie")) {
				Movies e1 = new Movies(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), arr[6], Double.parseDouble(arr[7]), arr[8]);
				All.add(e1);
			}
			
			else if (arr[1].contains("Video Game")) {
				Videogames v1 = new Videogames(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]));
				All.add(v1);
			}
			
			else if (arr[1].contains("Music Album")) {
				MusicAlbums m1 = new MusicAlbums(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], arr[4], Integer.parseInt(arr[5]), Integer.parseInt(arr[6]), Double.parseDouble(arr[7]), arr[8]);
				All.add(m1);
			}

			else if (arr[1].contains("TV Show")) {
				TVShows s1 = new TVShows(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), arr[6], arr[7], arr[8]);
				All.add(s1);
			}
			
			else {
				System.out.println("Failed to load media.");
			}
		
		}
	}

		/*
		System.out.println(numOfProducts(All));
		System.out.println(numOfMovies(All));
		System.out.println(numOfTVShows(All));
		System.out.println(numOfVideogames(All));
		System.out.println(numOfMusicAlbums(All));
		System.out.println(All.get(0).getRelease_year());
		System.out.println(All.get(0).getTitle());
		System.out.println(oldestProduct(All));
		System.out.println(popMusicAlbum(All));
		*/
		//System.out.println(popVideogame(All));
		//System.out.println(shortestMovie(All));
		//System.out.println(shortestMusicAlbum(All));
		
	
	public void printMedia(Media e) {
		System.out.println(e.getId() + " - " + e.getType() + ": "+ e.getTitle());
	}
	
	public int numOfProducts(ArrayList All) {
		return All.size();
	}
	
	public int numOfMovies(ArrayList All) {
		int count = 0;
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof Movies) {
				++count;
			}
			else;
        }
		return count;
	}
	public int numOfTVShows(ArrayList All) {
		int count = 0;
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof TVShows) {
				++count;
			}
			else;
        }
		return count;
	}
	public int numOfMusicAlbums(ArrayList All) {
		int count = 0;
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof MusicAlbums) {
				++count;
			}
			else;
        }
		return count;
	}
	
	public int numOfVideogames(ArrayList All) {
		int count = 0;
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof Videogames) {
				++count;
			}
			else;
        }
		return count;
	}
	
	public int oldestProduct(ArrayList All) {
		int max = ((Media) All.get(0)).getRelease_year();
		
		for (int i = 0; i < All.size(); i++) {
			if (((Media) All.get(i)).getRelease_year() < max) {
				max = ((Media) All.get(i)).getRelease_year();
			}
			else;
		}
		return max;
	}
	
	public String popMusicAlbum(ArrayList All) {
		int max = 0;
		String pop = "";
		for (int i = 0; i < All.size(); i++) {
			if(All.get(i) instanceof MusicAlbums) {
				max = ((MusicAlbums) All.get(i)).getGlobal_sales();
			}
			else;
			
		}
		
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof MusicAlbums) {
				if (((MusicAlbums) All.get(i)).getGlobal_sales() > max) {
					max = ((MusicAlbums) All.get(i)).getGlobal_sales();
					pop = ((MusicAlbums) All.get(i)).getTitle();
				}
				else;
			}
			else;
		}
		return pop;
	}
	
	public String popVideogame(ArrayList All) {
		double max = 0;
		String pop = "";
		for (int i = 0; i < All.size(); i++) {
			if(All.get(i) instanceof Videogames) {
				max = ((Videogames) All.get(i)).getCopies_sold();
			}
			else;
			
		}
		
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof Videogames) {
				if (((Videogames) All.get(i)).getCopies_sold() > max) {
					max = ((Videogames) All.get(i)).getCopies_sold();
					pop = ((Videogames) All.get(i)).getTitle();
				}
				else;
			}
			else;
		}
		return pop;
	}
	
	public String averageRating(ArrayList All) {
		String avg = "";
		int total13 = 0;
		int totalMA = 0;
		int total14 = 0;
		int totalPG = 0;
		int totalY7 = 0;
		int[] totals = {total13, totalMA, total14, totalPG, totalY7};
		
		for (int i = 0; i < All.size(); i++) {
			if(All.get(i) instanceof Movies || All.get(i) instanceof TVShows) {
				if (((Film) All.get(i)).getRating().equals("PG-13")) {
					total13++;
				}
				else if (((Film) All.get(i)).getRating().equals("TV-MA")) {
					totalMA++;
				}
				else if (((Film) All.get(i)).getRating().equals("TV-14")) {
					total14++;
				}
				else if (((Film) All.get(i)).getRating().equals("TV-PG")) {
					totalPG++;
				}
				else if (((Film) All.get(i)).getRating().equals("TV-Y7")) {
					totalY7++;
				}
				else;
			}
			else;	
		}
		int most = total13;
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] > most) {
				most = totals[i];
			}
			else;
		}
		if (most == total13) {
			return "PG-13";
		}
		else if (most == totalMA) {
			return "TV-MA";
		}
		else if (most == total14) {
			return "TV-14";
		}
		else if (most == totalPG) {
			return "TV-PG";
		}
		else if (most == totalY7) {
			return "TV-Y7";
		}
		else {
			return "Error";
		}
		
	}
	
	public String shortestMovie(ArrayList All) {
		double max = 0;
		String pop = "";
		for (int i = 0; i < All.size(); i++) {
			if(All.get(i) instanceof Movies) {
				max = ((Movies) All.get(i)).getDuration();
			}
			else;
			
		}
		
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof Movies) {
				if (((Movies) All.get(i)).getDuration() < max) {
					max = ((Movies) All.get(i)).getDuration();
					pop = ((Movies) All.get(i)).getTitle();
				}
				else;
			}
			else;
		}
		return pop;
	}
	
	public String shortestMusicAlbum(ArrayList All) {
		double max = 0;
		String pop = "";
		String artist = "";
		for (int i = 0; i < All.size(); i++) {
			if(All.get(i) instanceof MusicAlbums) {
				max = ((MusicAlbums) All.get(i)).getDuration();
			}
			else;
			
		}
		
		for (int i = 0; i < All.size(); i++) {
			if (All.get(i) instanceof MusicAlbums) {
				if (((MusicAlbums) All.get(i)).getDuration() <= max) {
					max = ((MusicAlbums) All.get(i)).getDuration();
					pop = ((MusicAlbums) All.get(i)).getTitle();
					artist = ((MusicAlbums) All.get(i)).getArtist();
				}
				else;
			}
			else;
		}
		return pop + " by " + artist;
	}
	
	

	/*
*Count the total number of products
● Count the total number of Movies
● Count the total number of TV Shows
● Count the total number of Video Games
● Count the total number of Music Albums
● Find the oldest product (by release_year)
● Find the most popular Music Album (i.e., the one that had the highest sales)
● Find the most popular Video Game (i.e., the one that sold the most copies)
● Find the most common age rating among all film products (i.e., Movies and TV Shows)
● Find the shortest Movie
● Find the shortest Music Album
*/
		
}

