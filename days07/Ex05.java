package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오후 12:36:33
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {

		//[4]
		boolean sw = false;
		int sum=0;
		for (int i = 1; i <=10 ; i++) {
			sum+=(i%2==0 ? -i:+i);
			System.out.print((sw ?i+"+":i+"-"));
		    sw=!sw;
	}
		System.out.println("="+sum);
}
}
/*	// *** [3] 스위칭 변수를 사용하는 방법. (내일 복습)
		int sum = 0;
		boolean sw = false;
		for (int i = 1; i <= 10; i++) {
			if (sw) {
				System.out.printf("%d+",i);
				sum-=i;

			} else {
				System.out.printf("%d-",i);
				sum+=i;
				sw=!sw;
			}


		}
		System.out.print("="+sum);



	}
}*/
/* if else 방법도 있다는뜻
 * int sum=0;
		for (int i = 1; i <=10 ; i++) {
			sum+=(i%2==0 ? -i:+i);
			System.out.print((i%2==0 ?i+"+":i+"-"));
		}
		System.out.println("="+sum);



	}
}*/
/*	//[순서도] [1]
		// 워크플로 혹은 프로세스를 보여주는 다이어그램의 한 종류
		int sum=0;
		for (int i = 1; i <=10 ; i++) {
			sum+=(i%2==0 ? -i:+i);
			System.out.print((i%2==0 ?i+"+":i+"-"));
		}
		System.out.println("="+sum);
	}
 */


