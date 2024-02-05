package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오전 11:52:39
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		// 1) 객체(클래스) 복사 copy 주소값을 복사 한다고 생각하면될듯.
		// 2) 객체(클래스) 복제 clone

		TV tv1 = new TV();   
		tv1.color = "red";
		changeColor(tv1);
		System.out.println( tv1.color );
		// Tv tv2 = new Tv();
		TV tv2 = tv1;  // 객체 복사(copy)

		int x = 100;
		plusX(x);
		System.out.println( x );

		int [] m = {100};
		plusM(m);
		System.out.println( m[0] );

	} // main
	//                        객체 복사      Tv tv1= tv1
	private static void changeColor(TV tv1) {
		tv1.color = "blue";
	}

	private static void plusM(int[] m) {
		m[0]++;
	}

	private static void plusX(int x) {

		x++;

	}

 // class




}


