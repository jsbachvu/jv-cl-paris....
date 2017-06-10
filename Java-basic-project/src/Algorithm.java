import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Algorithm.Node;

public class Algorithm {

	public static void main(String[] str) {
		String value = "calculatrice";
		char[] charValue = value.toCharArray();
		HashMap<String, Integer> map = new HashMap<>();

		ArrayList<Node> nodes = new ArrayList<Node>();
		/*
		 * for (int i = 0; i < charValue.length; i++) { char c = charValue[i];
		 * 
		 * // do something with c }
		 */
		for (char c : charValue) {
			if (map.containsKey(c + "")) {
				int count = map.get(c + "");
				map.put(c + "", count + 1);
			} else {
				map.put(c + "", 1);
			}
		}

		Map<String, Integer> sortedMap = sortByValue(map);
		printMap(sortedMap);

		for (Entry<String, Integer> entry : sortedMap.entrySet()) {
			Node n = new Node(entry.getKey(), entry.getValue());
			nodes.add(n);
		}

		System.out.println(nodes.toString());
		while (nodes.size() > 1) {
			Node left = nodes.get(0);
			Node right = nodes.get(1);
			int count = left.getCount() + right.getCount();
			Node parent = new Node("", count, left, right);
			nodes.remove(0);
			nodes.remove(0);
			for (int i = 0; i < nodes.size() - 1; i++) {
				if (nodes.get(i).getCount() > parent.getCount()) {
					nodes.add(0, parent);
					break;
				}

				if (nodes.get(i).getCount() <= parent.getCount() && nodes.get(i + 1).getCount() >= parent.getCount()) {
					nodes.add(i + 1, parent);
					break;
				}
			}

			System.out.println(nodes.toString());
		}
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		 * //classic iterator example for (Iterator<Map.Entry<String, Integer>>
		 * it = list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer>
		 * entry = it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
		 */

		return sortedMap;
	}

	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}
