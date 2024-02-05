package days13;

/**
 * @author user
 * @date 2024. 1. 17. 오후 3:27:09
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		int m[][] = new int[5][5];
		magicSquare(m);
		//fillM2(m);
		//fillM3(m);
		dispM(m);
	}

	private static void magicSquare(int[][] m)  {
		int i=0,j=2;
		int count = 1;
	
		
		while (count<25){
			m[i][j] = count;
			//1초 후에 실행하기
			
			if (count%5==0) {
				i++;
				
			} else {
				i--;
				j++;
				if (i==-1) 
					i=4;
				else if (j==5) 
					j=0;
					
				
					

			}
			
		count++;
	}
	}

	/*private static void magicSquare(int[][] m) {
	      // 1) 첫 번째 행의 가운데 열    1 
	      // 2) 출력한 값이 5의 배수 O    행만 증가
	      //                         X
	      //          열증가, 행감소
	      //              ㄴ행 벗어나는 경우 -가장 큰 행의 값으로 설정. 
	      //              ㄴ열 벗어나는 경우 -가장 작은 열의 값으로 설정.
	      
	      int n = 1;
	      int row = 0, col = 2;
	      
	      while( n <= 25) {
	         m[row][col] = n;
	         if (n % 5 == 0) {
	            row++;
	         } else {
	            col++; row--;
	            // 행 X, 열 X
	            if( col == 5 ) col = 0;
	            else if( row == -1) row = 4;
	         }      
	         n++;
	      } // while
	      
	      
	      
	      
	      
	   } // magicSquare
	*/
	private static void fillM3(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j]=(j+1)*5-i;
			}
		}
		
	}

	private static void fillM2(int[][] m) {
		for (int i = 0; i < m.length; i++) { // m.length 행 갯수
			for (int j = 0; j < m[i].length; j++) {
				m[4-i][4-j]=5*i+j+1;
			}
		}
	}
	/*[3]
	 * private static void fillM2(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j]= 26-(5*i+j+1);
			}
		}

	}*/

	/* [2]
	 * private static void fillM(int[][] m) {
		for (int i = 0; i < m.length; i++) { // m.length 행 갯수
			for (int j = 0; j < m[i].length; j++) {
				m[i][j]=5*i+j+1;
			}

		}
	}*/
	/*
	 * [1]
	 * private static void fillM(int[][] m) {
		for (int i = 0, value =1; i < m.length; i++) { // m.length 행 갯수
			for (int j = 0; j < m[i].length; j++,value++) {
				m[i][j]=value;
			}

		}
	}*/

	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) { // m.length 행 갯수
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("[%02d]",m[i][j]);
			}
			System.out.println();
		}
	}

}
