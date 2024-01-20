package days11;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


/**
 * @author user
 * @date 2024. 1. 15. 오후 2:18:09
 * @subject 배열에서 가장 큰값(max)이 있는 인덱스값을 배열에 저장 후 출력
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		int [] m = { 3, 92, 3, 40, 71, 91, 61, 92, 76, 71, 59, 54, 64, 48, 66, 92, 25, 20, 73, 37 };
		
		// max 가장 큰 값을 찾아서 그 위치(index)를 배열에 담아서 출력
		//1)max
		//2)max 갯수 ->maxIndexArray 배열의 크기
		//3)max의 index를 maxIndexArray 배열의 저장.
		// 4) 배열 출력.
		int max =IntStream.of(m).max().getAsInt();
		int maxIndexArray[]=new int[m.length];
		int count=0;
		int maxCount = (int)IntStream.of(m).filter(i->i==max).count(); //최댓값 갯수
		for (int i = 0; i < m.length; i++) {
			if (max==m[i]) {
				maxIndexArray[count++] = i;
			} 
		}
		/*
		 * System.out.println(Arrays.toString(maxIndexArray));
		 * 
		 * int max =IntStream.of(m).max().getAsInt(); int maxCount = 0; for(int i =0 ;
		 * i<m.length ;i++){ if(max==m[i]) maxCount++; } maxIndexArray = new int[3]; for
		 * (int i = 0,idx=0; i < m.length; i++) { if(max==m[i]) maxIndexArray[idx++]=i;
		 * 
		 * } System.out.println(Arrays.toString(maxIndexArray));
		 */
		 
		
		
		
	}
}