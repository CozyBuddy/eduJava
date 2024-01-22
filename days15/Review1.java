package days15;

import java.util.Arrays;

public class Review1 {
	
public static void main(String[] args) {
	String n = "KeNik";
	String m = "kknie";
	n=n.toUpperCase();
	m=m.toUpperCase();
	
	char nArr[] = n.toCharArray();
	Arrays.sort(nArr);
	System.out.println(Arrays.toString(nArr));
	
	char mArr[] = m.toCharArray();
	Arrays.sort(mArr);
	System.out.println(Arrays.toString(mArr));
	
	n=String.valueOf(nArr);
	m=String.valueOf(mArr);
	System.out.println(n.equals(m));
}

private static boolean isright(boolean[] a) {
	for (int i = 0; i < a.length; i++) {
		if (a[i]==true) {
			continue;
		} else {
			return false;
		}
	}
	return true;
	
}

private static boolean[] issame(String n, String m,boolean a[]) {
		for (int i = 0; i < n.length(); i++) {
			for (int j = 0; j < m.length(); j++) {
				if (Character.toUpperCase(n.charAt(i))==Character.toUpperCase(m.charAt(j))) {
					a[i] = true;
				}
			}
			
		}
		
		return a;
		
	
	
}

}
