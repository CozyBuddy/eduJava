package days23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Revie4 {
	public static void main(String[] args) {
		HashMap<String, HashMap<String, String>> hm = new HashMap<>();
		String Path = ".\\src\\days19\\Java 팀 구성.txt";
		String a ;
		String c[] = null;
		ArrayList<String> b = new ArrayList<>();
		ArrayList<String> e = new ArrayList<>();
		try (FileReader fr = new FileReader(Path);
				BufferedReader br = new BufferedReader(fr);){
				while ((a=br.readLine())!=null) {
					b.add(a);
					
				}
				c = b.get(1).split(",");
				for (int i = 0; i < c.length; i++) {
					e.add(c[i]);
				}
				c = b.get(3).split(",");
				for (int i = 0; i < c.length; i++) {
					e.add(c[i]);
				}
				System.out.println(e);
				hm.keySet(b.get(0),new HashMap<String ,String>);
				hm.keySet(b.get(3),0);
				Iterator<Entry<String, HashMap<String, String>>> ir =  hm.entrySet().iterator();
				while (ir.hasNext()) {
					Map.Entry<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> entry = (Map.Entry<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>>) ir
							.next();
					
					
				}
				/*ArrayList d = new ArrayList(c);
				Set<Entry<String, HashMap<String, String>>> st =hm.entrySet();
				st.add(b.get(0),new HashMap<String,String>());*/
				
				
				
				/*Set<Entry<String, HashMap<String, String>>> st = hm.entrySet();
				Iterator<Entry<String, HashMap<String, String>>>  ir =st.iterator();*/
				//System.out.println(b);
		} catch (Exception f) {
			// TODO: handle exception
		}
	}

}
