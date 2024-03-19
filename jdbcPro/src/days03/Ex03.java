package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.DisplayName;

import com.util.DBConn;

import domain.SalgradeVO;

public class Ex03 {
	public static void main(String[] args) {
     String sql ="select s.grade ,s.losal,s.hisal ,count(*) "+"cnt"
     		+ " from salgrade s right join emp e on  s.losal<= e.sal and s.hisal>=e.sal "
     		+ "group by s.grade ,s.losal,s.hisal order by s.grade";
		
     Connection conn = null ;
     PreparedStatement pst = null ;
     ResultSet rs = null ;
     SalgradeVO vo = null;
     ArrayList<SalgradeVO> list = null ;
     conn = DBConn.getConnection();
     try {
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		if (rs.next()) {
			list = new ArrayList<SalgradeVO>();
			do {
				vo = new SalgradeVO(rs.getInt("grade"), rs.getInt("losal"), rs.getInt("hisal"),rs.getInt("cnt"));
				list.add(vo);
			} while (rs.next());
			DispSalgrade(list);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			pst.close();
			DBConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     // 1.
     // 2.
     // 3.
     // 4.
	}

	private static void DispSalgrade(ArrayList<SalgradeVO> list) {
		Iterator<SalgradeVO> ir = list.iterator();
		while (ir.hasNext()) {
			SalgradeVO vo =  ir.next();
			System.out.printf("%d등급 ( %d ~ %d) - %d명\n",vo.getGrade(),vo.getLosal(),vo.getHisal(),vo.getCnt());
			
		}
		
	}

}