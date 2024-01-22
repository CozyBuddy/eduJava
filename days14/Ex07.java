package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 2:28:28
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
	      
	      // x,y 좌표점   + 5개 읽기/쓰기
	      int x1=1,y1=2;
	      int x2=3,y2=4;
	      int x3=5,y3=6;
	      int x4=7,y4=8;
	      int x5=9,y5=0;
	      
	      dispXY(x1,y1,x2,y2,x3,y3,x4,y4,x5,y5);
	      
	      int [] xArr = { x1,x2, x3,x4,x5 };
	      int [] yArr = { y1,y2, y3,y4,y5 };
	      

	      dispXY(xArr, yArr);
	   } // main
	   
	   private static void dispXY(int [] x, int [] y) {
	         // 출력~    
	   }
	   
	   // The variable argument type int of the method dispXY 
	   // must be the last parameter
	   /*
	   private static void dispXY(int...x, int...y) {
	      //       
	   }
	   */

	   private static void dispXY(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
	      System.out.println(x1+","+y1);
	      System.out.println(x1+","+y1);
	      System.out.println(x1+","+y1);
	      System.out.println(x1+","+y1);
	      System.out.println(x5+","+y5);
	      
	   }

	} // class
