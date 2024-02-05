package days23;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author user
 * @date 2024. 1. 31. 오후 3:08:29
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		// A-Z  a-z 0-9
		// #### 막대그래프 
		// HashMap<읽어온 한 문자, 갯수>;
		HashMap<Character,Integer> hm = new HashMap<>();
		/*for (int i = 'A'; i < 'Z'; i++) {
			hm.put((char)i, null);
		}
		for (int i = 'a'; i < 'z'; i++) {
			hm.put((char)i, null);
		}
		for (int i = '0'; i < '9'; i++) {
			hm.put((char)i, null);
		}*/
		for (int i = '0'; i <= 'z'; i++) {
			if (Character.isDigit(i)|| Character.isAlphabetic(i)) {
				hm.put((char)i, 0);
			}
		}
		  String fileName = "\\src\\days18\\Ex01.java";      
	      String dir = "user.dir";
	      String userDir = System.getProperty(dir);      
	      String path = String.format("%s%s", userDir, fileName);
	      
	      try (FileReader fr = new FileReader(path); ){

	         int code ;
	         char one ;
	         // read(): EOF   -1 반환
	         while( (code = fr.read())!= -1 ) {
	            one = (char)code; // Ex01.java 
	            if(hm.containsKey(one)) {
	            	int count = hm.get(one);
	            	hm.put(one,count+1);
	            }
	            
	         } // while
	      } catch (Exception e) {
	         e.printStackTrace();
	      } // try
		//[출력코딩]
		// 'l' : 
		Set<Entry<Character, Integer>> se = hm.entrySet();
		Iterator<Entry<Character, Integer>> ir = se.iterator();
		while (ir.hasNext()) {
			Entry<Character, Integer> entry =  ir.next();
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.printf("%c : %s%d\n", key,"#".repeat(value),value);
		}
	}

}
