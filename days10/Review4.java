package days10;

public class Review4 {
	public static void main(String[] args) {
		int m [] = { 3,5,2,4,1};
		int temp[] = new int[6];
		for (int i = 0; i < temp.length; i++) {
			if (i>=3) {
				temp[i]=m[i-1];
						}
			else {
				temp[i]=m[i];
			}
			
		}
		temp[3]=100;
		m=temp;
		for (int i = 0; i < m.length; i++) {
			System.out.println("m["+i+"]="+m[i]);
		}
		
		
		
	}



}
