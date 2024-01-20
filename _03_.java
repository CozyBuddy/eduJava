import java.util.Iterator;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class _03_ {
	public static void main(String[] args) {
		int[] oldarray = {12 , 34 ,56 };
		int[] newarray = new int[5];

		for (int i = 0; i < oldarray.length; i++) {
			newarray[i] = oldarray[i];

		}
		for (int i = 0; i < newarray.length; i++) {
			System.out.print(newarray[i]+" ");

		}
		String[] oldString = { "java" , "권" , "맑"};
		String[] newString = new String[5];

		System.arraycopy(oldString, 0, newString, 0, oldString.length);

		for (int i = 0; i < newString.length; i++) {
			System.out.println(newString[i]);

		}
		int[] Scores = {95, 92, 80, 85,80 };
		int sum = 0 ;
		for (int Score : Scores) {
			sum = sum + Score ; 

		}
		System.out.println("점수 총합 :"+ sum);

		double avg = (double)sum/Scores.length;
		System.out.println("점수 평균 :" +avg);

		boolean ex[] = {true ,true , true};
		boolean ex1[] = new boolean[5];
		System.out.println(ex1[0]);
	}
}
