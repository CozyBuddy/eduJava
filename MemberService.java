
public class MemberService {
	
	String a ;
	String b ;
	String c;

	
	boolean login(String a,String b) {
		if (a=="hong"&& b=="12345") {
			return true;
			
		} else {
			return false;
		}
	}
	
	void logout(String c) {
		System.out.println("로그아웃 되었습니다.");
	}

}
