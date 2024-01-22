package days07;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) { //1 0 2 1 3 2 4 1 5 0
		/*//[7] 3번 문제 이등변삼각형
		Scanner scanner = new Scanner(System.in);
		System.out.print("행 갯수 입력>");
		int row = scanner.nextInt();
		for (int i = 1; i <= row; i++) { 
			for (int j = 1; j <= 2*row-1; j++) {
				System.out.print(i+j>=row+1&&j-i<=row-1? "*":"_");
			}
			System.out.println();
		}
		*/

		
	
	
		//[6] 5행 5열 x자
		for (int i = 1; i <= 5; i++) { 
			for (int j = 1; j <= 5; j++) {
				
				  //if(i==j) System.out.print("*") ;
				 // else System.out.print(" ");
				  //System.out.print(i==j ? "*":" ");
				 
			System.out.print(i==j || i+j==6 ? "*":" "); //함수로 생각하면 바로 나오네.
			} 
			System.out.println();


		} // shift + tab -> 왼쪽으로 정렬?

	}
}
		
		
		
		/*	//[6] 이등변삼각형
		for (int i = 1; i <= 3; i++) { 
			for (int j = 1; j <= 3-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			} System.out.println();


		} // shift + tab -> 왼쪽으로 정렬?
	}



}*/
/*		//[5] 
		for (int i = 1; i <= 4; i++) { 
			for (int j = 1; j <= i-1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 5-i; j++) {
				System.out.print("*");
			} System.out.println();


		} // shift + tab -> 왼쪽으로 정렬?
	}
}*/



/*		//[4] 
		for (int i = 1; i <= 4; i++) { 
			for (int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
		} System.out.println();

		}
	}


}*/

/*	 // [3] 
				  for (int i = 1; i <= 4; i++) { 
					  for (int j = 1; j <= 5-i; j++) { //System.out.println("*".repeat(5-i)) 로 바꿔도 됨.
						  System.out.print("*");
		  } System.out.println();

		  } 

	}
}*/

/*
 * [2] for (int i = 1; i <= 4; i++) {
 *  for (int j = 1; j <= i; j++) {
 * //System.out.println("*".repeat(i)); ->넣어도 됨. System.out.print("*");
 * 
 * } System.out.println();
 * 
 * } }
 * 
 * 
 * }
 */

/*
 * [1] public static void main(String[] args) { for (int i = 1; i <= 4; i++) {
 * for (int j = 1; j <= 4; j++) { System.out.print("*");
 * 
 * } System.out.println();
 * 
 * } }
 * 
 * 
 * }
 */
/*
 * for (int i = 1; i <= 4; i++) { System.out.println("*".repeat(4)); // *을 4번
 * 반복하는 함수 // String.repeat(int count) }
 * 
 */
