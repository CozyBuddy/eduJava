package days23;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author user
 * @date 2024. 1. 31. 오후 3:37:47
 * @subject    [시험]
 * @contents
 */
public class Ex08 {
	//Map 
	// ㄴ key : String - groupName(친구,회사,동아리,null)
	// ㄴ value : HashMap<String,String>
	//				ㄴ key : String - 이름(동명이인 문제)
	//				ㄴ value : String - 연락처
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();

	   public static void main(String[] args) {
	      
		  // 		key		value(key,value)
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


	      printList();

	   } // main

	   private static void printList() { 

	      Set<Entry<String, HashMap<String, String>>> es   = phoneBook.entrySet();
	      Iterator<Entry<String, HashMap<String, String>>> ir = es.iterator();

	      while (ir.hasNext()) {
	         Entry<String, HashMap<String, String>> entry = 
	               (Entry<String, HashMap<String, String>>) ir.next();

	         String groupName = entry.getKey();
	         HashMap<String, String> groupMap = entry.getValue();
	         System.out.printf("* %s [%d]\n",  groupName, groupMap.size() );

	         Iterator<Entry<String, String>>  ir2 = groupMap.entrySet().iterator();
	         while (ir2.hasNext()) {
	            Entry<String, String> entry2 = (Entry<String, String>) ir2.next();
	            String name  = entry2.getKey();
	            String tel = entry2.getValue();
	            System.out.printf("\t%s : %s\n", name, tel);
	         }
	      }
	   }

	                                                                    
	   private static void addPhoneNo(
	         String groupName, String name, String tel) {
	      
	      groupName = (  groupName == null ? "기타" : groupName  );
	      
	      addGroup(  groupName );  

	      HashMap<String, String>  group = phoneBook.get(groupName);
	      group.put(name, tel);
	   }

	   private static void addGroup(String groupName) {

	      if (   !phoneBook.containsKey(groupName)   ) {
	         phoneBook.put(groupName, new HashMap<String, String>());
	      }

	   }

}
