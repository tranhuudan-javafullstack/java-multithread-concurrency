package exr4_pack;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class PackAndUnpack {
	static private List<File> getRegularFiles(String folder){
		List<File> regFiles = new ArrayList<File>();
		File dir = new File(folder);
		File[] list = dir.listFiles();
		for(File f:list) if (f.isFile()) regFiles.add(f);
		return regFiles;
	}
	static public void pack(String folder, String packedFile) throws IOException {
		List<File> regFiles = getRegularFiles(folder);
		RandomAccessFile raf = new RandomAccessFile(packedFile, "rw");
		
		long[] FEPos = new long[regFiles.size()];
		raf.writeInt(regFiles.size());
		int index = 0;
		long pos = 0;
		long hPos;
		for(File file:regFiles) {
			FEPos[index++] = raf.getFilePointer();
			raf.writeLong(pos);
			raf.writeLong(file.length());
			raf.writeUTF(file.getName());
		}
		index = 0;
		for(File file:regFiles) {
			pos = raf.getFilePointer();
			raf.seek(FEPos[index++]);
			raf.writeLong(pos);
			raf.seek(pos);
			
			byte[] buff = new byte[102400];
			int byteread;
			FileInputStream fis = new FileInputStream(file);
			while((byteread = fis.read(buff))!=-1) raf.write(buff,0, byteread);
			fis.close();
		}
		raf.close();
	}
	static public void unPack(String packedFile, String extractFile, String dest) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(packedFile, "r");
		long pos, size;
		String name;
		int fileNo = raf.readInt();
		for(int i=0; i<fileNo; i++) {
			pos = raf.readLong();
			size = raf.readLong();
			name = raf.readUTF();
			if (name.equalsIgnoreCase(extractFile)) {
				FileOutputStream fos = new FileOutputStream(dest);
				raf.seek(pos);
				for(long k=0; k<size; k++) {
					fos.write(raf.read());
				}
				fos.close();
				break;
			}
		}
		raf.close();	
	}
	public static void main(String[] args) throws IOException {
//		String folder = "D:\\TEMP\\TEST1\\abc";
		String packedFile = "D:\\TEMP\\TEST1\\abc.pack";
		
//		pack(folder, packedFile);
		
		String extractFile = "CV.pdf";
		String dest = "D:\\TEMP\\TEST1\\abc\\CV_copy.pdf";
		unPack(packedFile, extractFile, dest);
	}

}
