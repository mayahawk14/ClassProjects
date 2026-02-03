package media;

public class Videogames extends Media{
	
	private String platform;
	private String genre;
	private String publisher;
	private double copies_sold;
	
	public Videogames(int id, String type, String title, String platform, int release_year, String genre, String publisher, double copies_sold) {
		super(id, type, title, release_year);
		this.platform = platform;
		this.genre = genre;
		this.publisher = publisher;
		this.copies_sold = copies_sold;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getCopies_sold() {
		return copies_sold;
	}

	public void setCopies_sold(double copies_sold) {
		this.copies_sold = copies_sold;
	}
	
	

}
