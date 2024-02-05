package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 4:09:24
 * @subject
 * @contents
 */
public class Ex06_02 {
	public static void main(String[] args) {
		String s = "이름은 백예린입니다." ;
				s+= "\n이름은 권지용입니다.";
				//System.out.println(s);
				//"백예린" - > "XYZ"
				int foundIndex = s.indexOf("백예린");
				s=s.substring(0,foundIndex) +"XYZ"+s.substring(foundIndex+"백예린".length());
				//System.out.println(s);
				//"XYZ" 삭제 
				foundIndex = s.indexOf("XYZ");
				s=s.substring(0,foundIndex) +s.substring(foundIndex+"XYZ".length());
				System.out.println(s);
				foundIndex = s.indexOf("입니다.");
				s=s.substring(0,foundIndex) +"백예린"+s.substring(foundIndex);
				System.out.println(s); // 다시 이름 삽입.
				
				System.out.println("-".repeat(999));
				
				//StringBuffer sb = new StringBuffer("이름은 백예린입니다.");
				StringBuilder sb = new StringBuilder("이름은 백예린입니다.");
				sb.append("\n이름은 권지용입니다.");
				//System.out.println(sb);
				foundIndex = sb.indexOf("백예린");
				sb.delete(foundIndex, foundIndex+3);
				System.out.println(sb);
				
				foundIndex = sb.indexOf("입니다.");
				sb.insert(foundIndex,"백예린");
				System.out.println(sb);
				//sb = sb.substring(0,foundIndex) + "XYZ"+sb.substring(foundIndex+"백예린".length());
		
	}

}
