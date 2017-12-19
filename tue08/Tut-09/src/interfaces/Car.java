package interfaces;

/**
 * A simple Car
 * 
 * The natural order is defined by age and for cars with the same age by the alphabetical order.
 *
 */
public class Car implements Comparable<Car> {

	private String name;
	private int year;
	
	public Car(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	@Override
	public int compareTo(Car o) {
		if (this.year < o.year) {
			return -1;
		} else if (this.year > o.year) {
			return 1;
		}
		// now: this.year == o.year 
		
		return this.name.compareTo(o.name);

	}

	// Getter
	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return name + " (" + year + ")";
	}
	
	
}
