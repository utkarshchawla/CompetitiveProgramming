package june_23;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		Integer[] one = { 1, 1, 2, 2, 2, 4, 5, };
		Integer[] two = { 1, 1, 1, 2, 2, 3, 5, };
		// System.out.println(intersection(one, two));
		// System.out.println(subsequences("abc"));
		// System.out.println(getBoardPaths(0, 10));
		System.out.println(getMazePathsMulti(0, 0, 2, 2));

	}

	public static ArrayList<Integer> intersection(Integer[] one, Integer[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] > two[j]) {
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				list.add(one[i]);
				i++;
				j++;

			}
		}
		return list;
	}

	public static ArrayList<String> subsequences(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = subsequences(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);

		}
		return mr;

	}

	public static ArrayList<String> getBoardPaths(int curr, int n) {
		if (curr == n) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (curr > n) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rr = getBoardPaths(curr + 1, n);
		for (String rs : rr) {
			mr.add("1" + rs);
		}
		rr = getBoardPaths(curr + 2, n);
		for (String rs : rr) {
			mr.add("2" + rs);
		}
		rr = getBoardPaths(curr + 3, n);
		for (String rs : rr) {
			mr.add("3" + rs);
		}
		rr = getBoardPaths(curr + 4, n);
		for (String rs : rr) {
			mr.add("4" + rs);
		}
		rr = getBoardPaths(curr + 5, n);
		for (String rs : rr) {
			mr.add("5" + rs);
		}
		rr = getBoardPaths(curr + 6, n);
		for (String rs : rr) {
			mr.add("6" + rs);
		}
		System.out.println(mr.size());
		return mr;

	}

	public static ArrayList<String> getMazePaths(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrv = getMazePaths(cr + 1, cc, er, ec);
		for (String rs : rrv) {
			mr.add("H" + rs);
		}
		ArrayList<String> rrh = getMazePaths(cr, cc + 1, er, ec);
		for (String rs : rrh) {
			mr.add("V" + rs);
		}
		ArrayList<String> rrd = getMazePaths(cr + 1, cc + 1, er, ec);
		for (String rs : rrd) {
			mr.add("D" + rs);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathsMulti(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int h = 1; h <= er; h++) {
			ArrayList<String> rrv = getMazePathsMulti(cr + h, cc, er, ec);
			for (String rs : rrv) {
				mr.add("H" + h + rs);
			}
		}
		for (int v = 1; v <= ec; v++) {
			ArrayList<String> rrh = getMazePathsMulti(cr, cc + v, er, ec);
			for (String rs : rrh) {
				mr.add("V" + v + rs);
			}
		}
		for (int d = 1; d <= er && d <= ec; d++) {
			ArrayList<String> rrd = getMazePathsMulti(cr + d, cc + d, er, ec);
			for (String rs : rrd) {
				mr.add("D" + d + rs);
			}
		}

		return mr;

	}

}
