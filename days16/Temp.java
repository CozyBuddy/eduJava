package days16;

//임시직 사원 
public class Temp extends Employee{
	// 필드 - name ,addr,tel,hiredate
	// 메서드 - disEmpInfo(),@toString() , getter,setter
	private int days; // 근무 일수
	private int payOfDay ;// 하루 일당
	
	public Temp() {
		super();
		System.out.println("Temp 디폴트 생성자 호출");
	}

	public Temp(String name, String addr, String tel, String hireDate, int days, int payOfDay) {
		super(name, addr, tel, hireDate);
		this.days = days;
		this.payOfDay = payOfDay;
		System.out.println("Temp 6 디폴트 생성자 호출");
	}
	@Override
	public int getPay() {
		return this.days * this.payOfDay;
	}
	//사원들의 정보를 출력하는 메서드

	@Override
	public void disEmpInfo() {
		System.out.printf("사원명 :%s,주소:%s,연락처:%s,입사일자:%s ,근무일수 : %d, 하루일당 : %d \n",this.getName(),this.getAddr(),
				this.getTel(),this.getHireDate(),this.days,this.payOfDay);
	}
	
	
	

}
