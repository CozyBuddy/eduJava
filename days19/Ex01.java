package days19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ex01 {
	public static void main(String[] args) {
		String readPath = "SS20_Team.txt";
		String teamMember[] = null;
		
		String key = "user.dir";
		String userDir = System.getProperty(key);
		String path = String.format("%s\\src\\days18\\%s",userDir, readPath);
		System.out.println(path);
		
		String myName = "권맑음";
		String teamLine= null;
		String teamMemberLine= null;
		String teamLeader = null;
		String regex = "\\s*,\\s";
		try(FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);) {
			while ((teamLine = br.readLine())!=null) {
				teamMemberLine = br.readLine();
				//System.out.printf("[%s] : [%s]\n",teamLine,teamMember);
				if (teamMemberLine.contains(myName)) {
					System.out.printf("[%s] : [%s]\n",teamLine,teamMemberLine);
					teamMember =teamMemberLine.split(regex);// 자동적으로 배열에 순서대로 들어감
					teamLeader = teamMember[0].replace("(팀장)", "");
					// 나머지 팀원들 내림차순으로 정렬
					String temp[] = new String[teamMember.length-1] ;
					System.arraycopy(teamMember, 1, temp, 0, teamMember.length-1);
					//System.out.println("temp : " +Arrays.toString(temp));
					Arrays.sort(temp,Collections.reverseOrder());
					//System.out.println("temp : " +Arrays.toString(temp));
					System.arraycopy(temp, 0, teamMember, 1, teamMember.length-1);
					//System.out.println(Arrays.toString(teamMember));
					break;
				}
			}
			//출력
			String output= "<ul>\r\n"
					+ "	<li class=\"leader\">";
			System.out.printf("[ %s ]\n",teamLine);
			output += String.join("</li>\n\t<li>", teamMember);
			output += "</li>\n"+"</ul>";
			System.out.println(output);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
