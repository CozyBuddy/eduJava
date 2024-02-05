package days19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;

public class Ex09 {
	public static void main(String[] args) {
		//days18.Ex01.java 자바파일 안에 있는
		//알파벳을 대소문자 구문하지 않고
		//배열에 저장 후 ### 막대그래프를 그리기.
		//counts[0] = A(65)문자의 갯수 저장
		//counts[1] = B문자의 갯수 저장
		//counts[2] = C문자의 갯수 저장
		// :
		//counts[25] = Z문자의 갯수 저장
		// A~Z 26문자
		int counts[] = new int['Z'-'A'+1];
		String readPath = "Ex01.java";
		
		String key = "user.dir";
		String userDir = System.getProperty(key);
		String path = String.format("%s\\src\\days18\\%s",userDir, readPath);
		//System.out.println(path);
		
		try(FileReader fr = new FileReader(path);) {
			int code ;
			char one;
			//EOF (파일의 끝) -1
			while ((code = fr.read())!=-1) {
				one = (char)code;
				//System.out.println(one);
				one = Character.toUpperCase(one);
				if (Character.isUpperCase(one)) {
					//System.out.print(one-'A');
					counts[one-'A']++;
				} 
			}
			System.out.println(Arrays.toString(counts));
			for (int i = 0; i < counts.length; i++) {
				System.out.printf("'%c' : %s(%d)\n",'A'+i , "#".repeat(counts[i]),counts[i]);
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
