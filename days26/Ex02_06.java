package days26;

import java.io.File;

public class Ex02_06 {
	public static void main(String[] args) {
		// days26
		// 	ㄴ temp
		// 		ㄴ a.txt
		// 		ㄴ b.txt
		// 		   ㄴ subTemp
		// 		        ㄴ c.txt
		// 		        ㄴ d.txt
		
		String pathname = ".\\src\\days26\\temp";
		//solution();
		File p = new File(pathname);
		if (p.exists()) {
			//System.out.println(p.delete()); // delete() 는 하위 디렉토리가 없어야 삭제 가능.
			directoryDelete(p);
			
		}
		System.out.println("end");
	
	}
	 private static void directoryDelete( File f ) {
	      // f 삭제되지 않았을 경우 while 반복
	      while (  !f.delete() ) {  // true, false
	         
	          File[] list =   f.listFiles();
	          for (int i = 0; i < list.length; i++) {   
	             if (list[i].delete()) {
	               System.out.printf("%s  삭제 완료!!!\n", list[i] );
	            } else {
	               directoryDelete( list[i] );
	            } // if
	          } //
	         
	      } // while
	   }

}
