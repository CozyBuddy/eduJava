package days08;

import java.util.concurrent.Callable;

public class Ex02 {
	public static void main(String[] args) {

		int x = 10;
		int y = 20;

		System.out.printf(">x=%d , y=%d\n",x,y);
		swap(x, y);
		/*{
			int temp =x;
			x=y;
			y = temp;
		}
		 */
		System.out.printf(">x=%d , y=%d",x,y);
	}
	public static void swap(int x , int y) {
		System.out.printf(">x=%d , y=%d\",x,y);
				int temp =x;
				x=y;
				y = temp;
				System.out.printf(">x=%d , y=%d\",x,y);
	}
	/*
	 * 매개변수 + 함수 호출 방법 
	 * 1. Call by name ㄴ 매개변수는 없이 함수명으로 호출 
	 * 2. Call by value 
	 * ㄴ매개변수의 값을 가지고 함수를 호출 ㄴ swap(x,y); = swap(10,20);
	 * 
	 * 3.Call by Reference
	 */


}
