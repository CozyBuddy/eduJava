package days23;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 * @date 2024. 1. 31. 오전 11:06:47
 * @subject
 * @contents
 */
public class Ex03 {
	public static void main(String[] args) {
		LinkedHashSet<Person> lhs = new LinkedHashSet<>();
		lhs.add(new Person("admin","관리자",45));
		lhs.add(new Person("sunny","팀원",45));
		// 빌더 패턴 ( 생성자를 대신하는 어노테이션임)
		// 가독성, 생성자의 파라미터 순서 상관 없음.
		lhs.add(new Person().builder().id("hong").age(20).name("홍길동").build());
		
		// 출력
		Iterator<Person> ir = lhs.iterator();
		while (ir.hasNext()) {
			Person person = (Person) ir.next();
			System.out.println(person.getName());
		}
		
	}
	

}
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
class Person {
	private String id ,name ;
	private int age ;
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person )
			p = (Person)obj;
			return this.id.equals(p.id);
	}
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	
}
