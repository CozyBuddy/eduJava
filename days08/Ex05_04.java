package days08;

import java.util.Random;

public class Ex05_04 {
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
		int b=rd.nextInt(45)+1;
		lotto[0]= b;
		boolean a= false;
		int i =1;
		out : while (i<=5) {
			 b =rd.nextInt(45)+1; 
			for (int j = 0; j < i; j++) {
				if (b==lotto[j]) {
					/*
					 * a=true; break;
					 */
					continue out;
				} 
			}
			   lotto[i++]= b;

				}
			
				
			}

			
		}

		


