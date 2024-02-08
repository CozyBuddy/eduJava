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
		count2++; // 총 게임 수 카운트
		pointCount[count]++;
		point[count]+=c; //count 세트 당 1플레이어의 포인트 획득 점수를 누적
		point[count+5]+=d; //count 세트 당 2플레이어의 포인트 획득 점수를 누적
		alpoint.add(point[count]); //현재 누적된 포인트 값을 기록하기 위해 배열에 추가
		alpoint.add(point[count+5]); //현재 누적된 포인트 값을 기록하기 위해 배열에 추가
		
		//1팀이 이기는 경우 듀스 상황 포함. 일부 제외
		if ((Tennis.list.get(0).getTeam().getScore()>=40 && Tennis.list.get(2).getTeam().getScore()<30)&&(Tennis.list.get(0).getTeam().getScore()-Tennis.list.get(2).getTeam().getScore())>=10 ||Tennis.list.get(0).getTeam().getScore()>=40 &&Tennis.list.get(2).getTeam().getScore()>=40 && (Tennis.list.get(0).getTeam().getScore()-Tennis.list.get(2).getTeam().getScore())>=20 ) {
			
			games[count]++; //1플레이어의 이긴게임수 추가
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0; // 두 선수의 포인트값 초기화
			point[count+5]=0; //
			System.out.println("이 게임 승자는" + Tennis.list.get(0).getTeam().getTeamName() +"팀");
			//gamesCount[count]++;
			count3.add(count2); // count3라는 배열에 총 게임수를 기록하고 기록할때 이 값을 토대로 각 승패별로 구간을 나눔.
			
			count2=0; // 총 포인트를 주고 받은 1게임의 횟수를 초기화
			
			if (games[count]==6) { //6게임을 이길때 세트를 이기는 조건을 포함
				System.out.println("이 세트 승자는" + Tennis.list.get(0).getTeam().getTeamName() + "팀");
				sets[count]++; // 이긴 세트 수를 1추가 
				count++; // 세트수 증가.
				
				
				
			}
		} else if ((Tennis.list.get(2).getTeam().getScore()>=40 && Tennis.list.get(0).getTeam().getScore()<30)&&(Tennis.list.get(2).getTeam().getScore()-Tennis.list.get(0).getTeam().getScore())>=10 ||Tennis.list.get(2).getTeam().getScore()>=40 &&Tennis.list.get(0).getTeam().getScore()>=40 && (Tennis.list.get(2).getTeam().getScore()-Tennis.list.get(0).getTeam().getScore())>=20 ) {
			
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
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			
			
			//gamesCount[count+5]++;
			count3.add(count2);
			count2=0;
			System.out.println("이 게임 승자는" + Tennis.list.get(2).getTeam().getTeamName() +"팀");
			if (games[count+5]==6) {
				System.out.println("이 세트 승자는" + Tennis.list.get(2).getTeam().getTeamName() + "팀");
				sets[count+5]++;
				count++;
				
				
			}
		} else if (Tennis.list.get(2).getTeam().getScore()==40 && Tennis.list.get(0).getTeam().getScore()==30) {
			System.out. println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			
		} else if (Tennis.list.get(2).getTeam().getScore()==30 && Tennis.list.get(0).getTeam().getScore()==40) {
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"       ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
		}
		else if ( Tennis.list.get(2).getTeam().getScore()==50 && Tennis.list.get(0).getTeam().getScore()==30) {
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
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			
			
			//gamesCount[count+5]++;
			count3.add(count2);
			count2=0;
			System.out.println("이 게임 승자는" + Tennis.list.get(2).getTeam().getTeamName() +"팀");
			if (games[count+5]==6) {
				System.out.println("이 세트 승자는" + Tennis.list.get(2).getTeam().getTeamName() + "팀");
				sets[count+5]++;
				count++;
				
				
			}
		} else if (Tennis.list.get(0).getTeam().getScore()==50 && Tennis.list.get(2).getTeam().getScore()==30) {
			games[count]++;
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+"  세트   ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀  ╲┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			point[count]=0;
			point[count+5]=0;
			
			
			//gamesCount[count+5]++;
			count3.add(count2);
			count2=0;
			System.out.println("이 게임 승자는" + Tennis.list.get(0).getTeam().getTeamName() +"팀");
			if (games[count]==6) {
				System.out.println("이 세트 승자는" + Tennis.list.get(0).getTeam().getTeamName()+ "팀");
				sets[count+5]++;
				count++;
				
				
			}
		}
		else {
			System.out.println("┌"+"━".repeat(78)+"┐");
			System.out.println("┃ ╲       ┃"+" ".repeat(67)+" ┃");
			System.out.println("┃   ╲"+" 세트 ┃"+" ".repeat(10)+"I"+" ".repeat(10)+"II"+" ".repeat(10)+"III" +" ".repeat(10)+"IV"+" ".repeat(10)+"V"+" ".repeat(7)+"  ┃");
			System.out.println("┃      ╲  ┃"+" ".repeat(68)+"┃");
			System.out.println("┃   팀   ╲ ┃"+" ".repeat(67)+" ┃");
			System.out.println("━".repeat(80));
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[0]+" ".repeat(11)+games[1]+" ".repeat(11)+games[2]+" ".repeat(11)+games[3]+" ".repeat(11)+games[4]+"         ┃");
			System.out.println("┃  "+name+"     ┃"+" ".repeat(8)+"("+point[0]+")"+" ".repeat(9)+"("+point[1]+")"+" ".repeat(9)+"("+point[2]+")"+" ".repeat(9)+"("+point[3]+")"+" ".repeat(9)+"("+point[4]+")"+"        ┃");
			
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃"+"━".repeat(78)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("┃         ┃"+" ".repeat(10)+games[5]+" ".repeat(11)+games[6]+" ".repeat(11)+games[7]+" ".repeat(11)+games[8]+" ".repeat(11)+games[9]+"         ┃");

			System.out.println("┃  "+name2+"     ┃"+" ".repeat(8)+"("+point[5]+")"+" ".repeat(9)+"("+point[6]+")"+" ".repeat(9)+"("+point[7]+")"+" ".repeat(9)+"("+point[8]+")"+" ".repeat(9)+"("+point[9]+")"+"        ┃");
			
			System.out.println("┃         ┃"+" ".repeat(68)+"┃");
			System.out.println("└"+"━".repeat(78)+"┘");
			
		}
		
		

	}
	
}


