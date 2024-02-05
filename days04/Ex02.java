package days04;

/**
 * @author user
 * @date 2024. 1. 4. 오전 10:47:41
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) {
		//String[] args : [] 연산자 (인덱스)
		// 1. 한 학생의 국어 점수를 저장할 kor 변수 선언
		// int kor ;
		// 2. 10명 학생의 국어 점수를 저장할 변수를 선언
		// 배열 정의 : 동일한 자료형을 메모리상에 연속적으로 놓이게한것
		// 배열 장점 : 관리
		// 배열 선언 형식 : 자료형[] 변수명(배열명) = new 자료형[배열크기];
		// 스택은 실제 값이 있는 주소를 저장하는 곳
		// new -> heap 영역에 생성
		// new 자료형[배열의크기];
		int[] korarray= new int[4];
		korarray[1] = 20;
		int[] matharray = { 1,  2, 3,4, 5,6,7};
		System.out.println(matharray[1]);
		System.out.println(matharray.length);
		// 1번 학생의 국어점수 : 90 
		korarray[0] = 90 ;
		//첫번째 기억공간 : 0번째 요소 배열명[0]-> 배열주소 0을 첨자값이라고 부름
		//두번째 기억공간 : 1번째 요소
		korarray[1] =78 ;
		korarray[2] = 89 ;
		korarray[3] = 100 ; // 배열 크기를 유념.
		// lowerBound 하계,아랫첨자값 0 
		// Upperbound 상계, 윗첨자값 2= 배열크기-1 = 배열명.length-1
		
		System.out.println();
		korarray = null ; // 스택에서 주소가 null로 바뀌고 힙 영역에서는 기존의 저장값은
		 //Garbage (쓰레기)로 남음. 자바에서는 자동으로 collector에서 메모리 확보를 함.
		korarray[0] = 90 ; // -> null로 주소를 지워서 값을 저장할 수가 없음 
		
 		
		
	}

}
