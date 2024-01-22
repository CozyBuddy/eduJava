package days16;

import days14.TV;

/**
 * @author user
 * @date 2024. 1. 22. 오전 11:29:25
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		// 기존 days14.TV 
		// 자막 기능이 있는 TV가 필요. 
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 11;
		ctv.channelDown();
		System.out.println(ctv.channel);
		ctv.dispCaption("Hello World");
		ctv.caption = true;
		ctv.dispCaption("Hi~");
	}

}
class CaptionTv extends TV{
	boolean caption; // 자막 기능 on(true) /off(false)
	
	// 메서드
	void dispCaption(String text) {
		if (this.caption) {
			System.out.println(text);
			
		}
	}
}
