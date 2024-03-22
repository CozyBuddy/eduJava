package days05;

public class Ex03_02 {
	public static void main(String[] args) {
		int currentpage = 1;
		int numberperpage = 10;
		int numberofpageblock = 10 ;
		
		// [1] 2 3 4 5 6 7 8 9 10 > 
		// 1) 총 게시글 수 ?  153
		// 2) 총 페이지 수 ? 16
		for ( currentpage = 1; currentpage <= 16; currentpage++) {
			int start = (int)currentpage/(numberperpage+1)* numberofpageblock +1;
			int end = start + numberofpageblock-1;
			if (end > 16) {
				end = 16;
			}
			System.out.printf("cureentpage = %d start =%d end %d ",currentpage,start,end);
			if (start != 1 ) {
				System.out.print(" < ");
			}
			for (int i = start; i <= end; i++) {
				if (i==currentpage) {
					System.out.printf("[%d] ", i);
				}
					else 
						{ System.out.printf("%d ", i);
				
				}
			
				
			}
			if (end !=16) { System.out.print(" > ");
				
			}
			System.out.println();
		}
		
		
	} //페이징 블럭

}