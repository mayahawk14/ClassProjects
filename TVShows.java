package media;

public class TVShows extends Film{
	
	private String number_of_seasons;
	
	public TVShows(int id, String type, String title, String director, String country, int release_year, String rating, String number_of_seasons, String description) {
		super(id, type, title, director, country, release_year, rating, description);
		this.number_of_seasons = number_of_seasons;
	}

	public String getNumber_of_seasons() {
		return number_of_seasons;
	}

	public void setNumber_of_seasons(String number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
	}
	
	

}
