package days26;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author user
 * @date 2024. 2. 5. 오후 2:38:11
 * @subject
 * @contents
 */
public class Ex02_07 {
	public static void main(String[] args) {
		String parent = ".\\src\\days26";
		String child = "시간표_(5강의실)[혼합훈련](디지털컨버전스)AWS와 Elasticsearch 활용 자바 기반 Full-Stack 개발자 양성 과정(B).hwp";
		//335360 (Byte)
		File f = new File(parent,child);
		System.out.println(f.length());
		
		final int VOLUME = 35*1024 ; // 35kb
		//하나의 파일을 내가 원하는크기 (35kb)로 분할
		//시간표_1.hwp
		//시간표_2.hwp
		//시간표_3.hwp
		//   :
		//   :
		//시간표_10.hwp
		String baseName = getBaseName(child);
		String ext = getExtension(child);
		
		System.out.println(baseName);
		System.out.println(ext);
		int code =0;
		int i = 0;
		int index = 0;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try (FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis)){
			int count = 0;
			while ((code = bis.read())!=-1) {
				if (i%VOLUME==0) {
					if (i!=0)  bos.close(); // 저장
					child = String.format("%s_%d%s", baseName,++index,ext);
					
					
				}
				File temp = new File(parent,child);
				fos = new FileOutputStream(temp);
				bos = new BufferedOutputStream(fos);
				bos.write(code);
				i++;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//확장자를 제외한 파일명
	private static String getBaseName(String child) {
		int pos = child.indexOf(".");
		return child.substring(0,pos);
	}
	//확장자를 반환하는 메서드
    private static String getExtension(String path) {
    	int pos = path.indexOf(".");
    	return path.substring(pos);
	}
	

}
