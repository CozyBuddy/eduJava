package days24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author user
 * @date 2024. 2. 1. 오전 10:21:04
 * @subject
 * @contents
 */
public class Ex01 {
	public static void main(String[] args) {
		String fileName = ".\\src\\days24\\Java 팀 구성.txt";
		HashMap<String, ArrayList<MemberVO>> teamMap = new HashMap<>();
		String line = null;
		String teamName = null;
		ArrayList<MemberVO> teamlist = null ;
		try (FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)){
			while ((line= br.readLine())!=null && !line.equals("")) {
				teamName = line ; //1조 ,2조 key
				line = br.readLine();
				String tNames [] =line.split("\\s*,\\s*");
				teamlist = new ArrayList<>();
				for (int i = 0; i < tNames.length; i++) {
					String name = tNames[i];
					if (name.contains("팀장")) {
						name = name.replace("(팀장)", "");
						teamlist.add(new MemberVO(name,"팀장"));
					} else {
						teamlist.add(new MemberVO(name,"팀원"));
					}
					
				}
				teamMap.put(teamName, teamlist);
				
			}
			//출력
			disTeamMember(teamMap);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void disTeamMember(HashMap<String, ArrayList<MemberVO>> teamMap) {
		Iterator<Entry<String, ArrayList<MemberVO>>> ir =teamMap.entrySet().iterator(); //
		while (ir.hasNext()) {
			Map.Entry<java.lang.String, java.util.ArrayList<days24.MemberVO>> entry = (Map.Entry<java.lang.String, java.util.ArrayList<days24.MemberVO>>) ir
					.next();
			String key = entry.getKey();
			ArrayList<MemberVO> value = entry.getValue();
			MemberVO teamLeaderVO = value.get(0);
			System.out.printf("[%s(%d명) : %s\n",key,value.size(),teamLeaderVO.getName());
			Iterator<MemberVO> ir2 =value.iterator();
			int count = 1;
			
			while (ir2.hasNext()) {
				MemberVO memberVO = (MemberVO) ir2.next();
				System.out.printf("[%d] : %s\n",count++,memberVO.getName());
			}
			
			
			
		}
	}

}
