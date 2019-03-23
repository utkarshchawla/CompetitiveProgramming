package july_31;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap<T> {
	private ArrayList<T> data = new ArrayList<>();
	private Comparator<T> ctor;

	public GenericHeap(Comparator<T> ctor) {
		this.ctor = ctor;
	}

	public void add(T value) {
		data.add(value);
		upHeapify(data.size() - 1);
	}

	private void upHeapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;

		if (isLarger(ci, pi)) {
			swap(ci, pi);
			upHeapify(pi);
		}

	}

	public T removeHP() {
		swap(0, data.size() - 1);
		T rv = data.remove(data.size() - 1);

		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxi = pi;
		if (lci < data.size() && isLarger(lci, maxi)) {
			maxi = lci;
		}

		if (rci < data.size() && isLarger(rci, maxi)) {
			maxi = rci;
		}
		if (pi != maxi) {
			swap(pi, maxi);
			downheapify(maxi);
		}

	}

	public boolean isLarger(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		return ctor.compare(ith, jth) > 0;
	}

	public void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public void display() {
		System.out.println(data);
	}

	public int size() {
		return data.size();
	}

	public void updatePriority(T val) {
		int idx = -1;
		for (int i = 0; i < data.size(); i++) {
			if (val.equals(data.get(i))) {
				idx = i;
			}
		}

		upHeapify(idx);
		downheapify(idx);
	}
}
