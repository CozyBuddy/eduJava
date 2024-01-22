package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 3:50:15
 * @subject 증감연산자 ++/-- , 복합대입연산자 +=,-=
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		int x = 10;
		int y = ++x; // 전위형 증감연산자
		//int y = x++; 후위형 증감연산자
		System.out.printf("> x=%d , y =%d\n",x,y);
		int n = 100;
		System.out.println(++n==100);
		System.out.println(n++==100);
	}

}
