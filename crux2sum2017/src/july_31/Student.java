package july_31;

import java.util.Comparator;

public class Student implements Comparable<Student> {

	private String name;
	private int marks;
	private int rank;

	final static StudentsMarksCompatator MarksCompatator = new StudentsMarksCompatator();
	final static StudentsRankCompatator RankCompatator = new StudentsRankCompatator();
	final static StudentsNameCompatator NameCompatator = new StudentsNameCompatator();

	public Student(String name, int marks, int rank) {
		this.marks = marks;
		this.rank = rank;
		this.name = name;
	}

	public int compareTo(Student other) {
		// return this.marks - other.marks;
		// return other.rank - this.rank;
		return this.rank - other.rank;
	}

	@Override
	public String toString() {
		return "[" + name + " => " + marks + "@" + rank;
	}

	private static class StudentsMarksCompatator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.marks - o2.marks;
		}

	}

	private static class StudentsRankCompatator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.rank - o1.rank;
		}

	}

	private static class StudentsNameCompatator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.compareTo(o2.name);
		}

	}

}
