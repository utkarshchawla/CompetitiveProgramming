import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E2 {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static class SegmentTreeMaximumRangeQuery {
        private int segmentTree[];
        private int lazy[];
        private int input[];

        private SegmentTreeMaximumRangeQuery(int[] input) {
            this.input = input;
            segmentTree = createSegmentTree();
            lazy = new int[segmentTree.length];
        }

        private int nextPowerOf2(int num) {
            if (num == 0) {
                return 1;
            }
            if (num > 0 && (num & (num - 1)) == 0) {
                return num;
            }
            while ((num & (num - 1)) > 0) {
                num = num & (num - 1);
            }
            return num << 1;
        }

        private int[] createSegmentTree() {
            //if input len is pow of 2 then size of
            //segment tree is 2*len - 1, otherwise
            //size of segment tree is next (pow of 2 for len)*2 - 1.
            int nextPowOfTwo = nextPowerOf2(input.length);
            segmentTree = new int[nextPowOfTwo * 2 - 1];

            for (int i = 0; i < segmentTree.length; i++) {
                segmentTree[i] = 0;
            }
            constructMaxSegmentTree(0, input.length - 1, 0);
            return segmentTree;
        }

        private void updateSegmentTree(int index, int delta) {
            input[index] += delta;
            updateSegmentTree(index, delta, 0, input.length - 1, 0);
        }

        private void updateSegmentTreeRange(int startRange, int endRange, int delta) {
            for (int i = startRange; i <= endRange; i++) {
                input[i] += delta;
            }
            updateSegmentTreeRange(startRange, endRange, delta, 0, input.length - 1, 0);
        }

        private int rangeMaximumQuery(int qlow, int qhigh) {
            return rangeMaximumQuery(0, input.length - 1, qlow, qhigh, 0);
        }

        private void updateSegmentTreeRangeLazy(int startRange, int endRange, int delta) {
            updateSegmentTreeRangeLazy(startRange, endRange, delta, 0, input.length - 1, 0);
        }

        private int rangeMaximumQueryLazy(int qlow, int qhigh) {
            return rangeMaximumQueryLazy(qlow, qhigh, 0, input.length - 1, 0);
        }

        private void constructMaxSegmentTree(int low, int high, int pos) {
            if (low == high) {
                segmentTree[pos] = input[low];
                return;
            }
            int mid = (low + high) / 2;
            constructMaxSegmentTree(low, mid, 2 * pos + 1);
            constructMaxSegmentTree(mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        private void updateSegmentTree(int index, int delta, int low, int high, int pos) {

            //if index to be updated is less than low or higher than high just return.
            if (index < low || index > high) {
                return;
            }

            //if low and high become equal, then index will be also equal to them and update
            //that value in segment tree at pos
            if (low == high) {
                segmentTree[pos] += delta;
                return;
            }
            //otherwise keep going left and right to find index to be updated
            //and then update current tree position if min of left or right has
            //changed.
            int mid = (low + high) / 2;
            updateSegmentTree(index, delta, low, mid, 2 * pos + 1);
            updateSegmentTree(index, delta, mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        private void updateSegmentTreeRange(int startRange, int endRange, int delta, int low, int high, int pos) {
            if (low > high || startRange > high || endRange < low) {
                return;
            }

            if (low == high) {
                segmentTree[pos] += delta;
                return;
            }

            int middle = (low + high) / 2;
            updateSegmentTreeRange(startRange, endRange, delta, low, middle, 2 * pos + 1);
            updateSegmentTreeRange(startRange, endRange, delta, middle + 1, high, 2 * pos + 2);
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        private int rangeMaximumQuery(int low, int high, int qlow, int qhigh, int pos) {
            if (qlow <= low && qhigh >= high) {
                return segmentTree[pos];
            }
            if (qlow > high || qhigh < low) {
                return 0;
            }
            int mid = (low + high) / 2;
            return rangeMaximumQuery(low, mid, qlow, qhigh, 2 * pos + 1) +
                    rangeMaximumQuery(mid + 1, high, qlow, qhigh, 2 * pos + 2);
        }

        private void updateSegmentTreeRangeLazy(int startRange, int endRange, int delta, int low, int high, int pos) {
            if (low > high) {
                return;
            }

            //make sure all propagation is done at pos. If not update tree
            //at pos and mark its children for lazy propagation.
            if (lazy[pos] != 0) {
                segmentTree[pos] += lazy[pos];
                if (low != high) { //not a leaf node
                    lazy[2 * pos + 1] += lazy[pos];
                    lazy[2 * pos + 2] += lazy[pos];
                }
                lazy[pos] = 0;
            }

            //no overlap condition
            if (startRange > high || endRange < low) {
                return;
            }

            //total overlap condition
            if (startRange <= low && endRange >= high) {
                segmentTree[pos] += delta;
                if (low != high) {
                    lazy[2 * pos + 1] += delta;
                    lazy[2 * pos + 2] += delta;
                }
                return;
            }

            //otherwise partial overlap so look both left and right.
            int mid = (low + high) / 2;
            updateSegmentTreeRangeLazy(startRange, endRange, delta, low, mid, 2 * pos + 1);
            updateSegmentTreeRangeLazy(startRange, endRange, delta, mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        private int rangeMaximumQueryLazy(int qlow, int qhigh, int low, int high, int pos) {

            if (low > high) {
                return 0;
            }

            //make sure all propagation is done at pos. If not update tree
            //at pos and mark its children for lazy propagation.
            if (lazy[pos] != 0) {
                segmentTree[pos] += lazy[pos];
                if (low != high) { //not a leaf node
                    lazy[2 * pos + 1] += lazy[pos];
                    lazy[2 * pos + 2] += lazy[pos];
                }
                lazy[pos] = 0;
            }

            //no overlap
            if (qlow > high || qhigh < low) {
                return 0;
            }

            //total overlap
            if (qlow <= low && qhigh >= high) {
                return segmentTree[pos];
            }

            //partial overlap
            int mid = (low + high) / 2;
            return rangeMaximumQueryLazy(qlow, qhigh, low, mid, 2 * pos + 1) +
                    rangeMaximumQueryLazy(qlow, qhigh, mid + 1, high, 2 * pos + 2);

        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        String s = fr.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') arr[i] = 1;
            else arr[i] = -1;
        }

        SegmentTreeMaximumRangeQuery st = new SegmentTreeMaximumRangeQuery(arr);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 1) if (st.rangeMaximumQuery(0, i - 1) < 0) break;
            if (arr[i] == 1) {
                st.updateSegmentTree(i, -2);
                if (st.rangeMaximumQuery(0, i) >= 0 && st.rangeMaximumQuery(0, arr.length - 1) == 0) ans++;
                st.updateSegmentTree(i, 2);
            } else {
                st.updateSegmentTree(i, 2);
                if (st.rangeMaximumQuery(0, i) >= 0 && st.rangeMaximumQuery(0, arr.length - 1) == 0) ans++;
                st.updateSegmentTree(i, -2);
            }
        }
        System.out.println(ans);
    }
}
