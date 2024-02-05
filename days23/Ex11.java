package days23;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * @author user
 * @date 2024. 1. 31. 오후 5:05:40
 * @subject
 * @contents
 */
public class Ex11 {
	public static void main(String[] args) {
		/*String userDir = System.getProperty("user.dir");
		System.out.println(userDir);*/
		
		Properties p = System.getProperties();
		Set<Entry<Object, Object>> se = p.entrySet();
		
		Iterator<Entry<Object, Object>> ir  = se.iterator();
		
		while (ir.hasNext()) {
			Entry<Object, Object> entry =  ir.next();
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			
			System.out.printf("%s : %s\n " ,key,value );
			
		}
	}
	
	//제네릭
	//열거형
	//자바 IO

}
