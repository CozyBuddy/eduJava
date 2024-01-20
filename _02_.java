
public class _02_ {
 public static void main(String[] args) {
	String[] Array = new String[3];
	Array[0] = "java";
	Array[1] = "java";
	Array[2] = new String("java");
	
	System.out.println(Array[0]==Array[1]);
	System.out.println(Array[0]==Array[2]);
	System.out.println(Array[0].equals(Array[2]));
	
}

}
