package days10;

/**
 * @author user
 * @date 2024. 1. 12. 오후 4:16:57
 * @subject
 * @contents
 */
public class Ex04_02 {
	
	public static void main(String[] args) {
		// 배열이 가득 차면 배열 크기를 늘려서 추가.
		int m [] = new int [3];
		int index =0;
		
		m[index++] =1;
		m[index++] =2;
		m[index++] =3;
		// index == 3 이됨.
		// 배열의 방이 다 찼는지를 물어보고 다 찼으면 3개씩 늘리도록 방향을 잡음.
		if (m.length == index) {
			int [] temp = new int [m.length +3];
			for (int i = 0; i < m.length; i++) {
				temp[i]=m[i];
			}
			m = temp; // 배열 끼리 대입할때는 주소값을 대입시킨다는 뜻.
			
		}
		m[index++] =4;
	}
	public static void name() {
		
	}

}
