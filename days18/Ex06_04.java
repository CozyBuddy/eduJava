package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 4:45:11
 * @subject
 * @contents
 */
public class Ex06_04 {
	public static void main(String[] args) {
		 /*
			      문제 설명
			      길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
			      예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

			      제한 조건
			      n은 길이 10,000이하인 자연수입니다.
			      입출력 예
			      n   return
			      3   "수박수"
			      4   "수박수박"
			      */
		int n ;
		solution(50);
		System.out.println(solution(49));
	}
			      
	
/*
	private static StringBuffer solution(int n) {
		StringBuffer a = null;
		StringBuffer b[]= new StringBuffer();
		
		for (int i = 0; i < n/2+n%2; i++) {
			a[i]=b.append("수");
			if (i!=n/2 && i!=n/2+1) {
				a[i]=b.append("박");
			}
		}
		return a;
	}*/
	
	/*private static String solution(int n) {
		// 1<=자연수 <=10000
		String answer = "";
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			if (n%2==0) {
				
			} else {
	
			}
		}
	}*/
		
	public static String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int 몫 = n/2;
		int 나머지 = n%2;
		for (int i = 0; i < 몫; i++) sb.append("수박");
		//sb.append("수박".repeat(몫)); 위에 결과와 일치
		if(나머지==1) sb.append('수');
		
		answer = sb.toString();
		return answer;
	}
	/*
	 * 취업문제) 막대기 자르기  

각각 0이상의 정수를 길이로 하는 N개의 막대기가 있다.

 이 막대기들 중 가장 짧은 막대기의 길이로 모든 막대기를 자르는 것을 [cut operation]이라고 하자.

예를 들어 6개의 막대기가 있고 그 길이가 다음과 같다면 

5 4 4 2 2 8 

이 경우 [Cut Operation]을 한번 수행하면 다음과 같다. 

3 2 2 6

(가장 짧은 길이인 2로 6개의 막대기를 잘라내고 길이가 0이 되버린 2개의 막대기는 버려진다.) 

N개의 막대기와 그 각각의 길이가 주어졌을 때 [Cut Operation]을 모든 막대기가 버려질 때(길이가 0이 될때)까지 반복하고  수행 시 마다 남은 막대기의 수를 출력하는 프로그램을 작성하라. 

입력 
첫줄에 막대기의 수 N을, 다음 줄에 각각의 막대기의 길이를 공백으로 구분해서 입력한다.

출력 
매 줄마다 [Cut Operation]이 수행 되 때 마다 남은 막대기의 수를 출력 

제한 
1 <= N <= 1000
1 <= 막대기의 길이 <= 1000

입력 예제 #1
6
5 4 4 2 2 8
3 2 2 6
1 4
3

출력 예제 #1
6
4
2
1

입력 예제 #2
8
1 2 3 4 3 3 2 1

출력 예제 #2
8
6
4
1 
*/       
	 */
		
	
	
		
	
	

}
