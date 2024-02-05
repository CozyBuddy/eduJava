package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 12:27:12
 * @subject
 * @contents
 */
public class Ex05_03 {
	public static void main(String[] args) {
		Point p1 = new Point();
		p1.x=10;
		p1.y=20;
		System.out.printf("x=%d , y=%d\n",p1.x,p1.y);
		
		swap(p1); // Call by Reference
		
		System.out.printf("x=%d , y=%d\n",p1.x,p1.y);
	}

	private static void swap(Point p1) {
		int temp = p1.x;
		p1.x=p1.y;
		p1.y=temp;
		
	}

}
