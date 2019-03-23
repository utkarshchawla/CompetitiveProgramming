package july_29;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> data = new ArrayList<>();
    private boolean ismin;

    public Heap(boolean ismin) {
        this.ismin = ismin;
    }

    public Heap(int[] arr, boolean ismin) {
        this.ismin = ismin;

        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }

        for (int i = data.size() / 2; i >= 0; i--) {
            downheapify(i);
        }
    }

    public void add(int value) {
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

    public int removeHP() {
        swap(0, data.size() - 1);
        int rv = data.remove(data.size() - 1);

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

        int ith = data.get(i);
        int jth = data.get(j);

        if (ismin) {
            if (ith < jth) {
                return true;
            }
            return false;
        } else {
            if (ith > jth) {
                return true;
            }
            return false;

        }
    }

    public void swap(int i, int j) {
        int ith = data.get(i);
        int jth = data.get(j);

        data.set(i, jth);
        data.set(j, ith);
    }

    public void display() {
        System.out.println(data);
    }

    public int size() {
        return data.size();
    }
}
