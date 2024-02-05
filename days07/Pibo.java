package days07;

public class Pibo {
	public static void main(String[] args) {
		int x=1;
		int y=1;
		int sum = x+y;
		int z=0 ;
		System.out.print(x+"+"+y+"+");
		for (int i = 0; i < 8; i++) {
				z=x+y;
				x=y;
				y=z;
				sum +=z;
				System.out.print(z+"+");
			}
		System.out.println(sum);
		}
	}


