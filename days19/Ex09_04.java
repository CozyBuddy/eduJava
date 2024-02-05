package days19;

import java.io.FileReader;
import java.util.Arrays;

public class Ex09_04 {
	
	/**
	 * @author 
	 * @date 2024. 1. 25. - 오후 2:51:30
	 * @subject
	 * @content
	 */
	   public static void main(String[] args) {
	     //가변 배열 
	      int [][] counts = new int[3][];
	      counts[0] = new int[26];
	      counts[1] = new int[26];
	      counts[2] = new int[10];
	      
	      String fileName = "\\src\\days18\\Ex01.java";      
	      String key = "user.dir";
	      String userDir = System.getProperty(key);      
	      String path = String.format("%s%s", userDir, fileName);
	      
	      try (FileReader fr = new FileReader(path); ){

	         int code ;
	         char one ;
	         // read(): EOF   -1 반환
	         while( (code = fr.read() ) != -1 ) {
	            one = (char)code;
	            // System.out.println(one);            
	            if( Character.isUpperCase(one) ) { 
	               counts[0][one - 'A']++;
	            }else if( Character.isLowerCase(one) ) {
	               counts[1][one - 'a']++;
	            } else if (Character.isDigit(one)) { //숫자인지 체크
					counts[2][one-'0']++;
				}
	         } // while

	         System.out.println( Arrays.toString(counts[0]) );
	         System.out.println( Arrays.toString(counts[1]) );
	         System.out.println( Arrays.toString(counts[2]) );

	         for (int i = 0; i < counts.length; i++) { // 행
	            //System.out.println(i==0? "[대문자 출력]": "[소문자 출력]");
	            for (int j = 0; j < counts[i].length; j++) {
	               System.out.printf("'%c': %s(%d)\n"
	                     , i==0?'A'+j: (i==2?'0'+j:'a'+j)  
	                     ,  "#".repeat( counts[i][j] ) , counts[i][j]);               
	            }
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      } // try


	   } // main

	} // class