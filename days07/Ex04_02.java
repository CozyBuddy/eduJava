package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오전 11:51:14
 * @subject
 * @contents
 */
public class Ex04_02 {
	public static void main(String[] args) {
		int [] kors = {99,1,100,-10,101};
		String regex = "[1-9]?[0-9]{1}|100"; // ?는 앞의 것을 표현 0번 혹은 여러번 와도 됨.
		for (int i = 0; i < kors.length; i++) {
			int kor = kors[i];
				if((kor+"").matches(regex)) {
					System.out.println(kor);
				}
			}
		}

}
/* regex 형식
 * [] 내의 문자는 OR로 동작
 * 
 * 그 뒤에 +를 붙이면 한 번 이상 반복
 * 
 * [0-9] = \d : 숫자
 * 
 * [A-Za-z] = \D : 문자
 * 
 * \w는 알파벳, 숫자, 언더스코어
 * 
 * \W는 알파벳, 숫자, 언더스코어가 아닌 문자
 * 
 * [] 안쪽의 ^는 NOT의 의미
 * 
 * [] 바깥쪽의 ^는 시작의 의미 [출처] regExp - 정규표현식|작성자 땡일이
 * $는 문자의 마지막을 의미

? 앞선 패턴이 최대 한번(0번 포함) 이상 반복 되는지 의미

\s 여러가지 공백문자 같은 의미
   "\\." ->그냥 점(.)

 *이메일 형식
/*^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$

 // (?: -> 전방탐색 전방 탐색은 일치 패턴을 찾을 때 해당 패턴이 있을 때만 일치를 허용하는 것
  * 
  */
 */ 
