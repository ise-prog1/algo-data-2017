package interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarDemo {

	public static void main(String[] args) {
		// Create some cars
		Car bmwOld = new Car("BMW", 1998);
		Car bmwNew = new Car("BMW", 2017);
		Car audiNew = new Car("Audi", 2017);
		Car tesla = new Car("Tesla", 2017);
		
		// convert to List
		List<Car> cars = Arrays.asList(tesla, audiNew, bmwOld, bmwNew);
		
		System.out.println("Original order:");
		System.out.println(cars);
		
		Collections.sort(cars);
		System.out.println("Natural order (sorted by Comparable):");
		System.out.println(cars);
		
		Collections.sort(cars, CarComparator.NAME_YEAR);
		System.out.println("Name and then year:");
		System.out.println(cars);
		
		Collections.sort(cars, CarComparator.NEWEST_FIRST);
		System.out.println("Newest first:");
		System.out.println(cars);
	}
}
