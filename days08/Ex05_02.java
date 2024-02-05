package days08;

import java.util.Random;

/**
 * @author user
 * @date 2024. 1. 10. 오후 2:29:18
 * @subject
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) {
		
		// 1 7 19 28 45 23
		
		    int lotto[] = new int[6];
			fillLotto(lotto);
			dispLotto(lotto);
	}

			
	/*	}
	}
*/
	private static void dispLotto(int[] lotto) {
		for (int i = 0; i < 6; i++) {
			System.out.printf("lotto[%d]=[%d]",i,lotto[i]);
		}
		
	}
	public static void fillLotto(int[] lotto) {
		Random rd = new Random();
		lotto[0]=rd.nextInt(45)+1;
		boolean a= false;
		int i =0;
		while (i==5) {
			int b =rd.nextInt(45)+1; 
			for (int j = 1; j < i; j++) {
				if (lotto[i]==b) {
					a=true;
					break;
				} 
			}   if(!a){
					lotto[i++]=b;

				}
			
				
			}

			
		}
}
		
		/*Random rd = new Random();
		lotto[0]=rd.nextInt(45)+1;
		for (int i = 0; i < lotto.length; i++) {
			int k=rd.nextInt(45)+1;
			for (int j = 0; j < i+1; j+=0) {
				if(k!=lotto[j]) {
					lotto[i]= k;
					j++;
				} else {
					
				}
			}
		}
	}*/
	
				
			
			
		
		
		
	


