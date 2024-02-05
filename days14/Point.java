package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 12:26:20
 * @subject
 * @contents
 */
public class Point {
	// field
	public int x;
	public int y;
	
	public Point(int i, int j) {
		x=i;
		y=j;
	}
	// method 
	public void dispXY() {
		System.out.printf("x=%d , y=%d\n",x,y);
	}
	// p1.movePoint()
	   public void movePoint(int pos) {
	      x += pos;
	      y += pos;
	   }
	   
	   // p1.moveNewPoint(50);
	   public Point moveNewPoint(int pos) {
	      int newx = x + pos;
	      int newy = y + pos;
	      
	      Point p = new Point();
	      p.x = newx;
	      p.y = newy;
	      return p;
	   }

	   // p1.plusPoint(p2);
	   public void plusPoint(Point p2) {
	      x += p2.x;
	      y += p2.y;
	      
	   }

	}