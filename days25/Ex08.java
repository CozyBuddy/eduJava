package days25;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.stream.Stream;

/**
 * @author user
 * @date 2024. 2. 2. 오후 2:29:48
 * @subject
 * @contents
 */
public class Ex08 {
	public static void main(String[] args) {
		String source = "package days25;\r\n"
				+ "\r\n"
				+ "/**\r\n"
				+ " * @author kenik\r\n"
				+ " * @date 2023. 8. 17. - 오전 10:52:06\r\n"
				+ " * @subject\r\n"
				+ " * @content\r\n"
				+ " */\r\n"
				+ "public class Ex03 {\r\n"
				+ "   //                   0     1      2     3      순서 X\r\n"
				+ "   // enum Direction { EAST, SOUTH, WEST, NORTH }\r\n"
				+ "   \r\n"
				+ "   //                  문법 에러.\r\n"
				+ "   // enum Direction { EAST=100, SOUTH=200, WEST, NORTH }\r\n"
				+ "   \r\n"
				+ "   // 왜? The constructor Ex03.Direction(int) is undefined\r\n"
				+ "   //               생성자(1) X\r\n"
				+ "   // enum Direction { EAST(100), SOUTH(200), WEST(300), NORTH(400) }\r\n"
				+ "   \r\n"
				+ "   enum Direction { \r\n"
				+ "         EAST(100, \"▶\"), SOUTH(200, \"▼\"), WEST(300, \"◀\"), NORTH(400,\"▲\") ;\r\n"
				+ "\r\n"
				+ "      private final int value;\r\n"
				+ "      private final String symbol;\r\n"
				+ "      \r\n"
				+ "      /*\r\n"
				+ "      Direction(int value) {\r\n"
				+ "         this.value = value;\r\n"
				+ "         this.symbol = \"\";\r\n"
				+ "      }\r\n"
				+ "      */\r\n"
				+ "\r\n"
				+ "      Direction(int value, String symbol) {\r\n"
				+ "         this.value = value;\r\n"
				+ "         this.symbol = symbol;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      public int getValue() {\r\n"
				+ "         return value;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      public String getSymbol() {\r\n"
				+ "         return symbol;\r\n"
				+ "      }\r\n"
				+ "       \r\n"
				+ "      // 추상 메서드 선언 가능\r\n"
				+ "      //abstract int test(int i);\r\n"
				+ "         \r\n"
				+ "   }\r\n"
				+ "\r\n"
				+ "   public static void main(String[] args) {\r\n"
				+ "      // [ 열거형에 멤버(필드,메서드, 생성자) 추가하기. ]\r\n"
				+ "      // 11:03 수업시작~\r\n"
				+ "      \r\n"
				+ "      // [ 열거형 구조 이해 ]\r\n"
				+ "      /*\r\n"
				+ "       * 1. 열거형 enum Direction { EAST, SOUTH, WEST, NORTH }\r\n"
				+ "       * 2. 컴파일러가  클래스 변환\r\n"
				+ "       *    class Direction extends Enum{\r\n"
				+ "       *       static final Direction EAST = new Direction(\"EAST\");\r\n"
				+ "       *       static final Direction SOUTH = new Direction(\"SOUTH\");\r\n"
				+ "       *       static final Direction WEST = new Direction(\"WEST\");\r\n"
				+ "       *       static final Direction NORTH = new Direction(\"NORTH\");\r\n"
				+ "       *       \r\n"
				+ "       *       private String name;\r\n"
				+ "       *       public int namename(){\r\n"
				+ "       *         return this.name;\r\n"
				+ "       *       }\r\n"
				+ "       *       private int ordinal\r\n"
				+ "       *       public int ordinal(){\r\n"
				+ "       *         return this.ordinal;\r\n"
				+ "       *       }\r\n"
				+ "       *       private Dirction(String name){\r\n"
				+ "       *          this.name = name;\r\n"
				+ "       *       }\r\n"
				+ "       *    }\r\n"
				+ "       * */\r\n"
				+ "      \r\n"
				+ "      // 열거형   orinal() 메서드에 의해서 열거형 상수를 사용하는데\r\n"
				+ "      //          상수값은 0,1,2,3  순서를 반환.\r\n"
				+ "      // 내가 원하는 정수값을 설정해서 사용할 수 있다. \r\n"
				+ "      Direction [] dirArr = Direction.values();\r\n"
				+ "      for (Direction dir : dirArr) {\r\n"
				+ "         System.out.println(dir.name() +\"/\"+dir.ordinal() +\"/\"\r\n"
				+ "          + dir.getSymbol() + \" / \" + dir.getValue());\r\n"
				+ "      } // foreach\r\n"
				+ "\r\n"
				+ "   } // main\r\n"
				+ "\r\n"
				+ "} // class\r\n"
				+ "\r\n"
				+ "/*\r\n"
				+ "EAST/0/▶ / 100\r\n"
				+ "SOUTH/1/▼ / 200\r\n"
				+ "WEST/2/◀ / 300\r\n"
				+ "NORTH/3/▲ / 400\r\n"
				+ "*/";
		// [문제]
		//source 문자열에서 [21번째 라인의 문자열]을 
		//String line21 변수에 저장한 후에 출력..
		
		/*	String data[] = source.split("\r\n");
			System.out.println(data[20]);
			
			
			try (	StringReader sr = new StringReader(source);
					BufferedReader br = new BufferedReader(sr);
		
					){
				br.readLine() ; //20번
				
			} catch (Exception e) {
				// TODO: handle exception
			}*/
		//[3]
		// String[] -> Stream<String>
		String line21 =Stream.of(source.split("\r\n")).skip(20).findFirst().get(); //Optional<String> 자료형
		System.out.println(line21);
	}

}
