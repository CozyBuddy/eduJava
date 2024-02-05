package days17;

/**
 * @author user
 * @date 2024. 1. 23. 오전 10:52:28
 * @subject  싱글톤(Singleton) 패턴
 * @contents 장점,단점 오직 1개의 객체를 생성해서 사용하는 패턴
 */
public class Ex05 {
	public static void main(String[] args) {
		// A 작업자 BoardDAO 객체를 사용해서 DB처리(CRUD)
		//The constructor BoardDAO() is not visible
			BoardDAO dao1 = BoardDAO.getInstance();
			dao1.insert();
			System.out.print(dao1.hashCode()+" ");
		// B 작업자 				"
			BoardDAO dao2 = BoardDAO.getInstance();
			dao2.delete();
			System.out.print(dao2.hashCode()+" ");
		// C 작업자				"
			BoardDAO dao3 =BoardDAO.getInstance();
			dao3.update();
			System.out.print(dao3.hashCode()+" ");
		// D 작업자				"
			BoardDAO dao4 =BoardDAO.getInstance();
			dao4.select();
			System.out.print(dao4.hashCode()+" ");
	}

}
//DAO = Data Access Object
// DataBase <-> data CRUD(insert,update,delete,select) //create,read,update,delete
// 싱글톤 패턴 // 생성되는 인스턴스가 하나로 고정
class BoardDAO {
	//생성자의 접근지정자를 private로 수정
	// 해당 클래스 외부에서는 생성자를 호출할 수 없기에 
	// 객체 생성은 못한다.
	//1 . 생성자 private 선언 2. getinstance 를 public이고 static으로 선언함. 3. 자기 자신을 저장할 boardDao 필드 선언
	// 4. 싱글톤 개체를 만들적이 없으면 null 이면 참조 else 그대로 반환
	private BoardDAO() {}
	
	private static BoardDAO boardDao ; 
	
	public synchronized static BoardDAO getInstance() { //synchronized 동기화 처리된 메서드
		if (boardDao==null) {
			boardDao = new BoardDAO();
		} 
		return boardDao;
	}
	
	void insert() {
		System.out.println("추가");
	}
	void update() {
		System.out.println("수정");
	}
	void delete() {
		System.out.println("삭제");
	}
	void select() {
		System.out.println("조회");
	}
}
