package days19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10_02 {
	public static void main(String[] args) {
		String source = "HP : 010-1234-5678 , Home : 02-999-0099";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source); // 일치하는 문자를 찾아냄
		
		// boolean m.matches()
		//boolean  m.find();
		int no = 0;
		while (m.find()) {
			System.out.printf("%d : %s\t %s-%s-%s \n",++no,m.group(),m.group(1),m.group(2),m.group(3));
			
		}
	}

}
