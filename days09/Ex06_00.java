package days09;

public class Ex06_00 {
	public static void main(String[] args) {
		
	
		//정수를 입력받아서 2진수로 출력하는 코딩을 하세요. 
    //10 => 00000000 00000000 00000000 00001010
	char a ;
	int n =10;
	int b[] = new int[32];
	String c ;
	int i =1;
		while (i<=32) {
			b[32-i]= n%2;
			if (n==1) {
				n=0;
			} else {
				n=(n/2);
			}
			i++;
		}
		for (int j = 0; j < b.length; j++) {
			System.out.print(b[j]);
		}
		
	}
	
/*	 * int n =10; String binaryN = Integer.toBinaryString(n);
	 * System.out.printf("%032d",Integer.parseInt(binaryN));
	 */
}


