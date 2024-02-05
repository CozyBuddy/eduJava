package days24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Review1 {
	public static void main(String[] args) {
		String fileName = ".\\src\\days24\\Java 팀 구성.txt";
		String a = null;
		String e = null;
		String b[] = null ;
		ArrayList<String> d = new ArrayList<>();
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		
		int c = 0;
		try (FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);){
				while ((a=br.readLine())!=null) {
					e=a;
					a=br.readLine();
					b = a.split(",");
					for (int i = 0; i < b.length; i++) {
						d.add(b[i]); 
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
