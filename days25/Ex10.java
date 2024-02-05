package days25;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author user
 * @date 2024. 2. 2. 오후 3:06:26
 * @subject   기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 * @contents		DataInputStream/DataOutputStream
 */
public class Ex10 {
	public static void main(String[] args) {
		String name = "김진영";
		int kor=32,eng=29,math=40,tot=kor+eng+math;
		double avg=(double)tot/3;
		boolean gender = false;
		
		String fileName = ".\\src\\days25\\student.dat";
		try (FileOutputStream fos = new FileOutputStream(fileName);
			 DataOutputStream dos = new DataOutputStream(fos)){
			String data = String.format("%s,%d,%d,%d,%d,%f,%b\n",name,kor,math,eng,tot,avg,gender);
			dos.writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(math);
			dos.writeInt(tot);
			dos.writeDouble(avg);
			dos.writeBoolean(gender);
			dos.flush();
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		
	}

}
