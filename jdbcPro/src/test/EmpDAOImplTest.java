package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.util.DBConn;

import domain.EMPVO;
import persistence.EmpDAO;
import persistence.EmpDAOImpl;

class EmpDAOImplTest {

	@Test //단위 테스트 할 수 있음.
	/*void test() {
		Connection conn = DBConn.getConnection();
		EmpDAO dao = new EmpDAOImpl(conn);
		//fail("Not yet implemented");
		ArrayList<EMPVO> al = dao.getEmpS();
		//출력확인
		System.out.println("사원수 : "+al.size());
		DBConn.close();
	}*/
	void test() {
		Connection conn = DBConn.getConnection();
		EmpDAO dao = new EmpDAOImpl(conn);
		//fail("Not yet implemented");
		java.sql.Date hiredate = java.sql.Date.valueOf("1991-11-01");
		EMPVO vo = new EMPVO(9999, "sadf", "nojob", 7366, hiredate, 4000, 0, 10);
		int rowCount = dao.addEmp(vo);
		//출력확인
		if (rowCount==1) {
			System.out.println("사원 추가 성공");
		}
		DBConn.close();
	}

}
