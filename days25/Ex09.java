package days25;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 3:06:26
 * @subject   기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 * @contents		DataInputStream/DataOutputStream
 */
public class Ex09 {
	public static void main(String[] args) {
		String name = "김진영";
		int kor=32,eng=29,math=40,tot=kor+eng+math;
		double avg=(double)tot/3;
		boolean gender = false;
		
		//한 학생 정보를 student.txt 파일 저장...
		//문자 스트림 + 파일 
		String fileName = ".\\src\\days25\\student.txt";
		try (FileWriter fw = new FileWriter(fileName,true);
				BufferedWriter bw = new BufferedWriter(fw);){
			
			String data = String.format("%s, %d ,%d ,%d, %d ,%f,%b\n",name,kor,math,eng,tot,avg,gender);
			System.out.println(data);
			bw.append(data);
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("end");
		
		
	}

}
