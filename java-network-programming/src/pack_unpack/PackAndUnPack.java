package pack_unpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class PackAndUnPack {
	public static List<File> getFiles(String file) throws FileNotFoundException	{
		File f = new File(file);
		if (! f.exists()) {
			throw new FileNotFoundException("File not found");
		}
		List<File> listFile = new ArrayList<File>();
		File[] fl = f.listFiles();
		for(File fi : fl) {
			if (fi.isFile())
			listFile.add(fi);
		}
		return listFile;
		
	}
	
	public static void pack(String folder, String packedFile) throws IOException {
		
		List<File> listFolder = getFiles(folder);
		File packFile = new File(packedFile);
		RandomAccessFile raf = new RandomAccessFile(packFile, "rw");
		long[] FEpos = new long[listFolder.size()];
		int index = 0;
		long pos = 0;
		long hPos;
		long size;
		raf.writeInt(listFolder.size());
		// write info file
		for (File file : listFolder) {
			FEpos[index++] = raf.getFilePointer();
			raf.writeLong(pos);
			raf.writeLong(file.length());
			raf.writeUTF(file.getName());
		}
		index = 0;
		// write contents 
		for (File f : listFolder) {
			pos = raf.getFilePointer();
			raf.seek(FEpos[index++]);
			raf.writeLong(pos);
			raf.seek(pos);
			byte[] buff = new byte[102400];
			int byteRead;
			FileInputStream fis = new FileInputStream(f);
			while ((byteRead =  fis.read(buff)) != -1) {
				raf.write(buff, 0, byteRead);
			}
			fis.close();
		}
		raf.close();
	}
	public static boolean unPack(String packFile, String extractFile, String dPath) throws IOException {
		File pFile = new File(packFile);
		if (!pFile.exists()) {
			throw new FileNotFoundException("File pack not found");
		}
		RandomAccessFile raf = new RandomAccessFile(packFile, "r");
		int totalFileNumber;
		long position;
		long fileSize;
		String nameFile;
		int data = 0;
		totalFileNumber = raf.readInt();
		for (int i = 0; i < totalFileNumber; i++) {
			position = raf.readLong();
			
			fileSize = raf.readLong();
			nameFile = raf.readUTF();
			if (nameFile.equals(extractFile)) {
				FileOutputStream fos = new FileOutputStream(dPath);
				raf.seek(position);
				byte[] buff = new byte[102400];
				int bytesRead;
				while (fileSize > 0) {
					 bytesRead = raf.read(buff, 0, (int) Math.min(buff.length, fileSize));
	                    if (bytesRead != -1) {
	                        fos.write(buff, 0, bytesRead);
	                        fileSize -= bytesRead;
	                    } else {
	                        break;  // Thoát khỏi vòng lặp nếu không thể đọc thêm dữ liệu
	                    }
					
				    }
				fos.close();
				raf.close();
				return true;
					
					
					
				
			
			}
		
			
		}
		raf.close();
	return false;
		
	}
	public static void main(String[] args) throws IOException {
		String folder = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\dDir";
		String packedFile = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.pack";
//		pack(folder, packedFile);
		String extractFile = "2- Module 1 - IO.pdf";
		String dFile = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\2- Module 1 - IO.pdf";
		System.out.println(unPack(packedFile, extractFile, dFile));
	}	
}
