package com.util;

public class Draw2D {
	//2D 그리기 작업할 수 있는 모든 기능들을 구현한 클래스
	public static void drawLine() {
				System.out.println("-----------------------------------");
	}
	public static void drawLine(int n, int m) {
		
		for (int i = 1; i <= m; i++) {
			System.out.println("-".repeat(n));
		}
	}
	public static void drawLine(int n,String style) {
	
		System.out.println(style.repeat(n));
	}

}
