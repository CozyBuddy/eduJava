package days16;

import days15.Point;

/**
 * @author user
 * @date 2024. 1. 22. 오전 11:14:30
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		// [ is -a 관계 (상속) ]
		/*
		 * 1. 상속 (inheritance) ? 
		 * 		현실에서는	돈,부동산,주식 등등 
		 * 		코딩에서는 	기존의 클래스를 재사용하여 새로운 클래스로 작성하는 것.
		 * 						days15.Point          Point3D
		 * 2. 상속 장점
		 * 		-코드 재사용 -> 생산성 향상 , 유지보수 용이
		 * 		
		 * 3. 상속 시 클래스 선언 형식
		 * 		[접근지정자] [기타제어자] class 클래스명 extends 슈퍼클래스 {
		 * 		}
		 * 4. class Point3D extends Point 
		 * 		Point == 부모클래스 (Parent),기초,Super,상위
		 * 		Point3D == 자식클래스(Child),파생,Sub,하위
		 */
	}

}
class Point3D extends Point2D{
//	int x ;
//	int y ;
	int z ;
	
	Point3D(){}
	Point3D(int x, int y,int z) {
		//부모의 생성자
		//super(); //default 생성자 
		super(x,y); 
//		this.x=x;
//		this.y=y;
		this.z=z;
	}
}
class Point2D {
	int x ;
	int y ;
	
	
	Point2D(){}
	Point2D(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

/*class Point3D extends Point{
	//private int x;
	//private int y;
	private int z;
	
	//생성자
	
	//메서드
	
}*/
