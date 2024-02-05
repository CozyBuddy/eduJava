package days26;

import java.util.Random;

public class Whowin {
	String team1;
	String team2;
	boolean whowin=false;
	String winteam = team2;
	
	
	public Whowin(String team1, String team2) {
		this.team1 = team1;
		this.team2 = team2;
		Random rd = new Random();
		if (rd.nextInt(2)==1) {
			this.whowin = true;
			this.winteam = team1;
		} else {
			this.whowin = false;
			this.winteam = team2;
		}
	}


	public boolean isWhowin() {
		return whowin;
	}


	public void setWhowin(boolean whowin) {
		this.whowin = whowin;
	}


	public String getWinteam() {
		return winteam;
	}


	public void setWinteam(String winteam) {
		this.winteam = winteam;
	}
	

		
	}
	
	
	
	
	
	


