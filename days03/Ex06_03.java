package days03;


/**
 * @author user
 * @date 2024. 1. 3. 오후 4:22:15
 * @subject 산술 연산자 >> <<
 * @contents 시프트 연산자 (이동시키거나 바꾸는것)
 */
public class Ex06_03 {
	public static void main(String[] args) {
		// 0000 1010
		System.out.println(10);
		System.out.println(10>>2); // 2진수 비트 값에서 두칸씩 오른쪽으로 이동,
		//옮긴 후 맨 왼쪽의 값이 0 이면 왼쪽 빈 공간에 0 1이면 1로 채움
		System.out.println(10>>>2); // 위랑 동일한데 맨 왼쪽 값을 무조건 0으로 채움
		System.out.println(10<<5); // 2진수 비트 값에서 두칸씩 왼쪽으로 이동 ,
		//이때 맨 오른쪽 공간은 무조건 0으로 채움
	}

}
