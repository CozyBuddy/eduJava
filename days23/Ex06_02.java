package days23;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Ex06_02 {
		public static void main(String[] args) {
			// List,Set
			// Map 인터페이스를 구현한 컬렉션 클래스
			/*
			 * 1. 한쌍(Key +value) == Entry(엔트리) 으로 관리
			 * 2. key 중복 허용 x 
			 * 	  value 중복 허용 O
			 * 		순서 x 
			 * 3. HashMap (신) - 사용권장,
			 * 	  Hashtable ( 구)
			 * 4. 해싱(Hashing) ?
			 * 		- 해싱을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능을 보임.
			 * 		- 해시함수를 이용해서 데이터를 해시 테이블에 
			 * 		  저장하고 검색하는 방법.
			 * 		- 해시함수 ? 데이터가 저장되는 곳을 알려주는 함수
			 * 					데이터를 빠르게 검색할 수 있다.
			 * 		- 데이터저장(key+value) 키를 해시 함수에 넣으면 
			 * 		  배열의 한 요소를 얻어오고 다시 그곳에 연결된 링크드 리스트에 데이터를 저장.
			 * 		
			 * 		[해시함수] 데이터가 저장되는 곳을 알려주는 함수.
			 * 			데이터 저장 예) 1999.1.1 ~~~
			 * 		 [1998] [][][][][]
			 * 		 [1999] [1월][2월][][][][][][][][]
			 *  	 [2000]
			 * 		 []
			 *  	 []
			 * 		 []
			 * 
			 * 
			 * 	  
			 */
			// <E> Element ==요소
			// K==key V = value
			HashMap<String, String> ht = new HashMap<>();
			ht.put("admin", "관리자");
			ht.put("hong", "홍길동");
			ht.put("root", "관리자");
			
			System.out.println(ht);
			System.out.println(ht.size()); //엔트리의 갯수
		
			// 모든 key 조회. 
			
			/*Enumeration<String> en = ht.keys();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				System.out.println(key);
			}
			*/
			// [2] 모든 key 조회 
			Set<String> keys =  ht.keySet();
			Iterator<String> ir = keys.iterator();
			while (ir.hasNext()) {
				String key =  ir.next();
				System.out.println(key);
			}
			// key를 알때 value 값을 얻어오는 방법.
			/*String value = ht.get("root");
			System.out.println(value);*/
			
			// 없는 키값을 반환하면 null 값을 반환함. 초기값
			//String value = ht.get("ke");
			// 앞에 키값을 찾고 없으면 뒤에 걸로 기본값 설정.
		/*	String value = ht.getOrDefault("ke", "케닉");
			System.out.println(value);*/
			
			// 모든 value 조회
			/*Collection<String> values = ht.values();
			Iterator<String> ir = values.iterator();
			while (ir.hasNext()) {
				String value = (String) ir.next();
				System.out.println(value);
				
			}*/
			
			// [문제] park 키가 존재하는지 확인한 후에 
			//   park의 value를 박철로 엔트리를 추가.
			
			
			
			/*if (!ht.contains("park")) {
				ht.put("park", "박철");
			}
			System.out.println(ht);
			*/
			
			// 해시테이블 출력하는 메서드() 호출
			disHT(ht);
		}
		private static void disHT(HashMap<String, String> ht) {
			Set<Entry<String, String>> se = ht.entrySet();
			Iterator<Entry<String, String>> ir = se.iterator();
			while (ir.hasNext()) {
				Entry<String, String> entry =  ir.next();
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.printf("%s : %s\n", key,value);
			}
		
		}
		/*
		 *  [1]
		 *   private static void disHT(HashMap<String, String> ht) {
			
			 * key : value
			 * hong : 홍길동
			 * root : 관리자
			 * admin : 관리자
			 
			Enumeration<String> cc = ht.keys();
			Iterator<String> ir = cc.iterator();
			while (ir.hasNext()) {
				String string = (String) ir.next();
				System.out.print(string);
			}
			Enumeration<String> en = ht.keys();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = ht.get(key);
				System.out.printf("%s : %s\n",key,value);
				
			}*/
			
		

	}
