package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오후 3:15:11
 * @subject
 * @contents
 */
public class Ex12 {
	public static void main(String[] args) {
		// [예외처리]
		/*
		 * 1.프로그램 오류(에러) ? 프로그램이 오작동 or 비정상적으로 종료되는 것
		 * 
		 * 2.오류의 발생 시점에 따라 구분
		 *  1) 컴파일 오류 : 컴파일할때 발생하는 오류
		 *   	int i = 10 (;빠지는 경우)
		 *  2) 실행 오류 : 런타임 오류 , 실행 도중에 발생하는 오류
		 *     int m [] = null;
		 *     		(1) 에러(Error) : 메모리 부족, 스택 오버플로우, 복구할 수 없는 심각한 오류 // 중간에 개입할 수 있는 여지에 따라 나눔.
		 *     							Error 클래스 
		 *     								ㄴ 자식 클래스 : ~~~~ Error
		 *     		(2) 예외(Exception) : 개발자가 수습,처리할 수 있는 오류
		 *     									Exception 클래스
		 *     										ㄴ 자식 클래스 
		 *     						- 예외 클래스는 2개 그룹으로 나뉜다.
		 *     						 ㄱ. RuntimeException 클래스와 그 자식 클래스들 그룹
		 *     									IndexOutOfBoundException
		 *     									NullPointerException
		 *     									ClassCastException
		 *     						 ㄴ. Exception 클래스와 그 자손클래스 ( ㄱ 제외)
		 *     
		 *     3. 예외 처리 (Exception Handling)
		 *     	정의)프로그램 실행 시 발생할 수 있는 예기치 못한 예외에 대비한 코드를 작성하는 것
		 *     	목적) 프로그램의 비정상적 종료를 막고, 정상 상태 유지.
		 *     
		 *     4. 프로그램을 실행할 때 예외(Exception)이 발생하면 
		 *       JVM의 "예외처리기(UncaughtExceptionHandler)"가 예외를 받아서 
		 *       예외의 원인을 화면에 출력한다.
		 *     	
		 */ 
	}

}
