package days10;

public class Ex01_02_01 {
	public static void main(String[] args) {
		int n =125;
		//int index = binaryArr.length -1;
		int remainder ,share;
		
		StringBuilder sb = new StringBuilder();
		String hex ="0123456789ABCDEF";
		while (n!=0) {
			share =n/16;
			remainder = n%16;
			sb.append(hex.charAt(remainder));
			n=share;
		}
		System.out.println(sb);
		/*
		 * System.out.println(strResult); String reverseStrResult = ""; for (int i = 0;
		 * i < strResult.length(); i++) { reverseStrResult+=
		 * strResult.charAt(strResult.length() -1 -i);
		 * 
		 * } System.out.println(reverseStrResult);
		 */
	}

}
