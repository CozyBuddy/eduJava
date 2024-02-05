package days25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 3:06:26
 * @subject   기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 * @contents		DataInputStream/DataOutputStream
 */
public class Ex10_02 {
	public static void main(String[] args) {
		String name ;
		int kor=32,eng=29,math=40,tot=kor+eng+math;
		double avg=(double)tot/3;
		boolean gender = false;
		
		//첫 번째 학생의 정보를 student.txt 파일 저장...
		//문자 스트림 + 파일 
		String fileName = ".\\src\\days25\\student.dat";
		try (FileInputStream fis = new FileInputStream(fileName);
			DataInputStream dis = new DataInputStream(fis)){
			
		 name = dis.readUTF();
		 kor = dis.readInt();
		 math = dis.readInt();
		 eng = dis.readInt();
		 tot = dis.readInt();
		 avg = dis.readDouble();
		 gender = dis.readBoolean();
		 
			 String data = String.format("%s, %d ,%d ,%d, %d ,%f,%b \n",name,kor,math,eng,tot,avg,gender);
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		
	}

}
