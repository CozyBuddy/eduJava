package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 3:36:19
 * @subject [단항연산자] ~ ! (cast)
 * @contents 음수를 나타내는 - , 양수를 나타내는 +
 *  		++,-- -> 증감연산자
 */
public class Ex06 {
	public static void main(String[] args) {
		// [문제] 어떤 기억 공간의 값을 1증가 시키는 코딩을 제시.
		// [답] 
		// 
			int n = 10;
			n++ ; // n = n+1 //n+=1//n++
			System.out.printf("n = %d\n",n);
			
			System.out.printf("n = %d",n);
		/*System.out.println(-3); //단항연산자(음수)	
		System.out.println(5-3); // 이항연산자(뺄셈)
		
		System.out.println(+3); //단항연산자(양수)	
		System.out.println(5+3); // 이항연산자(덧셈)
		*/
		
	}

}
