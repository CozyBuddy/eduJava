package days07;

public class Grade {
	public static String grade(int n) {
		if (n<=100 && n>=90) {
			return "수";

		} else if(n<=89 && n>=80) {
			return "우";


		} else if(n<=79 && n>=70) {
			return "미";
		}else if(n<=69 && n>=60) {
			return "양";
		}else  {
			return "가";

		}

	}
}
