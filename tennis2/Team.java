package tennis2;

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
    private boolean isTeamDoubles = false; //게임 타입이 true이면
    private Gender teamGender;

    public Team () {

    }
    
    public Team(String teamName, boolean isTeamDoubles) {
        this.teamName = teamName;
        this.isTeamDoubles = isTeamDoubles;
    }

	public Team(String teamName, HashMap team_list) {
		this.teamName = teamName;
		this.team_list = team_list;
	}

}
