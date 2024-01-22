package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 4:14:41
 * @subject
 * @contents
 */
public class Ex10_02 {
	public static void main(String[] args) {
		// 리턴자료형이 클래스(참조형)인 경우
		/*// Point p1=newPoint();
		p1.x = 10;
		p1.y = 20;*/
		
		Point p1 = new Point(10,20);
		
		Point p2 = p1.moveNewPoint(50);
		p2.dispXY();
		p1.movePoint(100);
		p1.dispXY();
		// 현재 p1 좌표에서 x,y 거리가 50만큼 이동된 
		// 새로운 Point 좌표가 필요.
		
		/*Point p2 = new Point();
		p2.x = p1.x +50;
		p2.y = p1.y +50;
		p2.dispXY();*/
		
		/*p1.x +=100;
		p1.y +=100;*/
		
	}

}
