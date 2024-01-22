package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오전 11:06:13
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		//int m[] = null;//Null Exception 힙영역을 참조하지 않을경우 단순히 객체명만 
		/*int m[] = new int[3];
		//ArrayIndexOutOfBoundsException
		System.out.println(m[3]);*/
		// NullPointerException -> 힙영역을 참조하지 않는 것
		TV tv1 =null;
		System.out.println(tv1.power);
		
		
		
	}

}
