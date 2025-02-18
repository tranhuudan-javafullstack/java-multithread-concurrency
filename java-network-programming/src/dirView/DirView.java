package dirView;

import java.io.File;
import java.io.FilenameFilter;

public class DirView {

	static public void dirView(String path, String filter) {

		File f = new File(path);

		if (!f.isDirectory() || !f.exists())
			return;

		String[] list = f.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(filter);
			}
		});

		for (String string : list) {

			System.out.println(string);
		}

	}

	public static void main(String[] args) {

		dirView("D:\\Ubuntu", ".log");
	}

}
