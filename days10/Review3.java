package days10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Review3 {
	
	public static void main(String[] args) throws IOException {
		 int j =3;
		 int m [] = new int[j];
		
		
		disArray(appendArray(m));
		
	}

	private static void disArray(int m[]) {
		for (int i = 0; i < m.length; i++) {
			System.out.println("m["+i+"] ="+m[i]);
		}
		
	}

	private static int[] appendArray(int m[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a;
		int index=0;
		char b;

		do {
			
			System.out.print("정수를 입력하세요");
			a= sc.nextInt();
			m[index++]=a;
			if (index==m.length) {
				int temp[] = new int[3+m.length];
				for (int i = 0; i < m.length; i++) {
					temp[i]= m[i];
				}
				m=temp;
			} 
			System.out.print("계속 하시겠습니까? ");
			b =(char)System.in.read();
			System.in.skip(System.in.available());
			
			
		} while (b=='y'||b=='Y');
		System.out.print(Arrays.toString(m));
		return m;
		
		
	}

}
