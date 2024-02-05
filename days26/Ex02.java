package days26;

import java.io.File;
import java.io.IOException;

/**
 * @author user
 * @date 2024. 2. 5. 오전 11:51:10
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) throws IOException {
		//File 클래스
		// 파일 + 디렉토리
		 String pathname = ".\\days26\\Ex01.java";
		 File f = new File(pathname);
		 System.out.println(f.getParent());
		 System.out.println(f.getParentFile());
		 System.out.println(f.getPath());
		 System.out.println(f.getAbsolutePath());
		 System.out.println(f.getCanonicalPath());
		 System.out.println(f.isFile());
		 System.out.println(f.isDirectory()); 
		 System.out.println(f.length());
		 System.out.println(f.exists());
		 
		 //OS에서 사용하는 경로 구분자 ;
		 System.out.println(f.pathSeparator);
		 //OS에서 사용하는 이름 구분자 \
		 System.out.println(f.separator);
		 
		 //전체 경로 속에서 파일이름.확장자
		 String fileName = f.getName();
		 System.out.println(fileName);
		 //파일명만
		 int pos = fileName.indexOf(".");
		 System.out.println(fileName.substring(0,pos));
		 //확장자만 
		 System.out.println(fileName.substring(pos));
		 
	}

}
