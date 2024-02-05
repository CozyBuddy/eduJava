package days16;

//[사원 클래스]
//모든 사원들이 공통적으로 가져야할 멤버(필드,메서드)를 구현한 클래스
public abstract class Employee { // 추상화 클래스의 메서드 부분을 호출하려면 하위 클래스를 만들고 나서 그 하위 클래스로 호출해야함.
	//필드
		private String name;
		private String addr;
		private String tel;
		private String hireDate;
		
		//생성자
		public Employee() {
			System.out.println("Employee 디폴트 생성자 호출됨.");
			
		}

		public Employee(String name, String addr, String tel, String hireDate) {
			this.name = name;
			this.addr = addr;
			this.tel = tel;
			this.hireDate = hireDate;
			System.out.println("Employee 4 생성자 호출됨.");
		}
		//Getter, Setter

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getHireDate() {
			return hireDate;
		}

		public void setHireDate(String hireDate) {
			this.hireDate = hireDate;
		}
		// 사원들의 정보를 출력하는 메서드
		public void disEmpInfo() {
			System.out.printf("사원명 :%s,주소:%s,연락처:%s,입사일자:%s\n",this.name,this.addr,this.tel,this.hireDate);
			
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", addr=" + addr + ", tel=" + tel + ", hireDate=" + hireDate + "]";
		}

		/*@Override
		public String toString() {
			
			return String.format("사원명 :%s,주소:%s,연락처:%s,입사일자:%s\n",this.name,this.addr,this.tel,this.hireDate);
			// String.format은 문자열을 반환할때 출력말고 사용.
		}*/
		// 추상 메서드 ( 가상(Virtual) 메서드)
		/*public int getPay() {
			return 0;
		}*/
		
		//{}몸체는 상속받는 클래스에서 재정의해서 
		//사용하면 되기에 선언만 하면됨.
		public abstract int getPay();
		
		
		
		
}
