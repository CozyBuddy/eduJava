package Programmers;

import java.util.ArrayList;

public class PCCP2 {
	ArrayList<Integer> al = new ArrayList<Integer>();
	int result = 0 ;
	int i = 0;
	int j = 0 ;
	
		    public int solution(int[][] land) {
		    
					if (land[i][j]==1) {
							result += 1;
						
						} else {
						 solution(land[i][j+1]);
					
				}
		    
		}
	

}
