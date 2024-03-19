package days02;

import java.text.MessageFormat;
import java.text.ParseException;

public class EX02_02 {
	public static void main(String[] args) {
		//형식화 클래스 : MessageFormat
	/*	Object objs [] = {50,"영업부","서울"};
		String pattern = "insert into dept values ({0},''{1}'',''{2}'')";
		String sql = MessageFormat.format(pattern, objs);
		System.out.println(sql);*/
		
		//[2]
		String record = "50,,SEOUL";
		String pattern = "{0},{1},{2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object objs[] = mf.parse(record);
			System.out.println(objs[0]);
			System.out.println(objs[1]);
			System.out.println(objs[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}