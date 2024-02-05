package days26;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 5. 오후 3:11:54
 * @subject
 * @contents
 */
public class Ex03 {
	
	public static void main(String[] args) {
		/*
		 * 1.직렬화
		 * 객체를 스트림으로 만드는 것.
		 * 2.역직렬화
		 *스트림을 객체로 만드는 것.
		 *
		 *3. 객체를 직렬화해서 읽기/쓰기를 할 수 있는 바이트 스트림.
		 *  ObjectInputStream
		 *   ObjectOutputStream //  바이트스트림들
		 *   
		 */ String name = ".\\src\\days26\\userInfo.txt";
		 try (FileOutputStream fos = new FileOutputStream(name);
				 ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(u1);// java.io.NotSerializableException:
			oos.writeObject(u2);
			oos.writeObject(list);
			oos.flush();
			System.out.println("객체를 직렬화를 통해 파일로 저장완료.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
class UserInfo implements Serializable{
	private static final long serialVersionUID = -4461614692108077735L;
	String name;
	String password;
	int age ;
	
	public UserInfo() {
	this("Unknown","1111",0);
	}

	public UserInfo(String name, String password, int age) {
		
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		 
		 
		 
		return "UserInfo [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
	

}
		 UserInfo u1 = new UserInfo("김진영","1234",28);
		 UserInfo u2 = new UserInfo("신슬기","4321",25);
		 
		 ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		 list.add(u1);
		 list.add(u2);
		 String name = ".\\src\\days26\\userInfo.txt";
		 try (FileOutputStream fos = new FileOutputStream(name);
				 ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(u1);// java.io.NotSerializableException:
			oos.writeObject(u2);
			oos.writeObject(list);
			oos.flush();
			System.out.println("객체를 직렬화를 통해 파일로 저장완료.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
class UserInfo implements Serializable{
	private static final long serialVersionUID = -4461614692108077735L;
	String name;
	transient String password; //객체를 직렬화 할때 미포함할 항목을 지정할때 transient라고 씀.
	int age ;
	
	public UserInfo() {
	this("Unknown","1111",0);
	}

	public UserInfo(String name, String password, int age) {
		
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
	

}

