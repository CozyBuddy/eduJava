package days15;

//저축 관련 필드,메서드 구현 클래스
public class Save {

	//필드
	private String name;// 예금주
	private int money;//예금액
	private static double rate=0.04;//예금 이자율

	//생성자
	public Save() {

	}
	public Save(String name ,int money,double rate) {
		this.name = name;
		this.money = money;
		this.rate = rate;
	}
	


	// getter , setter 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) { //static 메서등
		Save.rate = rate;
	}
	//메서드
	public void disSave() {
		System.out.printf("예금주 :%s ,예금액 :%d ,이자율 : %.2f\n",this.name,this.money,this.rate);

	}


}
