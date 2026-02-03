package media;

public class Movies extends Film{
	
	private double duration;

	public Movies(int id, String type, String title, String director, String country, int release_year, String rating, double duration, String description) {
		super(id, type, title, director, country, release_year, rating, description);
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

}
