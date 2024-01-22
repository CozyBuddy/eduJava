package days15;

public class Person {
	//field
	private String name;
	private int age;
	private boolean gender; 
	
	//constructor
	public Person(){
		
	}
	public Person(String name,int age) {
		this(name); // this() 메서드는 항상 맨 첫줄에 와야함.
		//this.name = name;
		this.age = age;//The assignment to variable age has no effect // 같은 명칭을 피하기 위해서 this를 사용
	}
	public Person(String name) {
		this.name = name; //50개 필드 초기화
		}
	//getter, setter 
	public void setAge(int age) {
	      if (age >= 0 && age <= 125) {
	         this.age = age;         
	      } else {
	         System.out.println("나이의 범위가 벗어남.");
	      }
	}
	public int getAge() {
		return age;
	}
	public void disPerson() {
		System.out.printf("이름 : %s , 나이 : %d",this.name,this.age);
		
	}
	
	
	
	
	/*int age = 300;
	if (age >= 0 && age <= 300) {
	   p1.age = age;         
	} else {
	   System.out.println("나이의 범위가 벗어났다.");
	}*/
	
		
	
		
	

}
