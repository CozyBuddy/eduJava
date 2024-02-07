package tennis;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DispWinner extends Pointraw  {
	//포인트를 받아서 출력하기 때문에 마지막 게임수를 즉시 올릴지?
	
	
	//현재의 스코어보드를 화면에 출력한다.
	public static void disppointBoard(String name , String name2, int c  ,int d) {   
		count2++;
		pointCount[count]++;
		point[count]+=c;
		point[count+5]+=d;
		alpoint.add(point[count]);
		alpoint.add(point[count+5]);
		
		
		if (point[count]>=40 && point[count+5]<=30&&(point[count]-point[count+5])>=10 ||point[count]>=40 &&point[count+5]>=40 && (point[count]-point[count+5])>=20 ) {
			
			games[count]++;
//			System.out.println("┌"+"━".repeat(78)+"┐");
//			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
//			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
//			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
//			System.out.println("━".repeat(80));
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
//			System.out.println("┃  "+name+"   ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
//			
//			
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃"+"━".repeat(78)+"┃");
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");
//
//			System.out.println("┃  "+name2+"   ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
//			
//			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
//			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			//System.out.println("이 게임 승자는" + name +"팀");
			//gamesCount[count]++;
			count3.add(count2);
			
			count2=0;
			
			if (games[count]==6) {
				//System.out.println("이 세트 승자는" + name + "팀");
				sets[count]++;
				count++;
				
				
				
			}
		} else if (point[count+5]>=40 && point[count]<=30&& (point[count+5]-point[count])>=10 ||point[count+5]>=40 && point[count]>=40 &&(point[count+5]-point[count])>=20) {
			
			games[count+5]++;
			
			point[count]=0;
			point[count+5]=0;
			
			
			//gamesCount[count+5]++;
			count3.add(count2);
			count2=0;
			//System.out.println("이 게임 승자는" + name2 +"팀");
			if (games[count+5]==6) {
				//System.out.println("이 세트 승자는" + name2 + "팀");
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
	public static void displayScoreBoard(String name , String name2 , int a ,int b) {
		// Tennis.get(0).getScore()
		if (b>=a) {
			sum2 += b;
		} else {
			sum1 += a;
		}
		point2[count7] = sum1;
		point2[count8] = sum2;
		if(Tennis.list.get(0).getScore() >= 40 || Tennis.list.get(1).getScore() >= 40) {
			if(Tennis.list.get(0).getScore() - Tennis.list.get(1).getScore() >= 20 || Tennis.list.get(1).getScore() - Tennis.list.get(0).getScore() >= 20 )			games2[count5]++;
			games2[count5]++;
			count5++; // 1팀이 1게임을 이긴횟수추가
			
			if (count5==6) {
				count7++; //이긴 세트수
				count8++;
			}
		} else if (Tennis.list.get(1).getScore() >= 40 || Tennis.list.get(0).getScore() >= 40) {
			if(Tennis.list.get(1).getScore() - Tennis.list.get(0).getScore() >= 20 || Tennis.list.get(0).getScore() - Tennis.list.get(1).getScore() >= 20 )	
		
			games2[count6]++;
			count6++; // 2팀이 1게임을 이긴횟수추가
			if (count6==6) {
				count7++;
				count8++;
			}
		}
		count4++; //진행한 게임수
		System.out.println("┌"+"━".repeat(78)+"┐");
		System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
		System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
		System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
		System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
		System.out.println("━".repeat(80));
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("┃         ┃"+" ".repeat(10)+games2[0]+" ".repeat(11)+games2[1]+" ".repeat(11)+games2[2]+" ".repeat(11)+games2[3]+" ".repeat(11)+games2[4]+"         ┃");
		System.out.println("┃  "+name+"   ┃"+" ".repeat(8)+"("+point2[0]+")"+" ".repeat(9)+"("+point2[1]+")"+" ".repeat(9)+"("+point2[2]+")"+" ".repeat(9)+"("+point2[3]+")"+" ".repeat(9)+"("+point2[4]+")"+"        ┃");
		
		
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("┃"+"━".repeat(78)+"┃");
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("┃         ┃"+" ".repeat(10)+games2[5]+" ".repeat(11)+games2[6]+" ".repeat(11)+games2[7]+" ".repeat(11)+games2[8]+" ".repeat(11)+games2[9]+"         ┃");

		System.out.println("┃  "+name2+"   ┃"+" ".repeat(8)+"("+point2[5]+")"+" ".repeat(9)+"("+point2[6]+")"+" ".repeat(9)+"("+point2[7]+")"+" ".repeat(9)+"("+point2[8]+")"+" ".repeat(9)+"("+point2[9]+")"+"        ┃");
		
		System.out.println("┃         ┃"+" ".repeat(68)+"┃");
		System.out.println("└"+"━".repeat(78)+"┘");
	}
	
}


