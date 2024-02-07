package tennis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Game extends Pointraw{

	// 어떤 팀 or 어떤 선수가 이겼는지 1 or 2로 반환

	public int tennisGame() {
		int p = 0;
		Random rnd = new Random();
		p = rnd.nextInt(2) + 1;
		return p;
	}

	public ArrayList singlesGameWin() {
		Tennis.list.get(0).setScore(0);
		Tennis.list.get(1).setScore(0);
		Player p1 = Tennis.list.get(0); // 김길동
		Player p2 = Tennis.list.get(1);	// 홍길동
		int[] cnt = new int[2];
		out:
			while (true) {
				int p = this.tennisGame();
				// 어떤 선수가 이겼는지 int p를 통해 저 메서드 호출할때 p값을 매개변수로 줘서 호출하기
				// ArrayList로 받아와서 첫번째(player이름) 두번째(점수)를 받는다.
				int n = (int)Point.singlePointWin(p);
				String player = Tennis.list.get(n).getPlayerName();
				int playerPoint = Tennis.list.get(n).getScore();
				// Player클래스에서 가져온 이름1번과 player의 이름이 같으면 1번선수의 포인트 증가
				if(p1.getPlayerName().equals(player)){
					if(cnt[0] <= 1) {
						Tennis.list.get(n).setScore(playerPoint+5);
						//System.out.printf("%s point : %s\n", p1.getPlayerName(), p1.getScore());
						//System.out.printf("%s point : %s\n", p2.getPlayerName(), p2.getScore());
						DispWinner.displayScoreBoard(p1.getPlayerName(), p2.getPlayerName(), 15, 0);
						DispWinner.disppointBoard(p1.getPlayerName(), p2.getPlayerName(), 15, 0);
						
					}else {
						Tennis.list.get(n).setScore(playerPoint);
						//System.out.printf("%s point : %s\n", p1.getPlayerName(), p1.getScore());
						//System.out.printf("%s point : %s\n", p2.getPlayerName(), p2.getScore());
						DispWinner.displayScoreBoard(p1.getPlayerName(), p2.getPlayerName(), 10, 0);
						DispWinner.displayScoreBoard(p1.getPlayerName(), p2.getPlayerName(), 10, 0);
						
						// player1, 2의 포인트를 증가시킨다.
					}
					cnt[0]++;
				}
				else {
					if(cnt[1] <= 1) {
						Tennis.list.get(n).setScore(playerPoint+5);
						//System.out.printf("%s point : %s\n", p1.getPlayerName(), p1.getScore());
						//out.printf("%s point : %s\n", p2.getPlayerName(), p2.getScore());
						DispWinner.displayScoreBoard(p1.getPlayerName(), p2.getPlayerName(), 0, 15);
						DispWinner.disppointBoard(p1.getPlayerName(), p2.getPlayerName(), 0, 15);
						
					}else {
						Tennis.list.get(n).setScore(playerPoint);
						//System.out.printf("%s point : %s\n", p1.getPlayerName(), p1.getScore());
						//System.out.printf("%s point : %s\n", p2.getPlayerName(), p2.getScore());
						DispWinner.displayScoreBoard(p1.getPlayerName(), p2.getPlayerName(), 0, 10);
						DispWinner.disppointBoard(p1.getPlayerName(), p2.getPlayerName(), 0, 10);
						
					}
					cnt[1]++;
				} // if
				// 한 선수의 점수가 40점 초과할 때 차이가 20점이면 break;
				if(p1.getScore() >= 40 || p2.getScore() >= 40) {
					if(p1.getScore() - p2.getScore() >= 20 || p2.getScore() - p1.getScore() >= 20)
						cnt[0]=0;
						cnt[1]=0;
						
						break out;
				}
				// 두선수의 점수가 40점일때 듀스
				if(p1.getScore() >= 40 && p2.getScore() >= 40) {
					// 두선수의 점수차이가 20점이나면 2게임을 이긴거니까 break;
					if(p1.getScore() - p2.getScore() >= 20 || p2.getScore() - p1.getScore() >= 20)
						cnt[0]=0;
					cnt[1]=0;
					break out;
				} // if
			} // while
		ArrayList playerList = new ArrayList();
		// 이긴선수의 이름과 점수값과(0번방) 진선수의 이름과 점수값(1번방)에 넣어서 리턴
		if(p1.getScore() > p2.getScore()) {
			Collections.addAll(playerList, p1.getPlayerName(), p1.getScore());
			Collections.addAll(playerList, p2.getPlayerName(), p2.getScore());
		}else {
			Collections.addAll(playerList, p2.getPlayerName(), p2.getScore());
			Collections.addAll(playerList, p1.getPlayerName(), p1.getScore());
		}
		Tennis.list.set(0,p1);
		Tennis.list.set(1,p2);
		return playerList;
	} // singlesGameWin()


	public ArrayList doublesGameWin() {

		// 팀1과 팀2에는 현재 Team클래스에서 받은 팀이 들어가있다.
		Team team1 = Tennis.list.get(0).getTeam();
		Team team2 = Tennis.list.get(2).getTeam();
		team1.setScore(0);
		team2.setScore(0);
		ArrayList players = new ArrayList();
		int point = 0;
		int[] cnt = new int[2]; 
		while (true) {
			int p = this.tennisGame();
			int n = (int)Point.doublesPointWin(p);

			// 팀 1과 팀 2를 리스트로 만들어주면??
			// 팀값을 ArrayList로 받아와서 0~3번값을 각각 넣는다.
			int teamPoint = Tennis.list.get(n).getTeam().getScore();
			// list의 2번째 값이 선수들 명인데 0~3 // 0번과 1번은 1팀  //  2번과 3번은 2팀
			String team = Tennis.list.get(n).getTeam().getTeamName();
			// team의 이름이 Tennis의 리스트 0번(1번팀)과 같으면 포인트를 증가
			// 만약 입력받은 횟수가 2번 이하라면 point+5한 값을 받는다.
			if(team.equals(team1.getTeamName())) {
				//System.out.println(team+team1.getTeamName());
				if(cnt[0] <= 1) {
					Tennis.list.get(n).getTeam().setScore(teamPoint+5);
					System.out.println(Tennis.list.get(n).getTeam().getScore());
					//System.out.printf("%s point : %s\n", team1.getTeamName(), team1.getScore());
					//System.out.printf("%s point : %s\n", team2.getTeamName(), team2.getScore());
					DispWinner.disppointBoard(team1.getTeamName(), team2.getTeamName(), 15, 0);
					DispWinner.displayScoreBoard(team1.getTeamName(), team2.getTeamName(), 15, 0);
				}else {
					// team1의 포인트 증가
					Tennis.list.get(n).getTeam().setScore(teamPoint);
					System.out.println(Tennis.list.get(n).getTeam().getScore());
					//System.out.printf("%s point : %s\n", team1.getTeamName(), team1.getScore());
					//System.out.printf("%s point : %s\n", team2.getTeamName(), team2.getScore());
					DispWinner.disppointBoard(team1.getTeamName(), team2.getTeamName(), 10, 0);
					DispWinner.displayScoreBoard(team1.getTeamName(), team2.getTeamName(), 10, 0);

				}
				cnt[0]++;
			}else {
				if(cnt[1] <= 1) {
					// 여기는 2번 팀의 점수를 증가하는 조건문
					Tennis.list.get(n).getTeam().setScore(teamPoint+5);
					System.out.println(Tennis.list.get(n).getTeam().getScore());
					//System.out.printf("%s point : %s\n", team1.getTeamName(), team1.getScore());
					//System.out.printf("%s point : %s\n", team2.getTeamName(), team2.getScore());
					DispWinner.disppointBoard(team1.getTeamName(), team2.getTeamName(), 0 , 15);
					DispWinner.displayScoreBoard(team1.getTeamName(), team2.getTeamName(),0,15);
					
				}else {
					Tennis.list.get(n).getTeam().setScore(teamPoint);
					System.out.println(Tennis.list.get(n).getTeam().getScore());
					//System.out.printf("%s point : %s\n", team1.getTeamName(), team1.getScore());
					//System.out.printf("%s point : %s\n", team2.getTeamName(), team2.getScore());
					DispWinner.disppointBoard(team1.getTeamName(), team2.getTeamName(), 0 , 10);
					DispWinner.displayScoreBoard(team1.getTeamName(), team2.getTeamName(), 0, 10);

				}
				cnt[1]++;
			} // if
			// 두 팀의 점수가 40점 초과할때 두 팀의 점수차가 20점이면 whlie문 break;
//			if (Pointraw.point[count]>=40 && Pointraw.point[count+5]<=30&&(Pointraw.point[count]-Pointraw.point[count+5])>=10 ||Pointraw.point[count]>=40 &&Pointraw.point[count+5]>=40 && (Pointraw.point[count]-Pointraw.point[count+5])>=20 ) break;
//			else if (Pointraw.point[count+5]>=40 && Pointraw.point[count]<=30&& (Pointraw.point[count+5]-Pointraw.point[count])>=10 ||Pointraw.point[count+5]>=40 && Pointraw.point[count]>=40 &&(Pointraw.point[count+5]-Pointraw.point[count])>=20) break;
			//point[count+5]>=40 && point[count]<=30&& (point[count+5]-point[count])>=10 ||point[count+5]>=40 && point[count]>=40 &&(point[count+5]-point[count])>=20
			if(team1.getScore() >= 40 || team2.getScore() >= 40) {
				if(team1.getScore() - team2.getScore() >= 20 || team2.getScore() - team1.getScore() >= 20 )
					System.out.println(team1.getScore());
				  System.out.println(team2.getScore());
					cnt[0]=0;
				cnt[1]=0;
				break;
			}
			// 두선수의 점수가 40점일때 듀스
			if(team1.getScore() >= 40 && team2.getScore() >= 40) {
				// 두선수의 점수차이가 20점이나면 2게임을 이긴거니까 break;
				if(team1.getScore() - team2.getScore() >= 20 || team2.getScore() - team1.getScore() >= 20 )
					System.out.println(team1.getScore());
				System.out.println(team2.getScore());
					cnt[0]=0;
				cnt[1]=0;break;
			} // if
		} // while
		//ArrayList<ArrayList> teamList = new ArrayList(); // 팀 정보값 2개해서 넘긴다.
		// 팀1리스트에는 팀1의 정보를 전부 담고 // 팀2리스트에는 팀2의 정보를 전부 담아서 그걸 다시 팀리스트에 넣어서 리턴
		ArrayList team1List = new ArrayList();
		Collections.addAll(team1List, team1.getTeamName(), team1.getScore() );
		ArrayList team2List = new ArrayList();
		Collections.addAll(team1List, team2.getTeamName(), team2.getScore() );
		ArrayList<ArrayList> teamList = new ArrayList();
		// 만약 팀1이 이길경우 팀1 리스트 0번값 // 팀2 리스트 1번값
		if(team1.getScore()  > team2.getScore()) {
			teamList.add(team1List);
			teamList.add(team2List);
			// 만약 팀2가 이길경우 팀2 리스트 0번값 // 팀1 리스트 1번값
		}else {
			teamList.add(team2List);
			teamList.add(team1List);
		}
		// 리스트 2개가 담겨있는 리스트로 반환
		return teamList;
	} // doublesGameWin()


	//	public ArrayList checkPoint() {   
	//
	//	      ArrayList duecePoint = new ArrayList();
	//
	//	      while (true) {
	//
	//	         if (getPlayer1Point() ==  40 && getPlayer2Point() ==  40) {               
	//	            System.out.println("Duece Point");
	//	         } else if (getPlayer1Point() ==  50 || getPlayer2Point() == 50 && getPlayer1Point() - getPlayer2Point() == 20){
	//	            System.out.println("player1Game Winner");
	//	         } else if (getPlayer1Point() ==  50 || getPlayer2Point() == 50 && getPlayer2Point() - getPlayer1Point() == 20){
	//	            System.out.println("player2Game Winner");
	//	         }
	//	         break;
	//	      }// while   
	//	      return duecePoint;
	//	   }      

	public ArrayList checkScore() {
		ArrayList dueceScore = new ArrayList();

		Player p1 = Tennis.list.get(0);
		Player p2 = Tennis.list.get(1);

		if(p1.getScore()==5 && p2.getScore()==5) {
			System.out.println("Duece Score");
		} else if (p1.getScore()==5 && p2.getScore()==5 && p1.getScore()-p2.getScore()==2) {
			System.out.println("player1Point Winner");
		} else if (p1.getScore()==5 && p2.getScore()==5 && p2.getScore()-p1.getScore()==2) {
			System.out.println("player2Point Winner");
		}

		return dueceScore;

	}


	public ArrayList winner() {

		ArrayList winnerList = new ArrayList();

		Player p1 = Tennis.list.get(0);
		Player p2 = Tennis.list.get(1);

		if(p1.getScore()==6 || p1.getScore()-p2.getScore()>=2) {
			System.out.println( "이번 게임의 승리: " + Tennis.list.get(0) );      
		} else if (p2.getScore()==6 || p2.getScore()-p1.getScore()>=2) {
			System.out.println( "이번 게임의 승리: " + Tennis.list.get(1) );      
		}      

		return winnerList;
	}


} // Game