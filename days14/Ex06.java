package days14;

import days07.Pibo;

/**
 * @author user
 * @date 2024. 1. 18. 오후 2:01:24
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		//[객체(클래스) 배열]
		//
		
		// 삼각형의 꼭짓점
		/*Point p1=new Point();
		Point p2=new Point();
		Point p3=new Point();
		*/	
		// 클래스(Point)를 자료형으로 선언된 배열을 "클래스 배열" 이라고 함.
		Point points[] = new Point[3]; // 객체 생성이 아니고 배열 선언 생성이어서 객체 생성을 따로 해줘야함.
		
		for (int i = 0; i < points.length; i++) {
			points[i]=new Point();
			points[i].dispXY();
		}
		
	}

}
