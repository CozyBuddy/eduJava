package days25;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Review3 {
	public static void main(String[] args) {
		String parent = ".\\src\\days25";
		String b =null;
		char con = 0;
		try(Scanner sc = new Scanner(System.in);){
			System.out.print("파일명을 입력하라");
			String child = sc.nextLine();
			child = child+".txt";
			File f = new File(parent, child);
			try (FileWriter fw = new FileWriter(f);){
				do {
					System.out.print("문자를입력하라");
					b= sc.nextLine();
					fw.append(b);
					fw.flush();
					
					System.out.print("계속입력하려면 Y를 입력하라");
					con = sc.nextLine().charAt(0);
					
					
				} while (Character.toUpperCase(con)=='Y');
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
