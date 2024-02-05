package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 3:53:11
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		Ex10 obj = new Ex10();
		//메서드(기본형,참조형 매개변수)
		// 리턴자료형이 참조형인 경우~
		int m[] = new int[3];
		m = obj.increaseArrays(m);
		System.out.println(m.length);
	}

	private int[] increaseArrays(int[] m) {
		int temp [] = new int[m.length+3];
		m = temp;
		return m;
		
		
	}

}
