package days26;

import java.util.ArrayList;
import java.util.Vector;

public class Review7 {
	public static void main(String[] args) {
		int n = 2;
		int s = 14;
		Vector<Integer> v = new Vector<Integer>();
		Vector<Integer> result = solution(n,s);
		System.out.println(result);
	}

	static Vector<Integer> solution(int n, int s) {
		if (s<n) {
			Vector<Integer> v = new Vector(); 
			v.add(-1);
			return v;
		}
		int Q = s/n ;
		int R = s%n ;
		Vector<Integer> al = new Vector<Integer>();
		for (int i = 0; i < n; i++) {
			al.add(Q);
		}
		for (int i = n-1; i >=0; i--) {
			if (R>=1) {
				al.set(i, al.get(i)+1);
				R--;
			}
			
		}
		return al;
	    
	}
}
