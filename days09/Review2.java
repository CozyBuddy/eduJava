package days09;

public class Review2 {
	public static void main(String[] args) {
		int n =125;
		//int index = binaryArr.length -1;
		int reminder ,share;
		String strResult ="";
		while (n!=0) {
			share =n/8;
			reminder = n%8;
			strResult +=reminder ;
			n=share;
			
		}
		System.out.println(strResult);
		String reverseStrResult = "";
		for (int i = 0; i < strResult.length(); i++) {
			reverseStrResult+= strResult.charAt(strResult.length() -1 -i);
			
		}
		System.out.println(reverseStrResult);
	}

}
