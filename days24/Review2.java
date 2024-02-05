package days24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Review2 {
	public static void main(String[] args) {
		HashMap<TeamVO,ArrayList<MemberVO> > hm = new HashMap<>();
		ArrayList<MemberVO> al = new ArrayList<>();
		String path = ".\\src\\days24\\Java 팀 구성.txt";
		String a = null;
		String b = null;
		String c[] = null;
		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)){
			while ((a=br.readLine())!=null) {
				TeamVO tv = new TeamVO();
				tv.setName(a);
				a=br.readLine();
				c = a.split(",");
				al = new ArrayList<>();
				for (int i = 0; i < c.length; i++) {
					if (c[i].contains("팀장")) {
						String d = c[i].replace("(팀장)", "");
						tv.setLeader(d);
					} else {
						al.add(new MemberVO(c[i],"팀원"));

					}
				}
				tv.setTotalNumber( al.size()+1);
				hm.put(tv, al);
				
			}
			dispTeamMember(hm);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void dispTeamMember(HashMap<TeamVO, ArrayList<MemberVO>> hm) {
		Iterator<Entry<TeamVO, ArrayList<MemberVO>>> ir =hm.entrySet().iterator();
		while (ir.hasNext()) {
			Map.Entry<days24.TeamVO, java.util.ArrayList<days24.MemberVO>> entry = (Map.Entry<days24.TeamVO, java.util.ArrayList<days24.MemberVO>>) ir
					.next();
			System.out.print(entry.getKey().getName());
			System.out.print("("+entry.getKey().getTotalNumber()+"명) :");
			System.out.println(entry.getKey().getLeader());
			Iterator<MemberVO> ir2= entry.getValue().iterator();
			int count =1;
			while (ir2.hasNext()) {
				MemberVO memberVO = (MemberVO) ir2.next();
				System.out.println("["+count+++"]"+memberVO.getName());
			}
			
		}
		
	}

}
