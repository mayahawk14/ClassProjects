package media;

public class Film extends Media {
	private String director;
	private String country;
	private String rating;
	private String description;
	
	public Film(int id, String type, String title, String director, String country, int release_year, String rating, String description) {
		super(id, type, title, release_year);
		this.director = director;
		this.country = country;
		this.rating = rating;
		this.description = description;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
