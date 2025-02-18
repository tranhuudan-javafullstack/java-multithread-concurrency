package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Text {
	static public void charsetConvert(String source, String scs, String dest, String dcs) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(source), scs);
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest), dcs);

		int data;
		while ((data = isr.read())!=-1) osw.write(data);
		isr.close();
		osw.close();
	}
	public static void main(String[] args) throws IOException {
//		String s = "ABCD";
//		String charset = "UTF-8";
//		String path = "d:\\temp\\ltm\\println.txt";
//		FileOutputStream fos = new FileOutputStream(path);
//		OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
//		PrintWriter pw = new PrintWriter(osw);
//		pw.println(s);
//		pw.close();
		
		charsetConvert("d:\\temp\\ltm\\ut16.txt", "UTF-16", "d:\\temp\\ltm\\c8.txt", "UTF-8");

	}

}
