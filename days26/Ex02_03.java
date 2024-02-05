package days26;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author user
 * @date 2024. 2. 5. 오후 12:29:19
 * @subject
 * @contents
 */
public class Ex02_03 {
	public static void main(String[] args) {
		String pathname = ".\\days26";
		// days26 폴더 안에 있는 자바파일(.java)만 출력
		File f = new File(pathname);
		File list[] =f.listFiles((d,n)->n.endsWith(".dat"));
		
		for (File c: list) {
			System.out.println(c.getName());
		}
		/*
		 * File list[] = f.listFiles(); for (int i = 0; i < list.length; i++) { if
		 * (list[i].isFile()) { String fileName = list[i].getName(); int pos
		 * =fileName.indexOf("."); String ext = fileName.substring(pos); if
		 * (ext.equals(".dat")) { System.out.println(fileName); } } }
		 */
	}

}
