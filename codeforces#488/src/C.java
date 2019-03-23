import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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

    public static class point implements Comparable<point> {
        double x;
        double y;

        point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(point o) {
            double a = this.x + this.y;
            double b = o.x + o.y;
            if (a == b) {
                return (int) (this.y - o.y);
            } else {
                return (int) (a - b);
            }
        }
    }

    public static class line {
        double x;
        double y;

        line(point a, point b, double x) {
            this.x = x;
            this.y = (((b.y - a.y) * (x - a.x)) / (b.x - a.x)) + a.y;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        point[] one = new point[4];
        point[] two = new point[4];
        for (int i = 0; i < 4; i++) {
            one[i] = new point(fr.nextInt(), fr.nextInt());
        }

        for (int i = 0; i < 4; i++) {
            two[i] = new point(fr.nextInt(), fr.nextInt());
        }
        Arrays.sort(one);
        point temp = one[3];
        one[3] = one[2];
        one[2] = temp;

        point five = new point((two[2].x + two[0].x) / 2, (two[2].y + two[0].y) / 2);
        point[] tarr = two;
        two = new point[5];
        for (int i = 0; i < tarr.length; i++) two[i] = tarr[i];
        two[4] = five;
        for (int i = 0; i < 5; i++) {
            double vala = one[0].y - two[i].y;
            double valb = one[2].y - two[i].y;
            double valc = one[2].x - two[i].x;
            double vald = one[0].x - two[i].x;

            if ((vala >= 0 && valb <= 0 || vala <= 0 && valb >= 0) && (valc >= 0 && vald <= 0 || valc <= 0 && vald >= 0)) {
                System.out.println("YES");
                return;
            }

//            if (vala == 0 || valb == 0 || valc == 0 || vald == 0) {
//                System.out.println("YES");
//                return;
//            }
        }
        for (int i = 0; i < 4; i++) {
            line a = new line(two[0], two[1], one[i].x);
            line b = new line(two[2], two[3], one[i].x);

            line c = new line(two[1], two[2], one[i].x);
            line d = new line(two[3], two[0], one[i].x);

            double vala = one[i].y - a.y;
            double valb = one[i].y - b.y;
            double valc = one[i].y - c.y;
            double vald = one[i].y - d.y;

            if ((vala >= 0 && valb <= 0 || vala <= 0 && valb >= 0) && (valc >= 0 && vald <= 0 || valc <= 0 && vald >= 0)) {
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");
    }
}
