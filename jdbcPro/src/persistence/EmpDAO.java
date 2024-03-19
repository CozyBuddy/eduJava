package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import domain.EMPVO;
import domain.Viewvo;

public interface EmpDAO { //DAO 는 입력받지 않음.
		//1. 사원정보 조회 추상메서드
		public abstract ArrayList<EMPVO> getEmpS();
		//2. 사원정보 추가 추상메서드
		int addEmp(EMPVO vo);
		//3. 사원 수정
		int upEmp(EMPVO vo);
		//4. 사원 삭제
		int delEmp(int empno);
		int delEmp(ArrayList<Integer> empnos);
		//5. 사원 검색
		ArrayList<EMPVO> searchEmp(int searchCondition, String searchWord);
		//6. 한 사원 정보
		EMPVO getEmp(int empno);
}