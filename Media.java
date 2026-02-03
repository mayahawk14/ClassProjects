package media;

public class Media {
	
	private int id;
	private String type;
	private String title;
	private int release_year;
	
	
	public Media(int id, String type, String title, int release_year) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.release_year = release_year;

	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getRelease_year() {
		return release_year;
	}


	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

}
