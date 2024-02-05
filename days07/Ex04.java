package days07;

/**
 * @author user
 * @date 2024. 1. 9. 오전 11:36:22
 * @subject
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
			// 정규표현식
			// 회원가입 - 주소,우편번호:
			
		String regex = "[0-9]{5}|[0-9]{3}-[0-9]{3}" ;
		// {n} 반복횟수 n 
		// {n,m} 반복횟수 n번이상 m번이하
		// {n,} 반복횟수 n 이상
		// //s 공백
		// * 반복횟수 0 ~ 여러번 0포함
		// ? 반복횟수 0 ,1 (0번 혹은 1번) // [0-9]{3}(-[0-9]?[0-9]{2}
		// + 반복횟수 1~ 여러번 0미포함
		String zipCodes[] = { "123-456","12345","123-4a6","123-4567","123456"};
		for (int i = 0; i < zipCodes.length; i++) {
			if (zipCodes[i].matches(regex)) {
				System.out.printf("올바른%s 우편번호\n",zipCodes[i]);
			} else {
				System.out.printf("올바르지않은%s 우편번호\n",zipCodes[i]);

			}
			
		}
	}

}
