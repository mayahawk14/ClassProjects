package ini325_lab2;

import java.util.ArrayList;

public class Starship {
	
	public String name;
	public String registry;
	public String starClass;
	public ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
	
	/**
	 * This constructor initializes a Starship, requiring all 4 fields in parameters
	 * @param name
	 * @param registry
	 * @param starClass
	 * @param crewList
	 */
	
	public Starship(String name, String registry, String starClass, ArrayList<CrewMember> crewList) {
		super();
		this.name = name;
		this.registry = registry;
		this.starClass = starClass;
		this.crewList = crewList;
	}
	
	/**
	 * This method adds a given crew member to the crew list
	 * @param member
	 */
	public void addCrewMember(CrewMember member) {
		crewList.add(member);
	}
	
	/**
	 * This method returns the number of people in the crew list
	 * @return int
	 */
	public int getNumberOfPersonnel() {
		return crewList.size();
	}
	
	// GETTERS & SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getStarClass() {
		return starClass;
	}

	public void setStarClass(String starClass) {
		this.starClass = starClass;
	}

	public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}

	public void setCrewList(ArrayList<CrewMember> crewList) {
		this.crewList = crewList;
	}

	/**
	 * * This toString method formats the output of the Starship information
	 *
	 */
	@Override
	public String toString() {
		if (crewList.size() == 0) {
			System.out.println(name + ", " + registry + ". Registry: " + starClass + "\n\n" + getNumberOfPersonnel() + " crew members assigned.\n");
		}
		else {
			System.out.println(name + ", " + registry + ". Registry: " + starClass + "\n\n" + getNumberOfPersonnel() + " crew members assigned.\n");
			for (CrewMember crew : crewList) {
				System.out.println(crew);
			}
		}
		return "";
	}
	
	
	

}
