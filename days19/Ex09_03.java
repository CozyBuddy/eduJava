package days19;

import java.io.FileReader;
import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 25. 오후 2:51:31
 * @subject 시험
 * @contents
 */
public class Ex09_03 {
	public static void main(String[] args) {
		//days18.Ex01.java 자바파일 안에 있는
		//알파벳을 대문자,소문자,숫자가 몇개인지 구분하고
		//배열에 저장 후 ### 막대그래프를 그리기.
		//counts[0] = A(65)문자의 갯수 저장
		//counts[1] = B문자의 갯수 저장
		//counts[2] = C문자의 갯수 저장
		// :
		//counts[25] = Z문자의 갯수 저장
		// A~Z 26문자
		//int countsUppercase [] = new int['Z'-'A'+1];
		//int countsLowercase [] = new int['z'-'a'+1];
		//int countsNumber [] = new int[10];
		int counts[] = new int['Z'-'A'+1+'z'-'a'+1+10];
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
				if (Character.isUpperCase(one)) {
					//System.out.print(one-'A');
					counts[one-'A']++;
				} else if (Character.isLowerCase(one)) {
					counts[one-'a'+26]++;
				} else if (one>='0' && one <='9') {
					counts[one-'0'+26*2]++;
				}
			}
			System.out.println(Arrays.toString(counts));
			for (int i = 0; i < counts.length; i++) {
				System.out.printf("'%c' : %s(%d)\n",(i<=25?'A'+i:(i<=51?'a'+ i-26:'0'+i-52)), "#".repeat(counts[i]),counts[i]);
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
	
