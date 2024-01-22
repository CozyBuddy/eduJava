package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 2:39:34
 * @subject 비트논리연산자
 * @contents & ^ | ~
 */
public class Ex04_05 {
	public static void main(String[] args) {
		/*
		// 0000 0011
		String binStr = Integer.toBinaryString(3);
		
		System.out.printf("%08d\n", Integer.parseInt(Integer.toBinaryString(3)));
		//System.out.printf("%#8s\n", Integer.toBinaryString(3));
		
		int no = 15;
		System.out.printf("%08d\n",no);
		*/
		// 0000 0011
		System.out.println(3);
		// 0000 0001
		System.out.println(1);
		// & 비트 논리 AND 연산자
		// 대응되는 비트 값을 비교
		// ex) 0000 0011
		// ex) 0000 0001
		// 1 & 1 ->1
		// 1 & 0 ->0
		// 0 & 1 ->0
		// 0 & 0 ->0
		System.out.println(3&1); // 이진법 비교해서 0000 0001 이 나옴 1
		
		// 1 | 1 ->1
		// 1 | 0 ->1
		// 0 | 1 ->1
		// 0 | 0 ->0
		System.out.println(3|1); // 이진법 비교해서 0000 0011 이 나옴 3 // 실사용??
		
		// ^ XOR 연산자
		// 	exclusive OR 연산자
		// 	배타적인 -> 같으면 0 다르면 1
		// 1 ^ 1 ->0
		// 1 ^ 0 ->1
		// 0 ^ 1 ->1
		// 0 ^ 0 ->0
		System.out.println(3^1);
		
		// !true => false
		// !false => true
		// ~ 틸드연산자
		// 1=>0 , 0=>1
		System.out.println(~3); // 그니까 3을 2진법으로 바꾸고 
		//그것에 대한 보수를 취한다음 1을 빼고 다시 보수를 취해서 나오는 값에 
		//음수를 붙이면 되는건가?
		// 1111 1100 2의 보수법
		// -1
		// 1111 1011
		// -> 보수 0000 0100
		// -4
		
		
	}

}
