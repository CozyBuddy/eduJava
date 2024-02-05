package days05;

/**
 * @author user
 * @date 2024. 1. 5. 오후 2:00:26
 * @subject ASCII 256 가지 출력
 * @contents 
 * 			0~31 제어문자
 * 			32 ~ 127 일반문자(숫자, 대소문자 등)
 * 			128 ~ 사선 문자 ... 
 * 			문제 1) 한 라인에 10개씩 출력 //Linefeed 밑칸으로 커서이동 CarrageReturn 맨 왼쪽으로 커서이동
 */
public class Ex06 {
	public static void main(String[] args) {
		for (int i = 0; i < 256; i++) {
			//System.out.printf("%d - %c\n",i,i);
			System.out.printf(((i%10==9) ? "[%d.%c]\n": "[%d.%c]"),i+1,(char)i);
			
		}
		/*
		 *  //ASCII  10   개행    LineFeed(LF)         '\n'
      //ASCII  13   개행    CarrageReturn(CR)    '\r'
      
      // 개행 '\r\n' 엔터
      
      
      String code = "for (int i = 0; i < 256; i++) {\r\n"
            + "         // System.out.printf(\"%d-%c\\n\", i, i);         \r\n"
            + "         System.out.printf(\"[%c]\", (char)i);\r\n"
            + "         \r\n"
            + "         if( i % 10 == 9) {\r\n"
            + "            System.out.println();\r\n"
            + "         }\r\n"
            + "         \r\n"
            + "      } // for";
      
      for (int i = 0; i < 256; i++) {
         // System.out.printf("%d-%c\n", i, i);         
         System.out.printf("[%c]", (char)i);
         
         if( i % 10 == 9) {
            System.out.println();
         }
         
      } // for

		 */
		
	}

}
