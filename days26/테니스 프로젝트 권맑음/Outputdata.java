package days26;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

public class Outputdata extends Pointraw {
	static String path = ".\\src\\days26\\테니스결과.txt";
	public static void main(String[] args) {
		//Outputdata();
	}
	
	public static void Outputdata() {
		
			
				
			try (FileWriter fw = new FileWriter(path);
					PrintWriter pw = new PrintWriter(fw,true)){
				for (int j = 0; j < count2*2; j=j+2) {
					pw.print(String.format("%02d\t\t",alpoint.get(j)));
					pw.print(String.format("%02d\t\n",alpoint.get(j+1)));
				    pw.flush();
				}
			} catch (Exception e) {
						}
			
		}
	}
	


