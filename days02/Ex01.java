package days02;

public class Ex01 {
	public static void main(String[] args) {	
		String name = "홍길동";
		double height = 185.22;
		System.out.println("이름 : \""+name+"\",키 : "+height+"cm");
		System.out.printf("이름 : \"%s\",키 : %.2fcm%n",name, height);
		//The method printf(String, Object[]) in the type PrintStream is not applicable for the arguments (String, String, double)
		System.out.printf("이름 : \"%s\", 키: %.2fcm%n", name, height);

		

	}



}
