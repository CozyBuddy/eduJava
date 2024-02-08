package tennisProject;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Displ {

	HashMap<String, LinkedHashMap<String, String>> dispList;
	Team team_List;

	public Displ() throws IOException, InterruptedException {
		dispMenu();
		
	}
	
	public void dispMenu() throws InterruptedException {
		System.out.print("테니스 게임을 시작합니다.");

		Rule rule = new Rule();
		char con = 'n';
		int n = 0;
		int sum1 = 0, sum2 = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				
				System.out.print(" 1.단식 , 2.복식 ");
				if (rule.setGame()) {
					do {
					// 여기서 복식 단식이 결정되서 들어오면
					// 조건문 줘서 단식일 경우 game.singlesGameWin();
					// 복식일경우 game.doublesGameWin();
					for (int i = 0; i < 5; i++) {
						sum1 += Pointraw.sets[i];
						sum2 += Pointraw.sets[i+5];
					}
					if(sum1 == 3 || sum2 == 3)break;
						
					Game game = new Game();
					//game.singlesGameWin();
					game.doublesGameWin();
					for (Player player : Tennis.list) {
						System.out.println(player);
					}			
					/*System.out.println("계속 진행하시려면 y를 눌러주세요 ");
					con = (char) System.in.read();
					System.in.skip(System.in.available());*/
					sum1 = 0;
					sum2 = 0;
					// 반복문을 이기는 사람이 나올때 까지
					// 5게임 == 3set 이겼을때 반복문 빠져나가도록
					// 3게임 == 2set 이겼을때 반복문 빠져나가도록
				} while (true);
					OutputData.Outputdata();
				} else {
					System.out.println("세팅한 룰이 성립하지 않습니다. ");
				}
//				for (int i = 0; i < 5; i++) {
//					sum1 += Pointraw.sets[i];
//					sum2 += Pointraw.sets[i+5];
//				}
//				if(sum1 == 3 || sum2 == 2)break;
//					
//				Game game = new Game();
////				game.singlesGameWin();
//				game.doublesGameWin();
//				for (Player player : Tennis.list) {
//					System.out.println(player);
//				}			
//				System.out.println("계속 진행하시려면 y를 눌러주세요 ");
//				con = (char) System.in.read();
//				System.in.skip(System.in.available());
//				sum1 = 0;
//				sum2 = 0;
//			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램을 종료합니다. ");
	}
}


//팀 혹은 사용자를 주면 댐
// 사용자 두 명 주면, 포인트값에 맞춰서 올림

