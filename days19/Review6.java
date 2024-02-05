package days19;

import java.io.FileReader;

public class Review6 {
	public static void main(String[] args) {
		String readPath = "C:\\Users\\user\\git\\MyJava\\javaPro\\src\\days19\\Ex01.java";
		int a[]=new int[26];
		int b[]=new int[26];
		int c[]=new int[10];
	
		int line;
		try (FileReader fr = new FileReader(readPath);){
			while ((line=fr.read())!=-1) {
				if (line<='z'&& line>='a') {
					b[line-'a']+=1;
				} else if (line<='Z'&& line>='A') {
					a[line-'A']+=1;
				} else if (line<=9 && line>=0) {
					c[line-'0']+=1;
				} 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < 26; i++) {
			System.out.printf("[%s] : %s\n",(char)('A'+i) ,"#".repeat(a[i]));
			
		}
		for (int i = 0; i < 26; i++) {
			System.out.printf("[%s] : %s\n",(char)('a'+i),"#".repeat(b[i]));
			
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("[%s] : %s\n",(char)('0'+i ),"#".repeat(c[i]));
			
		}
	}

}
