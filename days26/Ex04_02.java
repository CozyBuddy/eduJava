package days26;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex04_02 {
	public static void main(String[] args) {
         String pathName = ".\\src\\days26\\Child.ser";
		
		// 객체를 직렬화해서 oss에 파일 저장 완료.
		try (FileInputStream in = new FileInputStream(pathName);
				ObjectInputStream oss = new ObjectInputStream(in)){
			Child c= (Child) oss.readObject();
			String name = c.name;
			int age = c.age;
			
			System.out.printf("name=%s, age=%d\n",name,age);
		} catch (Exception e) {
			e.printStackTrace();// 객체를
		}
	}

	}


