package days18;

import java.io.BufferedReader;
import java.io.FileReader;

public class Review2 {
	public static void main(String[] args) {
		String readPath = "C:\\Users\\user\\Documents\\카카오톡 받은 파일\\SS20_Team.txt";
		String line;
		String teamMember[] = new String[50]; 
		StringBuffer sb = new StringBuffer();
		String a=null ;
		int i =0;
		try(FileReader fr = new FileReader(readPath);
				BufferedReader br = new BufferedReader(fr);) {
			while ((line=br.readLine())!=null) {
				//System.out.print((char)line);
				teamMember = containString(teamMember,line,i);
				System.out.print(teamMember[i++]);
				//System.out.println(teamMember[i++]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static String[] containString(String[] teamMember, int line, int i) {
		teamMember[i]+=(char)line;
		return teamMember;
	}

	

}
