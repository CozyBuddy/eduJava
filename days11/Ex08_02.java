package days11;

import java.util.Arrays;

/**
 * @author user
 * @date 2024. 1. 15. 오후 2:50:26
 * @subject
 * @contents
 */
public class Ex08_02 {
	public static void main(String[] args) {
		// 순차 검색 함수 sequence Search
		int n = 71;
		int [] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };
		
		int beginIndex =0 ,foundIndex;
		
		while ((foundIndex=indexOf(m,n,beginIndex))!=-1) {
			System.out.println(foundIndex);
			beginIndex = foundIndex +1;
		}
			
		}
	public static int indexOf(int m[],int n,int beginIndex) {
		for (int i = beginIndex; i < m.length; i++) {
			if (m[i]==n) return 1;
				
		}
		return -1;

	}
}
