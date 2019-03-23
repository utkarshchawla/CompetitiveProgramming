package july_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashMapClient {

	public static void main(String[] args) {

		System.out.println(highestFre("aaccccacbcbbbbcd"));
		int[] one = { 1, 1, 2, 3, 4, 5, 5, 5 };
		int[] two = { 1, 1, 1, 2, 5 };
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		System.out.println(gcc1(one, two));
		System.out.println(gcc2(one, two));
		System.out.println(sublength(arr));
	}

	public static Character highestFre(String word) {
		HashMap<Character, Integer> fre = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if (fre.containsKey(ch)) {
				int v = fre.get(ch);
				v++;
				fre.put(ch, v);
			} else {
				int nv = 1;
				fre.put(ch, nv);
			}
		}
		ArrayList<Character> keys = new ArrayList<>(fre.keySet());

		Character rc = 'a';
		int max = 0;
		for (Character key : keys) {
			if (fre.containsKey(key)) {
				int fv = fre.get(key);
				if (fv > max) {
					max = fv;
					rc = key;
				}
			}
		}
		return rc;
	}

	public static ArrayList<Integer> gcc1(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < one.length; i++) {
			if (map.containsKey(one[i])) {
				map.put(one[i], map.get(one[i]) + 1);
			} else {
				map.put(one[i], 1);
			}
		}

		for (int j = 0; j < two.length; j++) {
			if (map.containsKey(two[j])) {
				list.add(two[j]);
				map.remove(two[j]);
			}
		}

		return list;

	}

	public static ArrayList<Integer> gcc2(int[] one, int[] two) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < one.length; i++) {
			if (map1.containsKey(one[i])) {
				map1.put(one[i], map1.get(one[i]) + 1);
			} else {
				map1.put(one[i], 1);
			}
		}

		for (int i = 0; i < two.length; i++) {
			if (map2.containsKey(two[i])) {
				map2.put(two[i], map2.get(two[i]) + 1);
			} else {
				map2.put(two[i], 1);
			}
		}

		for (int i : map1.keySet()) {
			if (map1.containsKey(i) && map2.containsKey(i)) {
				int count = Math.min(map1.get(i), map2.get(i));
				for (int j = 0; j < count; j++) {
					list.add(i);
				}
			}
		}
		return list;
	}

	public static ArrayList<Integer> sublength(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> fl = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 1);
		}

		for (int j : map.keySet()) {
			if (map.containsKey(j + 1)) {
				if (list.size() == 0) {
					list.add(j);
				}
				list.add(j + 1);

			} else {
				if (list.size() > fl.size()) {
					fl = new ArrayList<>();
					fl = list;
				}
				list = new ArrayList<>();

			}
		}

		if (fl.size() != 0) {
			return fl;
		} else {
			return list;
		}
	}

}
