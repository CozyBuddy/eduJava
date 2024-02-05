package days23;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Review6 {
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();

	public static void main(String[] args) { 
	
		String groupName, name, tel;

		addPhoneNo( "친구","이자바","010-1111-1111" );
		addPhoneNo( "친구","김자바","010-2222-2222" );
		addPhoneNo( "친구","김자바","010-3333-3333" );

		addPhoneNo( "회사","이대리","010-4444-4444" );
		addPhoneNo( "회사","김대리","010-5555-5555" );
		addPhoneNo( "회사","박대리","010-6666-6666" );

		addPhoneNo( "동아리","김동아","010-7777-7777" );

		addPhoneNo( null, "세탁소","010-8888-8888" );  // 기타
		addPhoneNo( null, "PC방","010-9999-8888" );    // 기타

		//System.out.println(phoneBook);
		printList();

	} // main

   
	private static void printList() { 
		Set<Entry<String, HashMap<String, String>>> st = phoneBook.entrySet();
		Iterator<Entry<String, HashMap<String, String>>> ir = st.iterator();
		while (ir.hasNext()) {
			Entry<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> entry = (Entry<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>>) ir
					.next();
			System.out.println(entry.getKey());
			HashMap<String, String> hm = entry.getValue();
			Iterator<Entry<String, String>> hm1 = hm.entrySet().iterator();
			
			
		}
 
	}

	                                                                 
	private static void addPhoneNo(
			String groupName, String name, String tel) {
		groupName = (groupName == null ? "기타" : groupName);
		
		addGroup(groupName);
		
		HashMap<String, String> dI = phoneBook.get(groupName);
		dI.put(name, tel);
		 
	}

	private static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap<>());
		}
	}

} // class    


