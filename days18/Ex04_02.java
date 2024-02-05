package days18;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 24. 오후 2:05:54
 * @subject
 * @contents
 */
public class Ex04_02 {
	public static void main(String[] args) {
		//String todo = "Ride or die";
		
		/*System.out.println(todo.indexOf("or"));//
		System.out.println(todo.lastIndexOf("or"));// 중복된 문자가 있으면 달라짐
		*/		//System.out.println(todo.codePointAt(0)); // R에 대한 아스키코드 값
		/*todo.equals(todo); // 두 문자열을 비교해서 true ,false로 리턴함.
		todo.compareTo(""); // 두 문자열을 비교해서 같은면 0 다르면 -1로  반환.
		todo.compareTo(todo);*/
		/*		System.out.println("ABC".compareTo("AcC")); // B - c -> 66-99 값을 반환
				System.out.println("ABC".compareToIgnoreCase("AbC")); // 0
				System.out.println("CBC".compareTo("AcC")); // A-C , c-B 값을 반환
				//todo.endsWith(suffix); //접미사
				//todo.startsWith(prefix); // 접두사
				
				String url = "https://www.naver.com";
				System.out.println(url.startsWith("https://")); // 매개변수의 값으로 시작하는지 true false로 반환
				System.out.println(url.endsWith(".com")); // 매개변수의 값으로 시작하는지 true false로 반환
		*/
		//[문제]
		/*String directory = "C:\\spring\\src";
		String fileName = "Sample.java";
		
		String path = directory+fileName;
		if (fileName.startsWith("\\")) {
			path = directory + fileName;
		} else {
			path = directory+"\\"+fileName;
		}
		System.out.println(path);
		*/
		// boolean todo.equals(todo);
		// boolean todo.equalsIgnoreCase(todo);
		
		//byte todoByteArray[] = todo.getBytes();
		//System.out.println(Arrays.toString(todoByteArray));
		
	
		/*System.out.println(todo.indexOf("d")); // 앞에서부터 찾아서 찾은 인덱스값을 반환
		todo.lastIndexOf(0); // 뒤에서부터 찾아서 찾은 인덱스값을 반환
		*/ 
		//todo.matches(regex); // 정규표현식과 일치하는지 여부
		
		//System.out.println("-".repeat(900));
		
		String todo = "   Ride or die Todo Auto-generated against the world with you   ";
		
		// String.valueOf() 각 자료형의 값들을 다 문자열로 변환.
		// 3.14 + ""
		// true + ""
		// 100 + ""
		//char[] -> String
		char m [] = {'a','2','3'};
		String s = new String(m);
		System.out.println(String.valueOf(m));
		//todo.
		/*//todo.format(" ");
		System.out.println("<ul><li>"+String.join("</li><li>","권지용","구본혁","백예린"+"<ul><li>"));
		System.out.println(todo.toLowerCase());
		System.out.println(todo.toUpperCase());*/
		
		
		
		/*// String -> byte[] getByte()
		// String -> char[] toCharArray()
		char todoCharArray[] = todo.toCharArray();*/
		/*System.out.println(todo.substring(2,7)); // String
		System.out.println(todo.subSequence(2, 7)); // CharSequence
		todo.substring(0);
		todo.substring(0,2);
		*/
		
		/*todo.strip(); //trim()와 마찬가지로 앞 뒤 공백 제거 strip stripLeading stripTrailing
		System.out.println(todo.stripLeading()); // 앞에 공백만 제거
		todo.stripTrailing(); // 뒤에 공백만 제거
		
		System.out.println("["+"     R.O.D     ".trim()+"]");
		System.out.println("["+"     R.O.D     ".strip()+"]");
		System.out.println("["+"     R.O.D     ".stripLeading()+"]");
		System.out.println("["+"     R.O.D     ".stripTrailing()+"]");*/
		
		/*String regex = " ";
		//String todoArr[] = todo.split(regex);
		String todoArr[] = todo.split(regex,3); // limit 은 맨 처음부분부터 regex 로 3개로 나눔.
		System.out.println(Arrays.toString(todoArr));*/

		/*System.out.println(todo.replace('e', '*'));
		System.out.println(todo.replace("die","죽겠다."));
		//									regex 정규표현식
		System.out.println(todo.replaceAll("[Aa]\\.*", "*")); //정규식에 만족하는 모든 문자열을 String으로 교체
		System.out.println(todo.replaceFirst("[Aa]\\.*", "*")); //정규식에 만족하는 제일 첫 문자를 *로 교체
		//todo.replaceFirst(regex, "바꿀문자열");
		*/		
		
		}
		

}
