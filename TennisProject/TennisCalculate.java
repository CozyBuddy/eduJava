package TennisProject;

import days26.Whowin;

public class TennisCalculate {
	
	public static void main(String[] args) {
		String a = "1팀";
		String b = "2팀";
		int c = 0;
		int d = 0;
		Whowin ww = new Whowin(a, b);
		System.out.println(ww.getWinteam());
	}

}

