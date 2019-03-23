package july_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GHCLient {

	public static void main(String[] args) {

		// GenericHeap<Student> GP = new
		// GenericHeap<Student>(Student.NameCompatator);
		//
		// Student[] students = new Student[5];
		// students[1] = new Student("Modi", 100, 1);
		// students[2] = new Student("Kejri", 10, 75);
		// students[3] = new Student("Rahul", 0, Integer.MAX_VALUE);
		// students[4] = new Student("ABC", 50, 50);
		// students[0] = new Student("DEF", 40, 60);
		//
		// GP.add(students[0]);
		// GP.add(students[1]);
		// GP.add(students[2]);
		// GP.add(students[3]);
		// GP.add(students[4]);
		//
		// while (GP.size() != 0) {
		// System.out.println(GP.removeHP());
		// }

		// ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		// ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, 15, 20,
		// 25));
		// ArrayList<Integer> b = new ArrayList<>(Arrays.asList(8, 9, 14, 28));
		// ArrayList<Integer> c = new ArrayList<>(Arrays.asList(7, 11, 26, 30));
		// ArrayList<Integer> d = new ArrayList<>(Arrays.asList(19, 21, 23,
		// 27));
		// lists.add(a);
		// lists.add(b);
		// lists.add(c);
		// lists.add(d);
		//
		// System.out.println(mergeKSortedArrayLists(lists));
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 66, 55, 44));

		System.out.println(klargestElements(list, 3));

	}

	public static ArrayList<Integer> mergeKSortedArrayLists1(ArrayList<ArrayList<Integer>> lists) {
		if (lists.size() == 1) {
			return lists.get(0);
		}
		ArrayList<Integer> list1 = lists.get(lists.size() - 1);
		ArrayList<Integer> list2 = lists.get(lists.size() - 2);

		ArrayList<Integer> nl = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) > list2.get(j)) {
				nl.add(list2.get(j));
				j++;
			} else {
				nl.add(list1.get(i));
				i++;
			}
		}

		while (i < list1.size()) {
			nl.add(list1.get(i));
			i++;
		}

		while (j < list2.size()) {
			nl.add(list2.get(j));
			j++;
		}

		lists.remove(lists.size() - 1);
		lists.remove(lists.size() - 1);
		lists.add(nl);

		return mergeKSortedArrayLists1(lists);
		// GenericHeap<Student> GP = new
		// GenericHeap<Student>(Student.NameCompatator);

	}

	public static ArrayList<Integer> mergeKSortedArrayLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
		GenericHeap<Pair> nh = new GenericHeap<>(Pair.DataComparator);

		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.data = lists.get(i).get(0);
			p.lno = i;
			p.ino = 0;
			nh.add(p);
		}

		while (nh.size() != 0) {
			Pair temp = nh.removeHP();
			rv.add(temp.data);
			temp.ino++;

			if (temp.ino < lists.get(temp.lno).size()) {

				temp.data = lists.get(temp.lno).get(temp.ino);
				nh.add(temp);
			}

		}
		return rv;
	}

	public static class Pair {
		int data;
		int lno;
		int ino;
		private static final PairComparator DataComparator = new PairComparator();

		private static class PairComparator implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.data - o1.data;
			}

		}
	}

	public static ArrayList<Integer> klargestElements(ArrayList<Integer> list, int k) {
		ArrayList<Integer> rv = new ArrayList<>();
		final helper h = new helper();
		GenericHeap<Integer> gh = new GenericHeap<>(h);

		int tr = 0;
		for (int i = 0; i < k; i++) {
			gh.add(list.get(i));
			tr++;
		}

		while (tr < list.size()) {
			int max = gh.removeHP();
			if (list.get(tr) > max) {
				gh.add(list.get(tr));
			} else {
				gh.add(max);
			}

			tr++;
		}

		for (int i = 0; i < k; i++) {
			rv.add(gh.removeHP());
		}

		return rv;
	}

	public static class helper implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	}

}
