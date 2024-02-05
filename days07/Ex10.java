package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 4:42:30
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c;
		// 두 정수 a,b의 합을 구해서 출력.
		// 두 정수의 합을 구해서 반환하는 메서드 선언 + 호출
		c=sum(a, b);
		System.out.println(sum(a, b));
		System.out.println(sum(a,b,c));
	}

	public static int sum(int x,int y) {
		return x+y;
		
	}
	public static int sum(int x,int y,int z) {
		return x+y+z;
		
	}


}
