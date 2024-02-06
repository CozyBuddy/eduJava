import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

// 두 명이 왔을 때 경기 처리하는 코드만 넘겨주면 될 듯
// 예외처리를 안에서 ?

// 뭐가 어찌됐던 간에 8명을 출력해서 보여주는 거니까

public class Rule {
    public boolean setGame() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean onemore;
            do {
                onemore = false; //
                int score = Integer.parseInt(br.readLine()) ;
                switch (score) {
                    case 1 :
                        setPlayer(false);
                        return selectedPlayer(2);
                    case 2 :
                        setPlayer(true);
                        return selectedPlayer(4);
                    default:
                        System.out.print("잘못된 입력값입니다. 계속 진행하려면 Y ");
                        onemore = true;
                }
            } while (onemore);
            return false;
    }

    public boolean selectedPlayer(int k) {
            int index = 0;
            boolean isGamePlay = false;
            int selectedNum ;
            ArrayList <Player> templist = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

                do {
                    for (int i = 0; i < k; i++) {
                        System.out.println("선택할 사람을 고르세요 ");
                        for (int j = 0; j < Tennis.list.size(); j++) {
                            // 꾸미기 .
                            System.out.println(Tennis.list.get(j));
                        }
                        selectedNum = scanner.nextInt();
                        templist.add(Tennis.list.get(selectedNum - 1));
                        Tennis.list.remove(selectedNum - 1);
                        index++;
                    }
                    /*if ( Tennis.list.get(0).getTeam().isTeamDoubles()){
                        isGamePlay = setRuleByGender(Tennis.list);
                    }
                    else*/
                    isGamePlay = setRuleByGender(Tennis.list.get(0),Tennis.list.get(1));
                } while (!isGamePlay);
            Tennis.list.clear();
            Tennis.list.addAll(templist);
            for (Player p1 :
                    templist) {
                System.out.print(p1.toString() +'\n');
            }

            return isGamePlay;
    }


    public void setPlayer(boolean isTeamDoubles) {

        if (isTeamDoubles) {
                //여기에 랜덤으로 이름하고 나이 넣고 그 다음에 ... 성별은 반반으로 해야 플레이가 됨

                Tennis.list.add(new Player("원대안",24,Gender.MAN, new Team("팀1", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.WOMAN, new Team("팀1", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.MAN, new Team("팀1", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.WOMAN, new Team("팀1", new HashMap<>())));
                //여기에 랜덤으로 이름하고 나이 넣고 그 다음에 ... 성별은 반반으로 해야 플레이가 됨
                Tennis.list.add(new Player("원대안",24,Gender.MAN, new Team("팀2", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.WOMAN, new Team("팀2", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.MAN, new Team("팀2", new HashMap<>())));
                Tennis.list.add(new Player("원대안",24,Gender.WOMAN, new Team("팀2", new HashMap<>())));

            for (int i = 0; i < Tennis.list.size(); i++) {
                if ( Tennis.list.get(i).getTeam().getTeamName().contains("팀1")) {
                    Tennis.list.get(i).getTeam().getTeam_list().put("팀1",Tennis.list.get(i).getPlayerName()) ;
                }
                else Tennis.list.get(i).getTeam().getTeam_list().put("팀2",Tennis.list.get(i).getPlayerName());
            }

        } else {
            for (int i = 0; i < 4; i++) {
                //여기에 랜덤으로 이름하고 나이 넣고 그 다음에 ... 성별은 반반으로 해야 플레이가 됨
                Tennis.list.add(new Player("원대안", 24, Gender.MAN, new Team()));
                Tennis.list.add(new Player("원대안",24,Gender.MAN,new Team()));
            }


        }



    }


    // 이거는 두 번째?? 에 붙여도 될 듯 흐름도를 지금 복식 단식 선택하고 선수 선택하고 그 다음에 혼합복식 아니면 단일복식 혹은 단식인지

    public boolean setRuleByGender(Player p1, Player p2) {
      switch (p1.getGender().name()) {
          case "MAN":
              if (p1.getGender().name().equals(p2.getGender().name())) {
                  System.out.println("남성 단식 진행 ");
                  return true;
              } else {
                  System.out.println("성별이 다르면 경기 진행이 불가합니다. ");
                  return false;
              }
          case "WOMAN":
              if (p1.getGender().name().equals(p2.getGender().name())) {
                  System.out.println("여성 단식 진행 ");
                  return true;
              } else {
                  System.out.println("성별이 다르면 경기 진행이 불가합니다. ");
                  return false;
              }
      }
      return false;
    }

    public boolean setRuleByGender(ArrayList<Player> list) {

        int index = 0;
        ArrayList <Player> tempList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if ( list.get(i).getGender().name().equals("MAN") )
                list.remove(i);
        }
        tempList.addAll(list);
        System.out.println(tempList);
        if ( !list.get(0).getTeamName().equals(list.get(1).getTeamName())) {
            System.out.print("팀을 다시 짜야합니다.");
        }
        return false;
    }



    public boolean isPlayerGenderSame() {

        return false;
    }

}
