package days24;

public class TeamVO {
	String name, leader;
	int totalNumber;

	public TeamVO(String name, int totalNumber, String leader) {
		super();
		this.name = name;
		this.totalNumber = totalNumber;
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public TeamVO(String name) {
		super();
		this.name = name;
	}

	public TeamVO() {
		super();
	}
	
	

}
