
public class RRn {
	public static void main(String[] args) {
	    //X=(11−(2A+3B+4C+5D+6E+7F+8G+9H+2I+3J+4K+5L)mod11)mod10
        String rrn = "931101-1074112";
        int rrnarr [] = new int[14];
        int rrnarr2 [] = { 2,3,4,5,6,7,0,8,9,2,3,4,5};
        int a = 0;
        int b = 0;
        int x=0;
        for (int i = 0; i <= 13; i++) {
            rrnarr[i] = (int)rrn.charAt(i)-48;
        
        }
        for (int i = 0; i < rrnarr2.length; i++) {
			x +=rrnarr[i]*rrnarr2[i];
		}
        b =(11-x%11)%10;
        if (b==rrnarr[13]){
            System.out.println("유효한 주민번호");
        } else {
            System.out.println("유효하지 않은 주민번호");
        }
    }





}
