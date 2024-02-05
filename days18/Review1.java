package days18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.print.PrintException;

public class Review1 {
	public static void main(String[] args) {
		int a[] = new int[100];
		String b[] = new String[15];
		int i =0;
		String readPath = "C:\\Users\\user\\git\\MyJava\\javaPro\\src\\days18\\ClassName.txt";
		try (FileReader fr = new FileReader(readPath);
				BufferedReader br = new BufferedReader(fr);
				){
				String line;
			while ((line=br.readLine())!=null) {
				b[i]=line;
				System.out.println(b[i++]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Person ps = new Person("111","rrr");
		ps.getClass();
		Class e = Person.class;
		try {
			e.forName("Person");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
