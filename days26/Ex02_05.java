package days26;

import java.io.File;

/**
 * @author user
 * @date 2024. 2. 5. 오후 2:15:28
 * @subject
 * @contents
 */
public class Ex02_05 {
	public static void main(String[] args) {
		String pathName = ".\\src\\days26";
		//days26 폴더 안에 upload 폴더 생성.
		File upload = new File(pathName,"upload");
		if (!upload.exists()) {
			System.out.println(upload.mkdir()); //mkdir 디렉토리를 만듦 즉 폴더까지 만듦
			/*//mkdirs() : days26\\test\\upload -> 다른 서브 디렉토리가 있어도 (현재 없는) 전체 
			//폴더를 만드는 것
			*/
			
			//createTempFile("Work",".tmp")
			// 임시파일
			// C://windows//Temp 파일 생성
		} else {
			System.out.println(upload.delete());
			//deleteOnExit () : 응용 프로그램이 종료될 때 파일을 삭제 (지금x)
			//					EX)임시파일삭제 할때
		}
		
	}

}
