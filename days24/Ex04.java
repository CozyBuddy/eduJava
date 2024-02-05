package days24;

/**
 * @author user
 * @date 2024. 2. 1. 오후 12:16:22
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		Button callButton = new Button();
		callButton.setListener(new CallListener());
		callButton.touch();
		
		Button messageButton = new Button();
		messageButton.setListener(new MessageListener());
		messageButton.touch();
	}

}
class Button {
	//필드 선언
	OnClickListener listener ;
	
	//필드의 Setter
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	void touch() {
		this.listener.onClick();
	}

	//중첩 인터페이스 
	interface OnClickListener{
		//상수 , 추상메서드 , Default,static 메서드
			void onClick();
	}
}
// Button 클래스 안의 OnClickListener 인터페이스를 구현한 클래스를 선언.
class CallListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("발신 합니다.");
		
	}
	
}
class MessageListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("문자를 발송 합니다.");
		
	}
}
