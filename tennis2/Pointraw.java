package tennis2;


import java.util.ArrayList;

public abstract class Pointraw {
	public static String name1 ;
	public static String name2 ;
	public static int count = 0;
	public static int count2 = 0;
	public static ArrayList<Integer> count3 = new ArrayList<>();
	public static int pointCount []  = new int[10];
	public static int point []  = new int[10];
	public static int games []  = new int[10];
	
	public static int sets []  = new int[10];
	public static ArrayList<Integer> alpoint  = new ArrayList(); //누적된 득점 포인트 , 번갈아가며 0인덱스에는 1팀의 누적득점포인트
	/*public static ArrayList<Integer> algames = new ArrayList();
	public static ArrayList<Integer> alsets  = new ArrayList();*/
	
}
