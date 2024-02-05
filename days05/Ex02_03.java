package days05;

public class Ex02_03 {
	public static void main(String[] args) {
		//함수(메서드) return 문
		// 제어문 		break 문
		int kor = 98;
		switch ( kor / 10 ) {
		// JDK 14 부터는 case 10 , 9 : 이런식으로 나열가능
         case 10:   
         case 9:
            System.out.println("수");
            break;
           
         case 8:
            System.out.println("우");
            break;
         case 7:
            System.out.println("미");
            break;
         case 6:
            System.out.println("양");
            break;
         default:
            System.out.println("가");
            break;

         }
         
         
	}

}
