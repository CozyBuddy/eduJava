package days10;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 1. 12. 오후 2:42:05
 * @subject 배열 단점 파악 - > 컬렉션(Collection)
 * @contents
 */
public class Ex04 {
	public static int index = 0; // 전역 변수
	static Scanner sc = new Scanner(System.in);
	static char con = 'y';
	public static int m[] = new int[2];
	public static void main(String[] args) throws IOException {
		String menus[] = {"추가","수정","삭제","검색","조회","종료"};
		int selectNumber;// 선택된 메뉴를 저장하는 변수 선언.
		while (true) {
			dispMenus(menus);
			selectNumber = selectMenus();
			processMenu(selectNumber);
		}
	}
	

	private static void processMenu(int selectNumber) throws IOException {
		switch (selectNumber) {
		case 1:
			add();
			break;
		case 2:
			edit();
			break;
		case 3:
			remove();
			break;
		case 4:
			search();
			break;
		case 5: // 배열의 모든 요소(목록)를 출력
			list();
			break;
		case 6:	// 프로그램 종료
			exit();
			break;
		}
		// 바로 메뉴 출력으로 가지 못하게 일시정지.
		stop();

	}
	private static void stop() {
		System.out.println(">엔터키를 누르면 계속합니다.");
		try {
			System.in.read(); //13
			System.in.skip(System.in.available()); //10
		} catch (IOException e) {
			e.printStackTrace();
		}// 엔터 13,10
		System.out.println();
		
	}

	

	private static void search() {
		System.out.println("[4.검색]");
		
	}

	private static void remove() {
		System.out.println("[3.삭제]");
		
		
	}

	private static void edit() {
		System.out.println("[2.수정]");
		
	}

	private static void add() throws IOException {
		System.out.println("[1.추가]");
		do {
			if (m.length == index) {
				increaseArray(); // 함수에 있는 m은 지역변수 m , 왼쪽에 있는 m은 전역변수
			}
			System.out.print("정수입력 >");
		    int n = sc.nextInt();
		    m[index++] = n;
		    System.out.print("계속 입력하시겠습니까?");
		    con = (char)System.in.read();
		    System.in.skip(System.in.available());
		    
		} while (Character.toUpperCase(con)=='Y');
		
	}
	private static void list() {
		System.out.println("[5.조회]");
		if (index==0) {
			System.out.println("추가된 배열값이 없습니다.");
			return ;
		} 
		for (int i = 0; i < index ; i++) {
			System.out.printf("m[%d]=%d ",i ,m[i]);
			
		}
		System.out.println();
		
	}
	
	private static void increaseArray() {
			int [] temp = new int [m.length +3];
			for (int i = 0; i < m.length; i++) {
				temp[i]=m[i];
			}
			m = temp; // 배열 끼리 대입할때는 주소값을 대입시킨다는 뜻.
			
		}
		
	


	// 6.종료 - 프로그램을 종료하는 함수
	private static void exit() {
		System.out.println("\n\t\t 프로그램을 종료합니다.");
		System.exit(0); // int값 지금은 의미 없음.
	}

	//1~6메뉴를 선택해서 반환하는 함수
	private static int selectMenus() {
		String inputData;
		do {
			System.out.print("메뉴를 선택하세요>");
			inputData = sc.next();
		} while (!inputData.matches("[1-6]"));
		return Integer.parseInt(inputData);
	}

	private static void dispMenus(String[] menus) {
		System.out.println("\t\t\t메뉴");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("[%d]%s\t",i+1,menus[i]);
		}
		System.out.println();

	}


}
