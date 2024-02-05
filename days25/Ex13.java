package days25;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author user
 * @date 2024. 2. 2. 오후 4:13:16
 * @subject PipedReader/PipedWriter
 * @contents  ㄴ스레드 간에 데이터를 입출력할때 사용하는 스트림.
 * 				[RandomAccessFile]
 * 					ㄴ 파일의 어느 위치에나 읽기/쓰기가 가능한 장점이 있는 스트림이다.
 * 					ㄴ getFilePoint() 파일포인트 (현재 위치)
 * 					ㄴ seek(위치) 이동시키는 메서드
 * 					ㄴ readXXX(),writeXXX()
 */
public class Ex13 {
	public static void main(String[] args) throws IOException {
		String s =  "I Love normal Java";
		String q = "javabook"; 
		String name = ".\\src\\days25\\random.txt";
		String mode = "rw"; // read and write 
		try (RandomAccessFile raf = new RandomAccessFile(name, "rw")){
			long cp =raf.getFilePointer();
			System.out.println("현재 파일 포인터 : " + cp);
			raf.writeBytes(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 일시정지 + 엔터 계속.
		System.out.println("> 엔터치면 진행한다.");
		System.in.read(); 
		System.in.skip( System.in.available() ); // 13,10 제거
		
		//[2]
		try (RandomAccessFile raf = new RandomAccessFile(name, "rw")){
			raf.seek(7); //위치 이동 index 위치 , 라인 위치가 아님.
			raf.writeBytes(q);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 일시정지 + 엔터 계속.
		System.out.println("> 엔터치면 진행한다.");
		System.in.read(); 
		System.in.skip( System.in.available() ); // 13,10 제거
	
	
	//[2]
			try (RandomAccessFile raf = new RandomAccessFile(name, "rw")){
				raf.seek(2); //위치 이동
				String line = raf.readLine();
				System.out.println(line);

			} catch (Exception e) {
				e.printStackTrace();
			}
			// 일시정지 + 엔터 계속.
			System.out.println("> 엔터치면 진행한다.");
			System.in.read(); 
			System.in.skip( System.in.available() ); // 13,10 제거
		}
		

}
