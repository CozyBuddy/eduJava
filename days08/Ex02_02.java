package days08;

import java.util.Arrays;

public class Ex02_02 {
	public static void main(String[] args) {
		/*
		 * 매개변수 + 함수 호출 방법 
		 * 1. Call by name ㄴ 매개변수는 없이 함수명으로 호출 
		 * 2. Call by value 
		 * ㄴ매개변수의 값을 가지고 함수를 호출 ㄴ swap(x,y); = swap(10,20);
		 * 
		 * 3.Call by Reference
		 * 	힙영역과 스택영역 중에서 함수 선언할때는 스택영역이 달라짐. 같은 변수라도 하지만 배열로 선언해서
		 *  진행하면 스택영역이 달라도 같은 힙영역을 가리키기 때문에 같은 힙영역의 값을 바꿔줌
		 */
		int m[] = {10 ,20};
		System.out.println(Arrays.toString(m));
		swap(m);
		System.out.println(Arrays.toString(m));
		
		
		/*{
			int temp =x;
			x=y;
			y = temp;
		}
		 */
		//System.out.printf(">x=%d , y=%d",x,y);
	}
	private static void swap(int[] m) {
		int temp = m[0];
		m[0] = m[1];
		m[1]=temp ;		
	}
	public static void swap(int x , int y) {
		System.out.printf(">x=%d , y=%d\n",x,y);
		int temp =x;
		x=y;
		y = temp;
		System.out.printf(">x=%d , y=%d\n",x,y);
	}


}
