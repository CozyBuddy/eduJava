package sec02.exam05;

public class MySqlDao implements DataAccessObject {
	public void select() {
		System.out.println("MySql DB에서 검색");
		
	}
	public void insert() {
		System.out.println("MySql DB에서 삽입");
		
	}
	public void update() {
		System.out.println("MySql DB를 수정");
		
	}
	public void delete() {
		System.out.println("MySql DB에서 삭제");
		
	}
}
