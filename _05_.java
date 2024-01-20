
public class _05_ {
	public static void main(String[] args) {
		int[][] array = { {95,86},{83,92,96},{78,83,93,87,88}};
		int sum = 0;
		double avg = 0.0;
		int sum1 = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				sum1 += 1;
			}
			
		}
		avg = (double)sum / sum1 ;
		
		System.out.println("sum = "+sum);
		System.out.println("avg = "+avg);
	}

}
