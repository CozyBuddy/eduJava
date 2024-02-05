package days19;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		String answer[] =solution(my_str,n);

		//[ ]
		System.out.println(Arrays.toString(answer));

	}
	/* public static String[] solution(String my_str, int n) {

	        int arraylength = (int)Math.ceil((double)my_str.length()/n);
	        String[] answer = new String[arraylength] ;
	        StringBuilder sb = new StringBuilder(my_str);
	        for (int i = 0; i < answer.length-1; i++) {
	        	answer[i]= sb.substring(0,n); sb.delete(0, n);
			}
	        answer[arraylength-1]= sb.substring(0); 

	        return answer;
	    }


}*/
	public static String[] solution(String my_str, int n) {
		String[] answer = new String[(int)Math.ceil((double)my_str.length()/n)];
		int count = 0;
		while ((int)Math.ceil((double)my_str.length()/n)!=count+1) {
			answer[count]="";
			Out : for (int i=count*n ; i<count*n+n; i++) {
				answer[count]+= my_str.charAt(i);
				if (i==my_str.length()-n) {
					for (int j=count*n ; j<count*n+(my_str.length()-count*n)%n; j++) {
					answer[count]=my_str.charAt(j)+"";
					break Out;
				}
			}
			count++;
		}
		
		}
		return answer;
	}
}


