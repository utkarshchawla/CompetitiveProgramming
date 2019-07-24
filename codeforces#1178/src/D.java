import javax.sound.midi.Soundbank;
import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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

    public static int count = 1;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        if (n == 5) {
            fw.println(7);
            print5(fw);
            fw.close();
            return;
        }
        if(n == 7){
            fw.println(7);
            print7(fw);
            fw.close();
            return;
        }
        int n3 = n / 3 - n % 3;
        int n4 = n % 3;
        long ans = n3 * 3 + n4 * 5;
        long np = ans;
        o:
        while (true) {
            for (int i = 2; i <= Math.sqrt(np); i++) {
                if (np % i == 0) {
                    np++;
                    continue o;
                }
            }
            break;
        }

        fw.println(np);
        long diff = np - ans;
        for (int i = 0; i < n3; i++) print3(fw);
        int four = count;
        for (int i = 0; i < n4; i++) print4(fw);
        while(diff > 0){
            for(int i = 0; i < n3 - 1; i+= 2){
                int a = i*3 + 1;
                int b = (i + 1)*3 + 1;
                fw.println(a + " " + b);
                diff--;
                if(diff == 0)break;
                fw.println((a + 1) + " " + (b + 1));
                diff--;
                if(diff == 0)break;
                fw.println((a + 2) + " " + (b + 2));
                diff--;
                if(diff == 0)break;
            }
            if(diff == 0)break;
            if(n4 == 1){
                fw.println(four + " " + (four + 3));
                diff--;
            }else if(n4 == 2){
                int a = four;
                int b = a + 4;
                fw.println(a + " " + b);
                diff--;
                if(diff == 0)break;
                fw.println((a + 3) + " " + (b + 3));
                diff--;
            }
        }
        fw.close();
    }

    public static void print3(FastWriter fw) throws IOException {
        fw.println(count + " " + (count + 1));
        fw.println(count + " " + (count + 2));
        fw.println((count + 1) + " " + (count + 2));
        count += 3;
    }

    public static void print4(FastWriter fw) throws IOException {
        fw.println(count + " " + (count + 1));
        fw.println(count + " " + (count + 2));
        fw.println((count + 1) + " " + (count + 2));
        fw.println((count + 1) + " " + (count + 3));
        fw.println((count + 2) + " " + (count + 3));
        count += 4;
    }

    public static void print5(FastWriter fw) throws IOException {
        fw.println(count + " " + (count + 1));
        fw.println(count + " " + (count + 2));
        fw.println((count + 1) + " " + (count + 3));
        fw.println((count + 2) + " " + (count + 3));
        fw.println((count + 4) + " " + (count + 3));
        fw.println((count + 4) + " " + (count + 1));
        fw.println(count + " " + (count + 4));
        count += 5;
    }
    public static void print7(FastWriter fw) throws IOException {
        fw.println((count) + " " + (count + 1));
        fw.println((count + 1) + " " + (count + 2));
        fw.println((count + 2) + " " + (count + 3));
        fw.println((count + 3) + " " + (count + 4));
        fw.println((count + 4) + " " + (count + 5));
        fw.println((count + 5) + " " + (count + 6));
        fw.println((count + 6) + " " + (count));
    }
}
