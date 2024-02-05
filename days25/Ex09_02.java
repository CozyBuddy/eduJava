package days25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 3:06:26
 * @subject   기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 * @contents		DataInputStream/DataOutputStream
 */
public class Ex09_02 {
	public static void main(String[] args) {
		String name = "김진영";
		int kor=32,eng=29,math=40,tot=kor+eng+math;
		double avg=(double)tot/3;
		boolean gender = false;
		
		//한 학생 정보를 student.txt 파일 저장...
		//문자 스트림 + 파일 
		String fileName = ".\\src\\days25\\student.txt";
		try (FileReader fw = new FileReader(fileName);
				BufferedReader bw = new BufferedReader(fw)){
			bw.readLine();
			String data = bw.readLine();
			String datas[] = data.split(",");
			name = datas[0];
			kor = Integer.parseInt(datas[1]);
			eng = Integer.parseInt(datas[2]);
			math = Integer.parseInt(datas[3]);
			tot = Integer.parseInt(datas[4]);
			avg = Double.parseDouble(datas[5]);
			gender = Boolean.parseBoolean(datas[6]);
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("end");
		
		
	}

}
