package days02;

import java.util.Calendar;

/**
 * @author user
 * @date 2024. 1. 2. 오후 3:04:25
 * @subject
 * @contents
 */
public class Ex07_02 {
	public static void main(String[] args) {
		int i = 10 ;
		System.out.printf("%1$d\t%1$o\t%1$x\t%1$X\n",i); //\t -> 탭키
		System.out.printf("%1$d\t%1$#o\t%1$#x\t%1$#X\n",i); //\t -> 몇진수인지 바로 모르지 않나?
		
		//날짜 클래스
		Calendar c = Calendar.getInstance();
		System.out.printf("%1$tY-%1$tm-%1$td \n",c);
		
		// 출력서식 사용할때 문법
		// %[argument_index$][flags][width][.precision]conversion
		
		boolean gender = true;
		System.out.printf("%b\n",gender);
		
		int tot=277;
		double avg = 92.33333333333333;
		
		System.out.printf("총점 : [%10d]\n",tot);
		System.out.printf("총점 : [%-10d]\n",tot);
		
		
		System.out.printf("평균 : [%10.2f] \n",avg);
		
		int money = 123456;
		System.out.printf("머니 : %,d\n",money);
		
		int no = 15;
		// 0015 
		System.out.printf("NO : [%04d]\n",no); // ->flag:0 그리고 width:4 가 들어간거
		int j = 10;
		
		System.out.println(Integer.toString(i));
	}

}
