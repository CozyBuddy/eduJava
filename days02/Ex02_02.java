package days02;
//String %s
// double %f
// int %d
// char %c
public class Ex02_02 {
	public static void main(String[] args) {
		// 지역변수 (local variable)
		String name ="홍길동"; //main() 메서드 안에서 사용가능.
		{

		//{}지역(범위,영역) 연산자
		char grade = 'A';
		System.out.printf("1.이름 : \"%s\"\n", name);
		System.out.printf("1.등급 : '%c'\n",grade);
	} 
	 System.out.printf("2.이름 : \"%s\"\n", name);
	 //System.out.printf("2.등급 : '%c'",grade); //grade cannot be resolved to a variable
	} //main
} //class

