package Programmers;

import java.util.ArrayList;

public class level0 {
	 public int solution(int n) {
		 int a =0;
	        if (n%2==0) {
				for (int i = 2; i <= n; i=i+2) {
					a+=i*i;
				}
				
			} else {
				for (int i = 1; i <= n; i=i+2) {
					a+=i;
				}
			}
	        return a;
	    }
	}