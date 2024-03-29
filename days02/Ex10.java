package days02;


/**
 * @author user
 * @date 2024. 1. 2. 오후 4:24:24
 * @subject
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		// 정수 10 => 0000 1010
		// 음수 -10 => 
		// [음수 표현법 : 2의 보수법]
		// -10
		// 1)절댓값 |-10| = 10
		// 2)2진수 0000 1010
		// 3)보수  1111 0101 
		// 4)+1    
		// 5)	   1111 0110 (맨 앞이 1이면 음수)
		
		// 어떤 음수값 2진수 : 1010 0001 | 0101 1101 2^7+2^5+2^4+2^3+1 x -> 0101 1111
		// [실수 진법 변환]
		/*
		 *  0.625 (10진수 실수) -> 2진수 실수
		 *  0.625 *2= [1].25 
		 *  0.25 *2 = [0].5
		 *  0.5 * 2 = [1].0
		 *  0.[1][0][1] -> 2진수 실수값
		 *  
		 *  0.101 (2진수)
		 *  
		 *  1*2^(-1)+0*2^(-2)+1*2^(-3) = 0.625 (10진수)
		 */
	}

}
