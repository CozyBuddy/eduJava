package days10;

public class Ex01_02 {
	public static void main(String[] args) {
		int n =125;
		//int index = binaryArr.length -1;
		int remainder ,share;
		String strHex ="";
		while (n!=0) {
			share =n/16;
			remainder = n%16;
			switch (remainder) {
			case 10:
				remainder = 'A'; break;
			case 11:
				remainder = 'B'; break;
			case 12:
				remainder = 'C'; break;
			case 13:
				remainder = 'D'; break;
			case 14:
				remainder = 'E'; break;
			case 15:
				remainder = 'F'; break;
			default:
				remainder = remainder+'0'; // 0의 아스키코드 값은 48
				break;
			}
			strHex += "["+Character.toString(remainder)+"]" ;
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
