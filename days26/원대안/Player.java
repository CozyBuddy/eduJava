
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.HashMap;
@Getter
@Setter
@ToString
public class Player extends Team{

    private String playerName;
    private Team team;
    private int age ;
    private Gender gender;
    private HashMap<Set,Game> hashMap; //
    private int score;


    public Player() {
    }

    //단식일 때 처리값
    public Player(String playerName, int age, Gender gender, HashMap<Set,Game> hashMap) {
        this.playerName = playerName;
        this.age = age;
        this.gender = gender;
        this.hashMap = hashMap;

    }

    //복식일 때 처리값
    public Player(String playerName, int age, Gender gender, Team team){
      this.playerName = playerName;
      this.age = age;
      this.gender = gender;
      this.team = team;
    }
}

