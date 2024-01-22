package days14;

public class Student { 
	public Student() {}
	public Student(String name, int kor, int eng, int math, int tot, int rank, double avg, int i,int wrank) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.rank = rank;
		this.avg = avg;
		this.i = i;
		this.wrank = wrank;
	}
	//field
		// 인스턴스 변수
	public String name; // alt +shift+s

	
	public int kor,eng,math,tot,rank,wrank;
	public double avg;
	public int i;
	
	
	/*//총점,평균,등수 method 
	void totalScore() {
		
	}*/
	public void dispInfo() {
		System.out.printf("%d번 \t%s\t%d\t%d\t%d\t%d\t%.2f\t%d등\n",
				i+1,name,kor,eng,
				math,tot,avg,rank);
	}
	

}
