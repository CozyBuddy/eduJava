package days11;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author user
 * @date 2024. 1. 15. 오후 2:01:55
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		int [] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };
		int max=m[0];
		int min=m[0];
		int sum=m[0];
		double avg ;
		for (int i = 1; i < m.length; i++) {
			if(max <m[i]) max= m[i];
			else if (min> m[i]) min = m[i];
			sum+=m[i];
		}
		avg = sum/m.length;
		System.out.printf("%d, %d , %d ,%f\n", max,min,sum,avg);
		
		System.out.println("*".repeat(60));
		max = IntStream.of(m).max().getAsInt();
		min = IntStream.of(m).min().getAsInt();
		sum = IntStream.of(m).sum();
		avg = IntStream.of(m).average().getAsDouble();
		
		int score [] =new Random().ints(20,0,101).toArray();
		for (int i = 0; i < score.length; i++) {
			
		}
	}

}
