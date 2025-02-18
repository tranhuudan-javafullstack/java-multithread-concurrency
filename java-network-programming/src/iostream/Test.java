package iostream;
import java.io.*;
public class Test {

	public static void main(String[] args) throws IOException {
		String path = "d:\\temp\\ltm\\abc";
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(65);
		fos.write(66);
		fos.write(67);
		fos.write(68);
		fos.close();

	}

}
