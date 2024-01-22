package days16;

//[사원 클래스]
//모든 사원들이 공통적으로 가져야할 멤버(필드,메서드)를 구현한 클래스
public class Employee {
	//필드
		private String name;
		private String addr;
		private int tel;
		private String hireDate;
		
		//생성자
		public Employee() {
			System.out.println("Employee 디폴트 생성자 호출됨.");
			
		}

		public Employee(String name, String addr, int tel, String hireDate) {
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

		public int getTel() {
			return tel;
		}

		public void setTel(int tel) {
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
			System.out.printf("사원명 :%s,주소:%s,연락처:%s,입사일자:%s",this.name,this.addr,this.tel,this.hireDate);
			
		}
		
		
}
