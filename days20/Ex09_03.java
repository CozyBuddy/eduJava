package days20;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * @author user
 * @date 2024. 1. 26. 오후 4:26:41
 * @subject
 * @contents
 */
public class Ex09_03 {
	public static void main(String[] args) throws ParseException {
		String output = "이름:권맑음, 나이:26살, 성별:남자, 키:178.67 입니다.";
		String pattern = "이름:{0}, 나이:{1}살, 성별:{2}, 키:{3} 입니다.";
		MessageFormat mf = new MessageFormat(pattern);
		Object objs [] =mf.parse(output);
		for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
		}
		
   } // main

} // class
