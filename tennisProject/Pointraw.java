package tennisProject;


import java.util.ArrayList;

public abstract class Pointraw {
	//public static String name1 ;
	//public static String name2 ; //합치면서 쓸모없어진 변수값들
	public static int count = 0; //현재 세트수
	public static int count2 = 0; // 총 게임수
	public static ArrayList<Integer> count3 = new ArrayList<>(); //1게임이 끝날 동안의 주고받은 포인트 횟수를 기록
	public static int pointCount []  = new int[10];
	public static int point []  = new int[10]; //누적할 포인트 변수
	public static int games []  = new int[10]; // 누적할 게임횟수 (출력용 )
	
	public static int sets []  = new int[10]; // 각 배열을 구분해서 이긴 세트에 표시 ( 1로 카운트함)
	public static ArrayList<Integer> alpoint  = new ArrayList(); //(기록용)누적된 득점 포인트 , 번갈아가며 0인덱스에는 1팀의 누적득점포인트
	/*public static ArrayList<Integer> algames = new ArrayList();
	public static ArrayList<Integer> alsets  = new ArrayList();*/
	
}
