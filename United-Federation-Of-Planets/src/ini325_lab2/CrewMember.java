package ini325_lab2;

public class CrewMember {
	
	public String name;
	public String position;
	public String rank;
	public String species;
	public String assignment;
	
	/**
	 * This constructor initializes a crew member, requiring all 5 variable fields given in paramaters
	 * @param name
	 * @param position
	 * @param rank
	 * @param species
	 * @param assignment
	 */

	public CrewMember(String name, String position, String rank, String species, String assignment) {
		super();
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.species = species;
		this.assignment = assignment;
	}

	/**
	 * This constructor intitializes a Crew Member, requiring all fields except for assignment
	 * @param name
	 * @param position
	 * @param rank
	 * @param species
	 */
	public CrewMember(String name, String position, String rank, String species) {
		super();
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.species = species;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	
	@Override
	public String toString() {
		return "- " + name + " (" + position + ") -" + rank + " [" + species
				+ "]\n";
	}

	

}
