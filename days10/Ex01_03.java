package days10;

public class Ex01_03 {
	public static void main(String[] args) {
		int n =125;
		//int index = binaryArr.length -1;
		int remainder ,share;
		String strHex ="";
		char ch [] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		while (n!=0) {
			share =n/16;
			remainder = n%16;
			strHex += ch[remainder]+strHex ; // 7d나와야함
			n=share;
			
		}
		System.out.println(strHex);
		/*
		 * System.out.println(strResult); String reverseStrResult = ""; for (int i = 0;
		 * i < strResult.length(); i++) { reverseStrResult+=
		 * strResult.charAt(strResult.length() -1 -i);
		 * 
		 * } System.out.println(reverseStrResult);
		 */
	}

}
