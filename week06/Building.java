package streams;

public class Building implements Comparable<Building> {
	private String name;
	private int height;  // in metre

	public Building(String name, int height) {
		setName(name);
		setHeight(height);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		if (height < 0)
			height = -height;
		this.height = height;
	}
	
	public String toString() {
		return "Building named " + getName() + " with height " +
			getHeight() + " m";
	}
	
	public int compareTo(Building rhs) {
		return Integer.compare(this.getHeight(), rhs.getHeight());
		
		// only if attribute is of type integer
		// return this.getHeight() - rhs.getHeight();
		
		/*
		if (this.getHeight() > rhs.getHeight())
			return 1;
		else if (this.getHeight() < rhs.getHeight())
			return -1;
		else
			return 0;
		*/
	}
}
