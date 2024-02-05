package days05;

/**
 * @author user
 * @date 2024. 1. 5. 오후 4:26:01
 * @subject if,switch,for,while,do~while
 * @contents break
 * 
 * 			 [for each 문]
 */
public class Ex08 {
	public static void main(String[] args) {
		int m[] = new int [10];
	
		// m 배열을 출력하는 코딩
		
		
	    for (int i = 0; i < m.length; i++) {
	    	m[i] = (int)(Math.random()*101);
		 System.out.printf("[%d]",m[i]);
		
		}
	    // for (배열의 자료형 변수명 : 배열 또는 컬렉션) { // 무작위로 m에있는 값들을 추출
			for (int n : m) {
				System.out.println(n);	
			}
		}

	}


