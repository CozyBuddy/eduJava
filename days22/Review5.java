package days22;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Review5 {
	LinkedHashSet a = new LinkedHashSet();
	a.

}
class Person {
	int id,age;
	String name;
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name);
	}
	
	
	
}
