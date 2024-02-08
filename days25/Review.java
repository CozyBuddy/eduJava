package days25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Review {
	//시간 : 2812782800
	//시간 : 1800900
	public static void main(String[] args) {
		String sourceFile = "C:\\Users\\맑음\\Downloads\\maxresdefault.jpg";
		String copyFile = "C:\\Users\\맑음\\Downloads\\maxresdefault_copy.jpg";
		
		fileCopyBinaryStream(sourceFile,copyFile);
	}

	private static void fileCopyBinaryStream(String sourceFile, String copyFile) {
		long start = System.nanoTime();
		int a ;
		byte b [] = new byte[1024] ;
		try (FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(copyFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos)){
			while ((a=bis.read(b))!=-1) {
				//System.out.printf("%08d\n",Integer.parseInt(Integer.toBinaryString(a)));
				bos.write(b, 0, a);
			}
			bos.flush();
			long end = System.nanoTime() -start;
			System.out.println(end);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
