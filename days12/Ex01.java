package days12;

import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		  // 로또 게임 횟수 입력 (n)

	      int n = 5;
	      //int lotto[] = new int[6*n];
	      int lotto[][] = new int[n][6];
	      fillLotto(lotto,n);
	      dispLotto(lotto,n);
	   }


	   /*   }
	   }
	    */
	   private static void dispLotto(int[][] lotto,int n) {
	      for (int i = 0; i < n; i++) {
	         for (int j = 0; j < lotto[i].length; j++) {
	            System.out.printf("lotto[%d][%d]=[%d]\n",i,j, lotto[i][j]);
	         }
	      }
	      System.out.println();       
	   }

	   private static void fillLotto(int[][] lotto, int i) { // i = 0, 1, 2
	      Random rnd = new Random(); 
	      int lottoNumber=0;
	     
	      for (i = 0; i < lotto.length; i++) {
	    	 for (int j = 0; j < lotto[i].length; j++) {
	    		 lottoNumber = rnd.nextInt(45)+1;
	    		 if( !isDuplicateLotto(lotto,lottoNumber ,i) ) {
		               lotto[i][j] = lottoNumber;
	    		 } else { 
	    			 j--;
	    		 }
				
			}
	      }
	      System.out.printf("[%d]",lottoNumber); 
	      
	            // 11:02 수업 시작~
	          
	            //index++;
	        
	   }

	   private static boolean isDuplicateLotto(int[][] lotto, int lottoNumber, int j) {
	      for (int i = 0 ; i < 6; i++) {
	         if( lottoNumber == lotto[j][i]) {
	            return true;                
	         }
	      }
	      return false;
	   }

	} // class
