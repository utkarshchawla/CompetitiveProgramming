import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception {
		// long startTime = System.nanoTime();

		int c = (int) Math.pow(10, 5);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c; i++) {
//			System.out.print("b");
			 sb.append("a");
		}
		// System.out.println(sb);
		// long endTime = System.nanoTime();
		// System.out.println("Took "+(endTime - startTime) + " ns");
		ArrayList<String> line = new ArrayList<>(Arrays.asList(sb.toString()));
		Path file = Paths.get("lol.txt");
		Files.write(file, line, Charset.forName("UTF-8"));
	}
}