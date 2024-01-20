package days12;

public class Review {
	public static void main(String[] args) {
		int [] m = { 0, 4, 5, 15, 20, 21, 22, 24, 25, 28, 29, 30, 32, 33, 40, 43, 46, 47, 48, 58, 62, 63, 71, 76, 
                86, 91, 94, 99, 111, 116, 128, 135, 137, 139, 142, 145, 146, 150, 151, 160, 161, 166, 168, 
             169, 172, 181, 184, 185, 191, 198 };
		int n =4;
		disfindIndex(findIndex(m,n));
      
	}

	private static void disfindIndex(int m) {
		if (m>=0) {
			System.out.println("찾는 위치는 "+m+"입니다.");
			
		} else {
			System.out.println("찾는 숫자가 없습니다.");
		}
		
	}

	private static int findIndex(int[] m,int n) {
		int top=m.length-1;
		int bottom = 0;
		int middle;
		int count=1;
		while (top>=bottom) {
			System.out.println("실행 횟수"+count++);
			middle = (top+bottom)/2;
			if (m[middle]==n) {
				return middle;
			} 
			else if (m[middle]<n) {
				bottom=middle+1;
			} else if (m[middle]>n) {
				top = middle-1;
			}
			
			
		}
		return -1;
		
	}

}
