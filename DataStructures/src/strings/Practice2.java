package strings;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Practice2 {

	public static void getPopulationByState(Map<String, String> data) {

		Map<String, Long> populationByState = new HashMap<>();
		for (String value : data.values()) {
			String state = value.split("\\|")[0];
			Long population = Long.valueOf(value.split("\\|")[1]);

			if (populationByState.containsKey(state)) {
				populationByState.put(state, populationByState.get(state) + population);
			} else {
				populationByState.put(state, population);
			}
		}

		System.out.println(populationByState);
	}

	public static void getSortedCleanedData(int array[]) {

		int length = array.length;
		Set<Object> set = new TreeSet<>();
		List<Object> finalOutput = new ArrayList<>();
		for (int element : array) {
			set.add(element);
		}

		for (int i = 0; i < array.length - set.size(); i++) {
			finalOutput.add(0);
		}

		Iterator i = set.iterator();

		while (i.hasNext()) {
			finalOutput.add(i.next());
		}

		System.out.println(finalOutput);
	}

	public static void main(String[] args) {
		int array[] = { -4, 2, -4, 7, 8, 6, 4 };

		Map<String, String> data = new HashMap<>();
		data.put("A", "Goa|7373");
		data.put("V", "Punjab|38383");
		data.put("X", "Goa|99797");
		data.put("V", "Punjab|444663");

		// getSortedCleanedData(array);
		getPopulationByState(data);

	}
}
/*
 * { "District" : "State|population"} { "A" : "Goa|7373","V" :
 * "Punjab:38383","X": "Goa|99797","D":"Punjab|444663" } #Population By State
 * 
 * // Goa:ccccccc , Punjab:xxxxxxx
 */

/*
 * 1. Array of type integer 2. 75 elements start and upwards 3. the data is
 * highly likely unsorted 4. possisbility of dupicates 5. data is clean
 * 
 * 
 * 5. job is to zero out the duplicate and sort the data 6. regards for time and
 * space complexity 7. sort through unconventional ways // [ 4 2 4 7 8 6 4 ] ==>
 * { Code } ==> [ 0 0 2 4 6 7 8 ]
 */
