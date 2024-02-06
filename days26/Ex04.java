package days26;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex04 {
	public static void main(String[] args) {
		// [직렬화] 객체 -> 스트림
		// [역직렬화] 스트림 -> 객체
		// 객체를 직렬화해서 읽기/쓰기 할 수 있는 바이트 스트림
		// ObjectInputStream, ObjectOutputStream
		// - 클래스를 직렬화할 수 있으려면 Serializable 인터페이스를 implements하면 됨.
		
		// 상속관계가 있을 경우의 직렬화
		// 자식은 Serializable 인터페이스를 implements 하지 않은 경우
		// 상관없이 자동으로 직렬화됨.
		// 2)경우
		// 부모 : implements Serializable X
		// 자식 : implements Serializalbe O
		// 부모 멤버는 직렬화 대상에서 제외.
		
		//3) 2상황에서 부모 멤버를 직접 직렬화 시키는 방법.
		
		Child c = new Child();
		c.name = "홍길동";
		c.age = 20;
		
		String pathName = ".\\src\\days26\\Child.ser";
		
		// 객체를 직렬화해서 oss에 파일 저장 완료.
		try (FileOutputStream out = new FileOutputStream(pathName);
				ObjectOutputStream oss = new ObjectOutputStream(out)){
			oss.writeObject(c);
			oss.flush();
		} catch (Exception e) {
			e.printStackTrace();// 객체를
		}
	}

}

/*class Parent implements Serializable {
	String name;
	
}
class Child extends Parent {
	int age ;
	
}*/
class Parent  {
	String name;
	
}
class Child extends Parent implements Serializable {
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();// age가 들어감
		out.writeUTF(name); //개발자 직접추가
		
		
	}
	int age ;
	private void readObject(ObjectInputStream out) throws IOException{
		name = in.readUTF();// age가 들어감
		in.defaultReadObject(); //개발자 직접추가
		
		
	}
	
}