package days26;

import java.io.File;

/**
 * @author user
 * @date 2024. 2. 5. 오후 12:19:26
 * @subject
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args) {
		String currentDirectory = System.getProperty("user.dir");
		File p = new File(currentDirectory);
		System.out.println(p.isDirectory()); // true
		System.out.println(p.isFile());  //false
		//String list [] =p.list(); //문자 배열로 반환
		
		/*  for (int i = 0; i < list.length; i++) {
			  //System.out.println(list[i]); 
			  File c = new File(p, list[i]);
		  System.out.printf("%s\t%s\t%s\n",c.isFile()?" 파일":"폴더",c.getName(),c.length()
		  ); }
		 */
		System.out.println("-".repeat(50));
		File list [] = p.listFiles(); //파일 배열로반환
		for (int i = 0; i < list.length; i++) {
			System.out.printf("%s\t%s\t%s\n",list[i].isFile()?" 파일":"폴더",list[i].getName(),list[i].length());

		}
	}

}
