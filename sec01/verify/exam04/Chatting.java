package sec01.verify.exam04;

public class Chatting {
	void startChat(String chatId) {
		String nickName = chatId;
		// 매개변수와 로컬변수를 로컬클래스에서 사용할때는 final 특징을 가지고 있음.
		
		class Chat {
			public void start() {
				while (true) {
					Chatting chat = new Chatting();
					String inputdata = "안녕하세요";
					String message = "["+nickName+"]"+inputdata;
					sendMessage(message);
				}
				
			}

			private void sendMessage(String message) {
				
			}
		}
		Chat chat = new Chat();
		chat.start();
	}

}
