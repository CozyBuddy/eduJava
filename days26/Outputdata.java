package days26;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringReader;

public class Outputdata extends Pointraw {
	static String path = ".\\src\\days26\\테니스결과.txt";
	public static void main(String[] args) {
		//Outputdata();
		
	}
	
	public static void Outputdata() {
		
		try (FileWriter fw = new FileWriter(path,true);
	               PrintWriter pw = new PrintWriter(fw);
				
				){
				pw.print(String.format("********* %s팀과 %s팀의 테니스 시합 정보*********\n", name1,name2));
	            int i = 0;
	            int k = 0;
	            int l = 0;
	            int m = 0;
	            for (int j = 0; j < alpoint.size(); j=j+2) {
	               l++;
	               k++;
	               pw.print(String.format("%02d\t\t",alpoint.get(j)));
	               pw.print(String.format("%02d\t\n",alpoint.get(j+1)));
	                if (count3.get(i)==k) {
	                   System.out.println();
	                   pw.print("*".repeat(10)+"\n");
	                   i++;
	                   k=0;
	               }
	                if (games[m]==l || games[m+5]==l ) {
	                	   pw.print(String.format("****** %d 세트 정보 ******\n ",++m));
	                	   pw.print(String.format("이번 세트 승리팀은 %s 입니다.\n",(games[--m]>games[m+5]?name1:name2)));
	                	   l=0;
	                	   m++;
	                   }
	                
	                
	            }
	            int a=0 ;
                String b ;
                for (int j = 0; j < sets.length; j++) {
					a =sets[j]-sets[j+1];
				}
                pw.print(String.format("최종 경기 결과 승리팀은 %s팀입니다.\n", (a>0 ?name1:name2)));
                
	         } catch (Exception e) {
	                }
	         
	      }
	   
	
}

	


