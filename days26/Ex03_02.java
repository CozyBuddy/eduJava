package days26;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author user
 * @date 2024. 2. 5. 오후 3:26:11
 * @subject
 * @contents
 */
public class Ex03_02 {
	public static void main(String[] args) {
		 String name = ".\\src\\days26\\userInfo.txt";
		 try (FileInputStream fis = new FileInputStream(name);
				 ObjectInputStream ois = new ObjectInputStream(fis);){
			 UserInfo u1 = (UserInfo) ois.readObject();
			 UserInfo u2 = (UserInfo) ois.readObject();
			 ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois.readObject();
			 System.out.println(u1);
			 System.out.println(u1);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
/*class UserInfo implements Serializable{
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
	
	

}*/
	
