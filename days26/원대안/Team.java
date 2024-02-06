import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@ToString
public class Team {
    private String teamName;
    private HashMap <String, String> team_list;
    private int score;
    private Gender teamGender;

    public Team () {

    }
    public Team(String teamName , HashMap <String, String> team_list) {
        this.teamName = teamName;
        this.team_list = team_list;
    }

}
