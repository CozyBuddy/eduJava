package days05;

public class Ex03 {
	public static void main(String[] args) {
		//int currentpage = 1 ;
		int numberperpage = 10 ;
		//where no between start and end 
		int start= 1 , end = 10 ;
		for (int currentpage = 1; currentpage < 5; currentpage++) {
			start = (currentpage-1)*(numberperpage) +1;
			end = start + numberperpage-1;
			System.out.printf("currentpage = %d no between %d and % d\n", currentpage,start,end);
		}
	}

}
