package adHocMaths;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class uva12004 {
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
    }

    public static class Fraction implements Comparable<Fraction> {

        // Always coprime with the denominator.
        public final BigInteger numerator;

        // Always greater than zero.
        public final BigInteger denominator;


        public Fraction(int num, int den) {
            this(BigInteger.valueOf(num), BigInteger.valueOf(den));
        }


        public Fraction(BigInteger num, BigInteger den) {
            if (den.signum() == 0)
                throw new IllegalArgumentException("Zero denominator");

            // Simplify the fraction to the canonical form
            if (den.signum() == -1) {
                num = num.negate();
                den = den.negate();
            }
            BigInteger gcd = num.gcd(den);
            if (!gcd.equals(BigInteger.ONE)) {
                num = num.divide(gcd);
                den = den.divide(gcd);
            }
            numerator = num;
            denominator = den;
        }


        public Fraction(double x) {
            long bits = Double.doubleToRawLongBits(x);
            boolean negative = (bits >>> 63) != 0;
            int exponent = (int) ((bits >>> 52) & 0x7FF);
            long mantissa = bits & 0xFFFFFFFFFFFFFL;

            if (exponent == 0x7FF)
                throw new IllegalArgumentException("Infinity or NaN");
            if (exponent > 0x000)  // Normal number
                mantissa |= 0x10000000000000L;
            else  // Subnormal number
                exponent++;

            if (negative)
                mantissa = -mantissa;

            exponent -= 0x3FF;  // De-bias
            if (exponent >= 52) {
                numerator = BigInteger.valueOf(mantissa).shiftLeft(exponent - 52);
                denominator = BigInteger.ONE;
            } else {
                BigInteger num = BigInteger.valueOf(mantissa);
                BigInteger den = BigInteger.ONE.shiftLeft(52 - exponent);
                BigInteger gcd = num.gcd(den);
                numerator = num.divide(gcd);
                denominator = den.divide(gcd);
            }
        }


        public boolean equals(Object obj) {
            if (!(obj instanceof Fraction))
                return false;
            Fraction other = (Fraction) obj;
            return numerator.equals(other.numerator) && denominator.equals(other.denominator);
        }


        public int hashCode() {
            return numerator.hashCode() + denominator.hashCode();
        }


        public int compareTo(Fraction other) {
            return numerator.multiply(other.denominator).compareTo(other.numerator.multiply(denominator));
        }


        public String toString() {
            return String.format("%d/%d", numerator, denominator);
        }

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = fr.nextInt();
            double[] arr = new double[n + 1];
            for (int j = 1; j < arr.length; j++) {
                arr[j] += arr[j - 1] + (double) (j - 1) / 2d;
            }

            Fraction f = new Fraction(arr[n]);
            if (f.denominator.equals(BigInteger.valueOf(1))) {
                System.out.println("Case " + i + ": " + f.numerator);
            } else {
                System.out.println("Case " + i + ": " + f.numerator + "/" + f.denominator);
            }
        }
    }
}
