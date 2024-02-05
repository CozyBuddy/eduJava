package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 4:31:40
 * @subject  문자열을 변경(수정)할 때는 String 클래스보다 StringBuffer,StringBuilder를 사용해야하는지?
 * @contents
 */
public class Ex06_03 {
	public static void main(String[] args) {
		testString();
		testStringBuilder();
	}

	private static void testStringBuilder() {
		long start = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 500000; i++) {
			sb.append("a");
		}
		long end = System.nanoTime();
		System.out.printf("StringBuilder 처리 시간 : %d ns\n",(end-start));
		
	}

	private static void testString() {
		long start = System.nanoTime();
		String s = new String();
		for (int i = 0; i < 500000; i++) {
			s+="a";
		}
		long end = System.nanoTime();
		System.out.printf("String 처리 시간 : %d ns\n",(end-start));
		
	}

}
