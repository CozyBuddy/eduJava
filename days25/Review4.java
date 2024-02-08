package days25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Review4 {
	public static void main(String[] args) {
		String sourceFile = ".\\src\\days25\\솔로지옥결말.txt";
		String copyFile = ".\\src\\days25\\솔로지옥결말_copy.txt";
		
		letsgoCopy(sourceFile,copyFile);
		
	}
	//9043900 시간 기본
	//1733400 시간 버퍼
	private static void letsgoCopy(String sourceFile, String copyFile) {
		long start = System.nanoTime();
		int a = 0;
		char b[] = new char[1024];
		int charNumber = 0;
		try (FileReader fr = new FileReader(sourceFile);
				FileWriter fw = new FileWriter(copyFile);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw)) {
			while ((charNumber=br.read(b))!=-1) {
				bw.write(b, 0, charNumber);
			}
			long end = System.nanoTime()-start;
			System.out.println(end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
