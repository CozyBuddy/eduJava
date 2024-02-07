package days26;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DispWinner extends Pointraw implements Tennis {
	//포인트를 받아서 출력하기 때문에 마지막 게임수를 즉시 올릴지?
	public static void main(String[] args) throws IOException {
		String a = "이관희"; //팀명
		String b = "윤하정"; //팀명
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
		//System.out.println(Arrays.toString(games));
		Outputdata.Outputdata();
		
	
		
		
		//disppointBoard(a , b , c ,d);
		
	}
	
	
	//현재의 스코어보드를 화면에 출력한다.
	public static void disppointBoard(String n , String m, int c  ,int d) {   
		name1 = n;
		name2 = m;
		count2++;
		pointCount[count]++;
		point[count]+=c;
		tempPoint1[count] = point[count];
		tempPoint2[count] = point[count];
		point[count+5]+=d;
		alpoint.add(point[count]);
		alpoint.add(point[count+5]);
		
		
		if (point[count]>=40 && point[count+5]<30&&(point[count]-point[count+5])>10 ||point[count]>=40 &&point[count+5]>30 && (point[count]-point[count+5])>20 ) {
			
			games[count]++;
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name1+"   ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"   ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			System.out.println("이 게임 승자는" + name1 +"팀");
			//gamesCount[count]++;
			count3.add(count2);
			
			count2=0;
			
			if (games[count]==6) {
				System.out.println("이 세트 승자는" + name1 + "팀");
				sets[count]++;
				count++;
				
				
				
			}
		} else if (point[count+5]>=40 && point[count]<30&& (point[count+5]-point[count])>10 ||point[count+5]>=40 && point[count]>30 &&(point[count+5]-point[count])>20) {
			
			games[count+5]++;
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name1+"   ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"   ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			
			
			//gamesCount[count+5]++;
			count3.add(count2); //이긴 게임 수를 계산
			count2=0;
			System.out.println("이 게임 승자는" + name2 +"팀");
			if (games[count+5]==6) {
				System.out.println("이 세트 승자는" + name2 + "팀");
				sets[count+5]++;
				count++;
				
				
			}
		} else {
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name1+"   ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"   ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			
			//gamesCount[count+5]++;
			count3.add(count2);
			count2=0;
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



