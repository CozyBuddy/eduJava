package days16;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author user
 * @date 2024. 1. 22. 오전 10:15:00
 * @subject
 * @contents
 */
public class Ex01_02 {
	public static void main(String[] args) {
		String n = "KeNik";
		String m = "kknib"; //IntStream 공부 필요. 
		n = n.toUpperCase().chars().sorted().collect(StringBuilder ::new, StringBuilder::appendCodePoint, StringBuilder :: append)
		.toString();
		
		m = Stream.of(m.toUpperCase().split("")).sorted().collect(Collectors.joining());
		
		System.out.println(n.equals(m));
		
		
		
	}

}
