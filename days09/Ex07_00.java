package days09;

public class Ex07_00 {
	public static void main(String[] args) {
		String rrn = "931101-1074111";
		System.out.println(CheckRRN(rrn));
	}
	public static boolean CheckRRN(String rrn) {
		int [] m = { 2,3,4,5,6,7,0,8,9,2,3,4,5};
		int tot = 0 ;
		for (int i =0 ; i <=12;i ++) {
			tot += (rrn.charAt(i)-48) *m[i];
		}
		int x = (11-tot%11)%10;
		int Last = rrn.charAt(13)-48;
		return x == Last;
	}

}
