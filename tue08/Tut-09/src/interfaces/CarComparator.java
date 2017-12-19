package interfaces;

import java.util.Comparator;

/**
 * This class provides some Comparators for Car objects.
 *
 */
public class CarComparator {
	
	// uses anonymous class
	public static final Comparator<Car> NAME_YEAR = new Comparator<Car>() {

		@Override
		public int compare(Car o1, Car o2) {
			int result = o1.getName().compareTo(o2.getName());
			if (result != 0) {
				return result;
			}
			return Integer.compare(o1.getYear(), o2.getYear());
		}
	};

	// uses anonymous class
	public static final Comparator<Car> NEWEST_FIRST = new Comparator<Car>() {

		@Override
		public int compare(Car o1, Car o2) {
			int result = Integer.compare(o2.getYear(), o1.getYear());
			if (result != 0) {
				return result;
			}
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	// Lambdas , new in Java 8. Only for Interfaces with exactly 1 Method
	// with Code block {} you need a return
	public static final Comparator<Car> NATURAL_ORDER = (Car c1, Car c2) -> {
		return c1.compareTo(c2);
	};
	
	// version with exactly 1 expression -> no code block, no return
	public static final Comparator<Car> REVERSED_NATURAL_ORDER = (c1, c2) -> c2.compareTo(c1);
}