// 매개변수로 선수 1번의 이름과 점수 선수 2번의 이름과 점수값이 들어오면(팀경기일때는 팀1, 팀2가 들어오면)
// public void dipsScore(Player p1, Player p2, int c, int d) {
//        count2++;
//        point[count] += c;
//        point[count + 5] += d;
//        alpoint.add(point[count]);
//        alpoint.add(point[count + 5]);
//        System.out.println("*".repeat(80));
//        System.out.println("* *        *" + " ".repeat(67) + "*");
//        System.out.println("*   *" + "  세트 *" + " ".repeat(10) + "I" + " ".repeat(10) + "II" + " ".repeat(10) + "III" + " ".repeat(10) + "IV" + " ".repeat(10) + "V" + " ".repeat(8) + "*");
//        System.out.println("*      *   *" + " ".repeat(67) + "*");
//        System.out.println("*   팀    **" + " ".repeat(68) + "*");
//        System.out.println("*".repeat(80));
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*         *" + " ".repeat(10) + games[0] + " ".repeat(11) + games[1] + " ".repeat(11) + games[2] + " ".repeat(11) + games[3] + " ".repeat(11) + games[4] + "         *");
//        System.out.println("*  " + p1.getPlayerName() + "   *" + " ".repeat(8) + "(" + point[0] + ")" + " ".repeat(9) + "(" + point[1] + ")" + " ".repeat(9) + "(" + point[2] + ")" + " ".repeat(9) + "(" + point[3] + ")" + " ".repeat(9) + "(" + point[4] + ")" + "        *");
//
//
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*".repeat(80));
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*         *" + " ".repeat(10) + games[5] + " ".repeat(11) + games[6] + " ".repeat(11) + games[7] + " ".repeat(11) + games[8] + " ".repeat(11) + games[9] + "         *");
//
//        System.out.println("*  " + p2.getPlayerName() + "   *" + " ".repeat(9) + "(" + point[5] + ")" + " ".repeat(9) + "(" + point[6] + ")" + " ".repeat(9) + "(" + point[7] + ")" + " ".repeat(9) + "(" + point[8] + ")" + " ".repeat(9) + "(" + point[9] + ")" + "        *");
//
//        System.out.println("*         *" + " ".repeat(68) + "*");
//        System.out.println("*".repeat(80));
//
//        if (point[count] >= 40 && point[count + 5] <= 30 && (point[count] - point[count + 5]) >= 10 || point[count] >= 40 && point[count + 5] >= 40 && (point[count] - point[count + 5]) >= 20) {
//            System.out.println("이 게임 승자는" + p1.getPlayerName() + "팀");
//            point[count] = 0;
//            point[count + 5] = 0;
//            games[count]++;
//
//            if (games[count] == 6) {
//                System.out.println("이 세트 승자는" + p1.getPlayerName() + "팀");
//                count++;
//                sets[count]++;
//            }
//        } else if (point[count + 5] >= 40 && point[count] <= 30 && (point[count + 5] - point[count]) >= 10 || point[count + 5] >= 40 && point[count] >= 40 && (point[count + 5] - point[count]) >= 20) {
//            System.out.println("이 게임 승자는" + p2.getPlayerName() + "팀");
//            point[count] = 0;
//            point[count + 5] = 0;
//            games[count + 5]++;
//            if (games[count + 5] == 6) {
//                System.out.println("이 세트 승자는" + p2.getPlayerName() + "팀");
//                count++;
//                sets[count + 5]++;
//            }
//        }
//
//       for (int i = count; i < 10; i++) {
//			al1.add(0);
//
//		}
//		for (int i = count; i < 10; i++) {
//			al2.add(0);
//
//		}
//
//
//        System.out.print("*     *"+" ".repeat(12)+a+" ".repeat(15)+":"+" ".repeat(14)+b+" ".repeat(14)+"*\n");
//
//
//    }

  /*  public void dipsScore(Team team1, Team team2, int c, int d) {
        count2++;
        point[count] += c;
        point[count + 5] += d;
        alpoint.add(point[count]);
        alpoint.add(point[count + 5]);
        System.out.println("*".repeat(80));
        System.out.println("* *        *" + " ".repeat(67) + "*");
        System.out.println("*   *" + "  세트 *" + " ".repeat(10) + "I" + " ".repeat(10) + "II" + " ".repeat(10) + "III" + " ".repeat(10) + "IV" + " ".repeat(10) + "V" + " ".repeat(8) + "*");
        System.out.println("*      *   *" + " ".repeat(67) + "*");
        System.out.println("*   팀    **" + " ".repeat(68) + "*");
        System.out.println("*".repeat(80));
        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*         *" + " ".repeat(10) + games[0] + " ".repeat(11) + games[1] + " ".repeat(11) + games[2] + " ".repeat(11) + games[3] + " ".repeat(11) + games[4] + "         *");
        System.out.println("*  " + team1.getTeamName() + "   *" + " ".repeat(8) + "(" + point[0] + ")" + " ".repeat(9) + "(" + point[1] + ")" + " ".repeat(9) + "(" + point[2] + ")" + " ".repeat(9) + "(" + point[3] + ")" + " ".repeat(9) + "(" + point[4] + ")" + "        *");


        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*".repeat(80));
        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*         *" + " ".repeat(10) + games[5] + " ".repeat(11) + games[6] + " ".repeat(11) + games[7] + " ".repeat(11) + games[8] + " ".repeat(11) + games[9] + "         *");

        System.out.println("*  " + team2.getTeamName() + "   *" + " ".repeat(9) + "(" + point[5] + ")" + " ".repeat(9) + "(" + point[6] + ")" + " ".repeat(9) + "(" + point[7] + ")" + " ".repeat(9) + "(" + point[8] + ")" + " ".repeat(9) + "(" + point[9] + ")" + "        *");

        System.out.println("*         *" + " ".repeat(68) + "*");
        System.out.println("*".repeat(80));

        if (point[count] >= 40 && point[count + 5] <= 30 && (point[count] - point[count + 5]) >= 10 || point[count] >= 40 && point[count + 5] >= 40 && (point[count] - point[count + 5]) >= 20) {
            System.out.println("이 게임 승자는" + team1.getTeamName() + "팀");
            point[count] = 0;
            point[count + 5] = 0;
            games[count]++;

            if (games[count] == 6) {
                System.out.println("이 세트 승자는" + team1.getTeamName() + "팀");
                count++;
                sets[count]++;
            }
        } else if (point[count + 5] >= 40 && point[count] <= 30 && (point[count + 5] - point[count]) >= 10 || point[count + 5] >= 40 && point[count] >= 40 && (point[count + 5] - point[count]) >= 20) {
            System.out.println("이 게임 승자는" + team2.getTeamName() + "팀");
            point[count] = 0;
            point[count + 5] = 0;
            games[count + 5]++;
            if (games[count + 5] == 6) {
                System.out.println("이 세트 승자는" + team2.getTeamName() + "팀");
                count++;
                sets[count + 5]++;
            }
        }
    }
}*/

/*for (int i = count; i < 10; i++) {
			al1.add(0);

		}
		for (int i = count; i < 10; i++) {
			al2.add(0);

		}*/



//System.out.print("*     *"+" ".repeat(12)+a+" ".repeat(15)+":"+" ".repeat(14)+b+" ".repeat(14)+"*\n");





// BufferedReader 써서 올려도 괜찮을 듯

