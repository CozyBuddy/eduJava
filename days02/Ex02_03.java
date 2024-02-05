package days02;

/**
 * @author user
 * @date 
 * @subject 두 기억공간의 값을 바꾸기 (시험낸다)
 */
public class Ex02_03 {
	public static void main(String[] args) {
		/*
		int x = 10;
		int y = 20;
		*/
		
		// 콤마(,)연산자 나열뜻
		int x=10 ,y=20 ;
		
		/*
		int a = 100;
		int b = 100;
		int c = 100;
		*/
		// int a=100,b=100,c=100;
		int a,b,c;
		a=b=c=100;
		// 3+4+5 처리 과정 ->7+5 -> 12 왼쪽에서 오른쪽으로
		// 대입연산자는 오른쪽에서 왼쪽으로
		
		System.out.printf("교환 전 > x=%d, y =%d\n",x,y);
		// [작업]
		// 프로그램 상에서 두 기억공간의 값을 교환하려면 
		// 반드시 동일한 자료형의 임시기억공간(int형 temp)이 필요하다.
		{
		int temp= x;
		x =y;
		y=temp;
		} // temp 라는 임시기억공간을 지역변수 안에 둠으로써 교환이 완료되면 알아서 제거됨.
		System.out.printf("교환 후 > x=%d, y =%d\n",x,y);
	} // main

}
