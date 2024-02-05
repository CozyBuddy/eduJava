package days18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 1. 24. 오후 3:18:48
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		//String directory = "C:\\Users\\user\\git\\MyJava\\javaPro\\src\\days18";
		String key = "user.dir"; //javaPro 까지 
		String userDir = System.getProperty(key);
		System.out.println(userDir);
		String readPath = userDir.concat("\\src\\days18\\className.txt");
		String writePath = userDir.concat("\\src\\days18\\className1.html");
		System.out.println(readPath);
		String fileName = "className";
		
		String names[] = new String[15];
		String name ;
		int index = 0;
		try(FileReader fr = new FileReader(readPath);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(writePath)) {
			while ((name =br.readLine())!=null) {
				names[index++] = name;
			}
			String namesjoin = "<ol><li>"+String.join("</li><li>", names)+"</li>";
			System.out.println(namesjoin);
			
			fw.write(namesjoin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
		/*try {
			FileReader fr = new FileReader(directory+"\\"+fileName);
			System.out.println(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
	}

}
