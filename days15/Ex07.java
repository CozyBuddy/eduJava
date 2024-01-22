package days15;

/**
 * @author user
 * @date 2024. 1. 19. 오후 3:04:45
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		// 인스턴스변수 ->인스턴스를 생성할때마다 달라지는 변수
		// 클래스 변수 -> 클래스 내에서 하나만 만들꺼면 static (객체를 생성하지 않아도 메모리에 저장되어있어서 클래스명.~~ 로 사용가능),
		// final 단독으로 사용하면 인스턴스가 각각 객체별로 생성됨.
		//[static 키워드]
		// 필드,메서드,클래스 앞에 사용 가능.
		// 예) 반 학생 ->기업은행 ->보통 예금 개설
		// 1. 저축 클래스 선언 : Save 클래스 선언.
		// 2. 
		/*
		 * Save s1 = new Save(" ",1000,0.04)
		 * Save s2 = new Save(" ",500,0.04)
		 * Save s3 = new Save(" ",1000,0.04)
		 * Save s4 = new Save(" ",1000,0.04)
		 */

		/* 클래스 배열 사용
		 Save sArr = new Save[5];
		 sArr[0]=new Save("1 ",1000,0.04);
		 sArr[1]=new Save("2 ",1000,0.04);
		 sArr[2]=new Save("3 ",1000,0.04);
		 sArr[3]=new Save("4 ",1000,0.04);
		 * 
		 * 
		 */
		Save sArr[] = {new Save("1 ",1000,0.04), //
				new Save("2 ",1000,0.04),
				new Save("3 ",1000,0.04),
				new Save("4 ",1000,0.04)
				};
		// Save.setRate(0.07);
		sArr[1].setRate(0.09); // 하나만 이자율을 바꿔도 static 변수이기 때문에 다른 것도 다 바뀜.
		for (int i = 0; i < sArr.length; i++) {
			sArr[i].disSave();
		}
		
		

		//클래스명.클래스변수
		//Save.rate = 0.08;
		//클래스명.클래스(static)메서드() //static 메서드 안에서는 객체가 생성안하기 때문에 this로 접근 불가.
		Save.setRate(0.08);

	}

}
