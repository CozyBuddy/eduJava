package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 12:22:02
 * @subject
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) {
		 int x = 10, y = 20;
	      int [] m = {10,20};
	      System.out.printf("> x=%d, y=%d\n", m[0], m[1]);
	      
	      /*
	      {
	         int temp = x;
	         x = y;
	         y = temp;
	      }
	      */
	      // swap(x,y);
	      swap(m);
	      
	      System.out.printf("> x=%d, y=%d\n", m[0], m[1]);

	   } // main

	   //                      Call By Reference
	   private static void swap(int [] m) {
	      int temp = m[0];
	      m[0] = m[1];
	      m[1] = temp;
	   }
	   private static void swap(int x, int y) {
	      int temp = x;
	      x = y;
	      y = temp;
	   }

	} // class

