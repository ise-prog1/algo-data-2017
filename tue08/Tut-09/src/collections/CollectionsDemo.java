package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		// prefer Interface over actual class as type
		List<String> strings = new LinkedList<>();
		strings.add("bla");
		strings.add("test");
		
		// how to convert from Collections Api to Array
		String[] stringArray = strings.toArray(new String[strings.size()]);
		
		// you can use the foreach loop with all the Collection Apis.
		for(String s : strings) {
			System.out.println(s);
		}
	}
}
