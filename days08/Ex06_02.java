package days08;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 10. 오후 4:19:05
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
	      String rrn = "830412-1700001";
	      // String split()
	      // "830412" + "1******"
	      // String -> char []
	      char [] rrnArr = new char[ rrn.length() ];
	      System.out.println( Arrays.toString(rrnArr) );
	      // String Arrays.toString(배열)
	      Arrays.fill(rrnArr, '*'); //래퍼함수 기억해야할듯?
	      
	      for (int i = 0; i < 8; i++) {         
	         //if(i >=8) {
	         //   rrnArr[i]= '*';
	         //}else {
	            rrnArr[i]= rrn.charAt(i);
	         //}          
	      }      
	      System.out.println( Arrays.toString(rrnArr) );
	      // char[] -> String 
	      String printRRN = String.valueOf(rrnArr);
	      System.out.println( printRRN );
	      
	      
	      // 주민등록번호를 출력
	      // 830412-1******
	    // main

	 // class
		/*//String a = rrn.substring(0,8);
		String c = "-";
		String b[] = rrn.split(c);
		for (int i = 0; i < 2; i++) {
			System.out.print(b[i]);
		}
		
	}*/
	}

}
