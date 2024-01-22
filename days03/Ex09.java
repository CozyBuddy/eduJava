package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 5:11:35
 * @subject 
 * @contents
 */
public class Ex09 {
	public static void main(String[] args) {
		float pi = 3.141592f;
		
		// 소수점 4번째 자리에서 반올림한 실수값을 얻어오고 싶다.
		//double a = (%.3d ? pi=pi+0.001 : pi);
		Double a = Double.parseDouble(String.format("%.3f",pi));
		System.out.println(a);
		
		int i_pi = (int) (pi*1000+0.5) ; // 3142.092
		System.out.println((float)i_pi/1000);
	}

}
