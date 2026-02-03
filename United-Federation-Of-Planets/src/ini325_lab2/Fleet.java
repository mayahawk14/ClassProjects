package ini325_lab2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fleet {
	
	public String name;
	public ArrayList<Starship> starshipList = new ArrayList<Starship>();
	
	/**
	 * This constructor initializes a starship fleet given the name and arraylist of starships
	 * @param name
	 * @param starshipList
	 */
	public Fleet(String name, ArrayList<Starship> starshipList) {
		super();
		this.name = name;
		this.starshipList = starshipList;
	}
	
	/**
	 * This constructor initializes a starship fleet given only the name of the fleet
	 * @param name
	 */
	public Fleet(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * This method returns an integer of the size of the starship fleet
	 * @return int
	 */
	public int getSizeOfFleet() {
		return starshipList.size();
	}
	
	/**
	 * This method adds a given starship to the fleet 
	 * @param ship
	 */
	public void addStarship(Starship ship) {
		starshipList.add(ship);
	}
	/**
	 * This method loads the starships from a given folder path to be read and processed by the starship and crew member constructors
	 * @param folderPath
	 */
	public void loadStarships(String folderPath) {
		File folder = new File(folderPath);
		File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                	try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                		String descrip = reader.readLine();
                        String[] values = descrip.split(",");
                        String shipName = values[0];
                        String registry = values[2];
                        String starClass = values[1];
                        ArrayList<CrewMember> crew = new ArrayList<CrewMember>();
                        String line;
                        while ((line = reader.readLine()) != null) {
                        	String[] attri = line.split(",");
                        	CrewMember j = new CrewMember(attri[0], attri[1], attri[2], attri[3]);
                        	crew.add(j);
                    }
                        Starship h = new Starship(shipName, registry, starClass, crew);
                        starshipList.add(h);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
	    
	}
	
	// GETTERS & SETTERS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Starship> getStarshipList() {
		return starshipList;
	}

	public void setStarshipList(ArrayList<Starship> starshipList) {
		this.starshipList = starshipList;
	}

	/**
	 * This toString method formats the fleet information accordingly
	 */
	
	@Override
	public String toString() {
		System.out.println("---------------------------- \n\n" + name + "\n\n---------------------------- \n");
		for (Starship ship : starshipList) {
			System.out.print(ship);
		}
		return "";
	}
	
	
	

}
