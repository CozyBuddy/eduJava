package days26;

import java.util.ArrayList;

public class SetScore {
	ArrayList<Integer> al =new ArrayList<Integer>() ;
	int a;
	
	public SetScore(ArrayList<Integer> al) {
		
	}
	public ArrayList<Integer> getAl() {
		return al;
	}
	public void setAl(ArrayList<Integer> al) {
		this.al = al;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public SetScore(int a) {
		
		this.a = a;
		al.add(a);
	}
	public void initialize() {
        this.al = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            al.add(0);
        }
    }
	
	
	

}
