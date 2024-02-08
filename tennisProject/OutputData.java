package tennisProject;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringReader;

public class OutputData extends Pointraw {
	static String path = ".\\src\\tennisProject\\테니스결과.txt";
	
	public static void Outputdata() throws IOException  {
		
		FileWriter fw = new FileWriter(path,true);
              PrintWriter pw = new PrintWriter(fw);
				pw.print(String.format("\t\t\t\t\t-------- %s팀과 %s팀의 테니스 시합 정보--------\n", Tennis.list.get(0).getTeam().getTeamName(),Tennis.list.get(2).getTeam().getTeamName()));
	            int i = 0; 
	            int k = 0; 
	            int l = 0;
	            int m = 0;
	            for (int j = 0; j < alpoint.size(); j=j+2) {
	               l++;
	               k++;
	               pw.print(String.format("%02d\t\t",alpoint.get(j))); //0번째에 1번플레이어의 첫번째 포인트 누적득점 값 
	               pw.print(String.format("%02d\t\n",alpoint.get(j+1))); //1번째에 2번플레이어의 첫번째 포인트 누적득점 값
	                if (count3.get(i)==k) {
	                   System.out.println();
	                   pw.print("┄".repeat(15)+"\n");
	                   i=i+1;
	                   k=0;
	               }
	                if (pointCount[m]==l ) {
	                	   pw.print(String.format("↑↑↑↑↑↑↑ %d 세트 정보 ↑↑↑↑↑↑↑\n ",++m));
	                	   pw.print(String.format("이번 세트 승리팀은 %s 입니다.\n",(games[--m]>games[m+5]?Tennis.list.get(0).getTeam().getTeamName():Tennis.list.get(2).getTeam().getTeamName())));
	                	   l=0;
	                	   m++;
	                   }
	                
	                
	            }
	            int a=0 ;
                //String b ;
                for (int j = 0; j < 5; j++) {
					a +=sets[j]-sets[j+5];
				}
                pw.print(String.format("최종 경기 결과 승리팀은 %s팀입니다.\n", (a>=0 ?Tennis.list.get(0).getTeam().getTeamName():Tennis.list.get(2).getTeam().getTeamName())));
                System.out.printf("최종 경기 결과 승리팀은 %s팀입니다.\n", (a>=0 ?Tennis.list.get(0).getTeam().getTeamName():Tennis.list.get(2).getTeam().getTeamName()));
                
	         pw.flush();
           
	     }
	   
	
}

	

