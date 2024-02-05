package days09;

import java.util.Arrays;

public class Ex06 {
	public static void main(String[] args) {
		int [] binaryArr = new int[32];
		int n =10;
		int index = binaryArr.length -1;
		int reminder ,share;
		while (n!=0) {
			share = n/2;
			reminder = n%2;
			binaryArr[index--] = reminder;
			n=share;
		}
		for (int i = 0; i < binaryArr.length; i++) {
			System.out.printf("%d",binaryArr[i]);
			if ((i + 1) % 8 == 0 && i != binaryArr.length - 1){
				System.out.print(" ");
			}
		}
	}
}
/*	//정수를 입력받아서 2진수로 출력하는 코딩을 하세요. 
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
					n = (n/2)*2;
				}
				i++;
			}
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[j]);
			}

		}

 * int n =10; String binaryN = Integer.toBinaryString(n);
 * System.out.printf("%032d",Integer.parseInt(binaryN));

	}*/

