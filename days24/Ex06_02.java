package days24;

/**
 * @author user
 * @date 2024. 2. 1. 오후 2:17:15
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		/*
		 * 1. 제네릭 타입은 클래스, 메서드에 선언할 수 있다.
		 * 		ㄴ제네릭 클래스 
		 * 		ㄴ제네릭 메서드
		 * 		
		 */
		
		/*	Box box1 = new Box();
			//box1.setItem(100);
			//box1.setItem("홍길동");
			box1.setItem("홍길동");
			System.out.println(box1.getItem());*/
		Box<MemberVO> box = new Box();
		box.setItem(new MemberVO("솔로지옥","김진영"));
		MemberVO vo = box.getItem();
		System.out.println(vo);
		/*
		 * 1. Box<T> - 제네릭 클래스 , "T의 Box"
		 * 2. 	T -> 타입 변수 또는 타입 매개변수
		 * 3. 타입변수 - T, E,K,V 등등 아무거나 써도 됨.
		 * 			T : type 줄임말 E : element K : Key V: value
		 * 4.Box - 원시 타입 (Raw Type)
		 */
	}

}
//제네릭 클래스
class Box<T>{ //
	T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
}
/*class Box{
	int item;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
	
}*/
/*class Box{
	double item;

	public double getItem() {
		return item;
	}

	public void setItem(double item) {
		this.item = item;
	}
	
}*/
/*class Box{
	String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}*/

/*class Box{
	Object item;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
	
}*/
