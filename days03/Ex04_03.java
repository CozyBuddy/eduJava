package days03;

/**
 * @author user
 * @date 2024. 1. 3. 오후 12:39:55
 * @subject [비교 연산자] 크다.작다,같거나 크다, 같거나 작다, 같다, 다르다
 * @contents 비교 연산자는 처리 결과가 항상 true/false 인 boolean 형임. 
 * 			[instanceof 비교연산자 있다.] -> 클래스 수업때 객체를 비교할 때 사용하는 연산자.
 */
public class Ex04_03 {
	public static void main(String[] args) {
		int i=10 , j =3;
		System.out.println(i>j);
		System.out.println(i<j);
		System.out.println(i >= j);
		System.out.println(i <= j);
		// 주의할점 대입연산자는 ==랑 다름
		// println 안에 대입연산자도 후에 적용이 됨.
		System.out.println(i == j);
		System.out.println(i != j);
		//System.out.println(i =!j); -> 논리 연산자 중에 부정(not) 연산자 -> j를 부정한 후 i에 대입 ?
		
		
	}

}
