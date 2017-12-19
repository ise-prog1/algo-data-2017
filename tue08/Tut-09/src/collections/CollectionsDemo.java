package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> strings = new LinkedList<>();
		strings.add("bla");
		strings.add("test");
		strings.toArray(new String[strings.size()]);
		for(String s : strings) {
			System.out.println(s);
		}
	}
}
