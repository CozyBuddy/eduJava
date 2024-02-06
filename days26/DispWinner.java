package days26;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DispWinner extends Pointraw implements Tennis {

	public static void main(String[] args) throws IOException {
		String a = "김진영"; //팀명
		String b = "신슬기"; //팀명
		Scanner sc = new Scanner(System.in);
		String e ;
		char f;
		do {
			
		
			System.out.print("A팀 포인트를 입력하세요");
			int c = sc.nextInt();
			System.out.print("B팀 포인트를 입력하세요");
			int d = sc.nextInt();
			
			disppointBoard(a , b , c ,d);
			
			System.out.print("계속 할려면 Y");
			f = (char)System.in.read();
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(f)=='Y');
		
		Outputdata.Outputdata();
		
	
		
		
		//disppointBoard(a , b , c ,d);
		
	}
	//현재의 스코어보드를 화면에 출력한다.
	public static void disppointBoard(String name , String name2, int c  ,int d) {
		
		count2++;
		point[count]+=c;
		point[count+5]+=d;
		alpoint.add(point[count]);
		alpoint.add(point[count+5]);
		System.out.println("*".repeat(80));
		System.out.println("* *        *"+" ".repeat(67)+"*");
		System.out.println("*   *"+"  세트 *"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(8)+"*");
		System.out.println("*      *   *"+" ".repeat(67)+"*");
		System.out.println("*   팀    **"+" ".repeat(68)+"*");
		System.out.println("*".repeat(80));
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*         *"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         *");
		System.out.println("*  "+name+"   *"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        *");
		
		
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*".repeat(80));
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*         *"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         *");

		System.out.println("*  "+name2+"   *"+" ".repeat(9)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        *");
		
		System.out.println("*         *"+" ".repeat(68)+"*");
		System.out.println("*".repeat(80));
		
		if (point[count]>=40 && point[count+5]<=30&&(point[count]-point[count+5])>=10 ||point[count]>=40 &&point[count+5]>=40 && (point[count]-point[count+5])>=20 ) {
			System.out.println("이 게임 승자는" + name +"팀");
			point[count]=0;
			point[count+5]=0;
			
			games[count]++;
			count3.add(count2);
			count2=0;
			
			if (games[count]==6) {
				System.out.println("이 세트 승자는" + name + "팀");
				sets[count]++;
				count++;
				
				
			}
		} else if (point[count+5]>=40 && point[count]<=30&& (point[count+5]-point[count])>=10 ||point[count+5]>=40 && point[count]>=40 &&(point[count+5]-point[count])>=20) {
			System.out.println("이 게임 승자는" + name2 +"팀");
			point[count]=0;
			point[count+5]=0;
			
			games[count+5]++;
			count3.add(count2);
			count2=0;
			if (games[count+5]==6) {
				System.out.println("이 세트 승자는" + name2 + "팀");
				sets[count+5]++;
				count++;
				
				
			}
		}
		
		/*for (int i = count; i < 10; i++) {
			al1.add(0);
			
		}
		for (int i = count; i < 10; i++) {
			al2.add(0);
			
		}*/
		
		
		
		//System.out.print("*     *"+" ".repeat(12)+a+" ".repeat(15)+":"+" ".repeat(14)+b+" ".repeat(14)+"*\n");

		

	}
	
}



