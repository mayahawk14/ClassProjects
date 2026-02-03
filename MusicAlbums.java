package media;

public class MusicAlbums extends Media{
	private String artist;
	private int global_sales;
	private int tracks;
	private double duration;
	private String genre;
	
	public MusicAlbums(int id, String type, int release_year, String artist, String title, int global_sales, int tracks, double duration, String genre) {
		super(id, type, title, release_year);
		this.artist = artist;
		this.global_sales = global_sales;
		this.tracks = tracks;
		this.duration = duration;
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getGlobal_sales() {
		return global_sales;
	}

	public void setGlobal_sales(int global_sales) {
		this.global_sales = global_sales;
	}

	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}
