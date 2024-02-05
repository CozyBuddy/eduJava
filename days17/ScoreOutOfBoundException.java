package days17;

// 사용자 정의 예외 클래스
// ㄴ checked 예외
// ㄴ unchecked 예외

public class ScoreOutOfBoundException extends RuntimeException{
	// 예외 코드 번호 : 필드 
	private final int ERROR_CODE ;
	
	public int getERROR_CODE() {
		return ERROR_CODE;
	}
	public ScoreOutOfBoundException(int error_code,String message) {
		super(message);
		this.ERROR_CODE = error_code; // 생성자를 통해서 final 변수를 초기화
		
	}
	public ScoreOutOfBoundException(String message) {
//		super(message);
//		this.ERROR_CODE = 1000;
		this(1000,message);
		
	}
	
}
