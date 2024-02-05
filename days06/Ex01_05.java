package days06;

public class Ex01_05 {
	/*public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			System.out.print("정수a를 입력하세요");
			int a = sc.nextInt();
			System.out.print("정수b를 입력하세요");
			int b = sc.nextInt();
			System.out.print("정수c를 입력하세요");
			int c = sc.nextInt();
			
			[3]
			// Math 클래스 : 산술적 기능이 구현된 클래스
			// 0.0 <= double MAth.random() <1.0

			int min = Math.min(a, b);
			min = Math.min(min,c);
			
			int max = Math.max(a,b);
			max = Math.max(max,c);


			System.out.println("제일 작은 수 : "+min);
			System.out.println("제일 큰 수 :"+max);

		} */
	// 서울숲 마이가든 편하게 놀러와 손목엔 가볍게 밀러 where 
	public static void main(String[] args) {
		int m[] = new int[10];
		int min=15;
		int max=5;
		for (int i = 0; i < m.length; i++) {
			m[i]= (int)(Math.random()*11+5);
			System.out.println("m["+i+"] : "+m[i]);
			 //0???
			
			min = Math.min(min,m[i]);
			
			max = Math.max(max,m[i]);
			// max = Math.max(max,m[i]);
		 // Math.pow(3,2) ; // 대신 자료형이 double임
		}
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
		

	}
	// 추가문제 ) m 배열의 가장 큰값, 가장 작은값을 구해서 출력
	/*public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("한 문자 입력 ? ");
			String one1 = sc.next();
			char one = one1.charAt(0);
			System.out.println("one : "+one);
			System.out.print("한 문자 입력 ? ");
			String one2 = sc.next();
			one = one2.charAt(0);
			System.out.println("one : "+one);

		}*/
	/*public static void main(String[] args) {
			for (int i = 'A'; i <= 'Z'; i++) {
				if(i%10==4) {
					System.out.printf("%c(%03d)\n",i,i);
				} else {
					System.out.printf("%c(%03d)",i,i);
				}
			}
				for (int i = 'a'; i <= 'z'; i++) {
					if(i%10==0) {
						System.out.printf("%c(%03d)\n",i,i);
					} else {
						System.out.printf("%c(%03d)",i,i);
					}
				}
			}*/
	/*public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("정수 x를 입력하세요>");
			int x = sc.nextInt();
			System.out.print("정수 y를 입력하세요>");
			int y = sc.nextInt();

			int x1 = Math.min(x, y);
			int y1 = Math.max(x,y);
			int sum=0 ;
			if (x1%2==0) {
				for (int i = x1+2; i < y1; i=i+2) {
					 sum +=i;
				}
				System.out.println(sum);

			} else {
				for (int i = x1+1; i < y1; i=i+2) {
					 sum +=i;
			}
				System.out.println(sum);

		}

		}*/
	/*public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("영어 이름을 입력하세요");
			String name = sc.next();
			char c[] = new char[name.length()];
			for (int i = 0; i < c.length; i++) {
				c[i]= name.charAt(i);

			}
			for (char n : c) {
				System.out.print(n);

			}
		}*/

}



