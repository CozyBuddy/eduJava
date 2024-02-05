package days24;

public class Ex09 {

	public static void main(String[] args) {
		Direction dirArr[] = Direction.values();
		for (Direction dir : dirArr) {
			System.out.println(dir.name()+"/"+dir.ordinal()+"/"+dir.getSymbol()+"/"+dir.getValue());
		}
	}

}
//			  0     1    2     3				
//enum Direction { EAST,SOUTH,WEST,NORTH}
//	  100   200  300   400	
enum Direction { EAST(100, "▶"), SOUTH(200, "▼"), WEST(300, "◀"), NORTH(400,"▲") ;

	private final int value;
	private final String symbol;
	Direction(int value,String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	public int getValue() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}
	
}

/*2. 컴파일러가  클래스 변환
 *    class Direction extends Enum{
 *       static final Direction EAST = new Direction("EAST");
 *       static final Direction SOUTH = new Direction("SOUTH");
 *       static final Direction WEST = new Direction("WEST");
 *       static final Direction NORTH = new Direction("NORTH");
 *       
 *       private String name;
 *       public int name(){
 *         return this.name;
 *       }
 *       private int ordinal
 *       public int ordinal(){
 *         return this.ordinal;
 *       }
 *       private Dirction(String name){
 *          this.name = name;
 *       }
 *    }*/
