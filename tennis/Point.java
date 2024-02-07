package tennis;

import java.util.ArrayList;

public class Point {
    public static int  singlePointWin(int p){
        // 이긴사람과 몇점 획득했는지 정보를 담아서 Game의 메서드에서 호출해서 점수값 처리해준다.
        int score = 10;
        int n = 0;
        // p가 1이면 player1의 승리 player1의 이름과 점수를 리턴하는 함수
        // score값이 15 15 10 10 10... 증가해야하는데 어떤 플레이어가 몇번 이겼는지 카운트 해야한다.
        System.out.println();
        if(p==1) {
            //Tennis.list.get(0).setScore( score);
            Tennis.list.get(0).setScore(Tennis.list.get(0).getScore() + score);
            return 0;
        }else {
            Tennis.list.get(1).setScore(Tennis.list.get(1).getScore() + score);
            //Tennis.list.get(1).setScore(score);
            return 1;
        }

    }

    public static int doublesPointWin(int p){
        // 이긴사람과 몇점 획득했는지 정보를 담아서 Game의 메서드에서 호출해서 점수값 처리해준다.
        int score = 10;
        // p == 1이면 player1이 이긴게임
        if(p==1) {
            // 팀에 따른 이름을 넣어서 리턴해야할듯
            //
            Tennis.list.get(0).getTeam().setScore(Tennis.list.get(0).getTeam().getScore() + score);
           // Tennis.list.get(0).getTeam().setScore( score);
            //System.out.println(Tennis.list.get(0).getTeam().getScore());
            return 0;
        } else {
            // 팀에 따른 이름을 넣어서 리턴해야할듯
            Tennis.list.get(2).getTeam().setScore(Tennis.list.get(2).getTeam().getScore() + score);
            //Tennis.list.get(2).getTeam().setScore( score);

            //System.out.println(Tennis.list.get(1).getTeam().getScore());
            return 2;
        }
    }
}
