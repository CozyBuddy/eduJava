package days08;

public class _02 {
	public static void main(String[] args) {
		//int year=2024;
		int m[] = {10,20};
		swap(m);
		System.out.println(m[0]+","+m[1]);
	}

	private static void swap(int m[]) {
		int temp = m[0];
		m[0]=m[1];
		m[1]=temp;
	
		
	}

}
