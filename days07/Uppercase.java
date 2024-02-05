package days07;

public class Uppercase {
	public static char upper(char n) {
		if (Character.isLowerCase(n)) {
			return Character.toUpperCase(n);
		}
		return n; // 전화 ,알리 신발 
		
	}

}
