package days05.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import days05.board.domain.BoardDTO;
import domain.EMPVO;

public class BoardDAOImpl implements BoardDAO {

	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	private ResultSet rs = null ;
	//생성자를 통한 DI
	public BoardDAOImpl(Connection conn) {
		this.conn = conn;
	}
	//2. Setter를 통한 DI
	public void BoardDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public ArrayList<BoardDTO> Sboard() throws SQLException {
		 	ArrayList<BoardDTO> al =new ArrayList<>();
			Long seq;
			String writer;
			String email;
			String title;
			int readed;
			Date writedate;
			String sql = "select seq,title,writer,email,writedate,readed from tbl_cstVSBoard order by seq desc";
			//PreparedStatement pst = null ;
			try {
				//           st = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				//           rs = st.executeQuery(sql);
				if (rs.next()) {
					
					do {
						seq = rs.getLong("seq");
						writer = rs.getString("writer");
						email = rs.getString("email");
						title = rs.getString("title");
						readed = rs.getInt("readed");
						writedate = rs.getDate("writedate");
						BoardDTO bd = BoardDTO.builder().seq(seq).title(title).writer(writer).email(email).writedate(writedate).readed(readed).build();
						al.add(bd);
					} while (rs.next());
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return al;
		}
	
	
	@Override
	public int Iboard(BoardDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}