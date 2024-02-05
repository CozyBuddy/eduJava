package days16;
// 영업직 사원 (최종) 클래스


public final class salesMan extends Regular {
	// s - R - E - O 상속 
	//상속 필드 -name,addr,tel,hiredate, basePay;
	//생성자 상속 x
	//상속 메서드  - @disEmpInfo(),@toString(), getPay()
	private int sales; //판매량
	private int comm; // 커미션
	
	public salesMan() {
		super(); // Regular 클래스의 디폴트 생성자 호출
		System.out.println("salesMan 디폴드 생성자 호출");
	}

	public salesMan(String name, String addr, String tel, String hireDate, int sales, int comm, int basepay) {
		super(name, addr, tel, hireDate,basepay);
		this.sales = sales;
		this.comm = comm;
		System.out.println("salesMan 4디폴드 생성자 호출");
	}

	@Override
	public void disEmpInfo() {
		System.out.printf("사원명 :%s,주소:%s,연락처:%s,입사일자:%s , 기본급 : %d\n",this.getName(),
				this.getAddr(),this.getTel(),this.getHireDate(),this.getBasePay(),this.sales,this.comm);
	}

	@Override
	public int getPay() {
		return super.getPay() + this.sales*this.comm;
	}
	//class Child extends salesMan {} The type Child cannot subclass the final class salesMan 최종클래스 설명

	
	

}
