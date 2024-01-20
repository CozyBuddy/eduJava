import java.util.Scanner;

public class PrinterEx {
	public static void main(String[] args) {
		String regex = "^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[#$%@])[0-9A-Za-z@#$%]{8,15}$";
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 입력하세요>");
		String a = sc.nextLine();
		if (a.matches(regex)){
			System.out.println("유효한 비밀번호");
		} else {
			System.out.println("유효하지 않은 비밀번호");
		}
	}


}

