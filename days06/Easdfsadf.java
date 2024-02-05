package days06;

public class Easdfsadf {
	public static void main(String[] args) {
	    //대,소문자 출력 for문
	    // 한 라인에 10개씩 출력(추가)
	    for (int i = 'A',count=1; i < 'z'; i++) {
	        //if (i>'Z'&&i<'a') continue;
	        if (Character.isAlphabetic(i)) {
	            if (count%10==1) {
	            System.out.printf("%d.%c(%03d)",count/10+1,(char)i,i);
	            }
	            count++;
	        } else if (count%10==0) {
	        	System.out.printf("%c(%03d)",(char)i,i);
	        	System.out.println();
	            count++;
	        } else {
	        	System.out.printf("%c(%03d)",(char)i,i);
	        	count++;
	        }
	    }
	}
}
/*
public static void main(String[] args) {
    //대,소문자 출력 for문
    // 한 라인에 10개씩 출력(추가)
    for (int i = 'A',count=1; i < 'z'; i++) {
        //if (i>'Z'&&i<'a') continue;
        if (Character.isAlphabetic(i)) {
            if (count%10==1)
            System.out.printf("%d.%c(%03d)\n",count/10+1,(char)i,i);
            count++;
        } else {
            System.out.printf("%c(%03d)",(char)i,i);
            count++;
        }
        if (count%10==1) System.out.println();
    }
}
}
*/





