package days06;

/**
 * @author user
 * @date 2024. 1. 8. 오전 10:35:30
 * @subject
 * @contents
 */
public class Ex01_04 {
	public static void main(String[] args) {
		char one = '$';
		String strCheck = "#@$!";
		
		String regex = "[#@$!]"; // [0-9] == [0123456789] -> 0부터 9까지 체크 {1, 3} 
		// [A-Za-z0-9]
		if ((String.valueOf(one)).matches(regex)) {
			System.out.println("특수문자 O");
			
		} else {
			System.out.println("특수문자 X");

		}
				
	}
}
// String regex = [!@#%] ; 
//if (one+" ").matches(regex) {
}




