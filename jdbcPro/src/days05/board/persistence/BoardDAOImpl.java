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
	//3. Getter
	public Connection getConn() {
		return this.conn;
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
		// writedate default sysdate
		// readed default 0
		int rowcount = 0;
		String sql = "insert into tbl_cstVSBoard (seq,writer,pwd,email,title,tag,content) values "
				+ "(seq_tbl_cstVSBoard.nextval, ? ,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getWriter());
		pstmt.setString(2, dto.getPwd());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getTitle());
		pstmt.setInt(5, dto.getTag());
		pstmt.setString(6, dto.getContent());
		
		
		rowcount = pstmt.executeUpdate();
		pstmt.close();
		
		return rowcount;
	}
	@Override
	public int increasereaded(long seq) throws SQLException {
		String sql = "update tbl_cstvsboard set readed = readed +1 where seq= ? ";
		int rowcount = 0 ;
		this.pstmt = conn.prepareStatement(sql);
		this.pstmt.setLong(1, seq);
		rowcount = this.pstmt.executeUpdate();
		return rowcount;
	}
	@Override
	public BoardDTO view(long seq) throws SQLException {
		BoardDTO dto = null;
		String writer;
		String email;
		String title;
		int readed;
		Date writedate;
		String content;
		String sql = "select seq,title,writer,email,writedate,readed,content from tbl_cstVSBoard where seq = ?";
		//PreparedStatement pst = null ;
		try {
			//           st = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			//           rs = st.executeQuery(sql);
			if (rs.next()) {
					seq = rs.getLong("seq");
					writer = rs.getString("writer");
					email = rs.getString("email");
					title = rs.getString("title");
					readed = rs.getInt("readed");
					writedate = rs.getDate("writedate");
					content = rs.getString("content");
					dto = BoardDTO.builder().seq(seq).title(title).writer(writer).email(email).writedate(writedate).readed(readed).content(content).build();
					
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
		return dto;
	}
	@Override
	public int delete(long seq) throws SQLException {
		int rowcount = 0;
		String sql = "delete from tbl_cstvsboard where seq = ?";
		this.pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, seq);
		rowcount = pstmt.executeUpdate();
		pstmt.close();
		return rowcount;
	}
	@Override
	public int update(BoardDTO dto) throws SQLException {
		int rowcount = 0;
		String sql = "update tbl_cstVSBoard set email = ?,title = ? ,content = ? where seq = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getEmail());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getContent());
		pstmt.setLong(4, dto.getSeq());
		rowcount = pstmt.executeUpdate();
		pstmt.close();
		
		return rowcount;
		
	}
	@Override
	public ArrayList<BoardDTO> Search(int currentpage ,int searchCondition, String searchWord) {
		ArrayList<BoardDTO> al = new ArrayList<BoardDTO>();
		Long seq;
		String writer;
		String email;
		String title;
		int readed;
		Date writedate;
		String sql = 
				"SELECT * FROM (\r\n"
				+ "select rownum AS rnum,t.*\r\n"
				+ "from (select seq,title,writer,email,writedate,readed,content from tbl_cstVSBoard ";
		  
		switch ( searchCondition) {
	      case 1:  // 제목
	         sql += " WHERE REGEXP_LIKE( title, ?, 'i') ";
	         break;
	      case 2: // 내용
	         sql += " WHERE REGEXP_LIKE( content, ?, 'i') ";
	         break;
	      case 3: // 작성자
	         sql += " WHERE REGEXP_LIKE( writer, ?, 'i') ";
	         break;         
	      case 4: // 제목 + 내용 
	         sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR  REGEXP_LIKE( content, ?, 'i') ";
	         break;
	      case 5: // 제목 + 내용 + 작성자 
		         sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR  REGEXP_LIKE( content, ?, 'i')  or  REGEXP_LIKE( writer, ?, 'i') ";
		         break;
	      } // switch
		  sql += " order by seq desc) t)\r\n"
					+ " where rnum between ? and ? " ;
		//PreparedStatement pst = null ;
		try {
			//           st = conn.createStatement();
			
			pstmt = conn.prepareStatement(sql);
			switch (searchCondition) {
		             
		      case 4: // 제목 + 내용 
		    	  pstmt.setString(1, searchWord);
		    	  pstmt.setString(2, searchWord);
		    	  pstmt.setInt(3, 10*(currentpage-1)+1);
		    	  pstmt.setInt(4,10*(currentpage-1)+10 );
		    	  break;
		      case 5: // 제목 + 내용 
		    	  pstmt.setString(1, searchWord);
		    	  pstmt.setString(2, searchWord);
		    	  pstmt.setString(3, searchWord);
		    	  pstmt.setInt(4,10*(currentpage-1)+1);
		    	  pstmt.setInt(5, 10*(currentpage-1)+10 );
		    	  break;
		    	  default : 
		    	  pstmt.setString(1, searchWord);
		    	  pstmt.setInt(2, 10*(currentpage-1)+1);
		    	  pstmt.setInt(3, 10*(currentpage-1)+10 );
		    	 
		    	  break;
		      }
		
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
	public ArrayList<BoardDTO> Sboard(int currentpage, int numberperpage) throws SQLException {
		ArrayList<BoardDTO> al =new ArrayList<>();
		int rownum;
		Long seq;
		String writer;
		String email;
		String title;
		int readed;
		Date writedate;
		String sql = "select b.*  "
				+ "from (select rownum no,t.* " 
				+ "from   "
				+ "(select seq,title,writer,email,writedate,readed from tbl_cstVSBoard order by seq desc) t ) b "
				+ "where no between ? and ? ";
		//PreparedStatement pst = null ;
		try {
			//           st = conn.createStatement();
			int start = (currentpage-1)*(numberperpage) +1;
			int end = start + numberperpage-1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			//           rs = st.executeQuery(sql);
			if (rs.next()) {
				
				do {
					rownum = rs.getInt("no");
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
	public int gettotalpages(int numberperpage) throws SQLException {
		int totalpages = 0 ;
		String sql = "select ceil(count(*)/?) from tbl_cstvsboard";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, numberperpage);
		rs = this.pstmt.executeQuery();
		if (rs.next()) {
			totalpages = rs.getInt(1);
		}
		rs.close();
		this.pstmt.close();
		return totalpages;
	}
	@Override
	public int gettotalrecords() throws SQLException {
		int totalrecords = 0 ;
		String sql = "select count(*) from tbl_cstvsboard";
		this.pstmt = this.conn.prepareStatement(sql);
		rs = this.pstmt.executeQuery();
		if (rs.next()) {
			totalrecords = rs.getInt(1);
		}
		rs.close();
		this.pstmt.close();
		return totalrecords;
	}
	@Override
	public int totalsearchpages(int searchCondition, String searchWord) throws SQLException {
		int a = 0;
		Long seq;
		String writer;
		String email;
		String title;
		int readed;
		Date writedate;
		String sql = "select seq,title,writer,email,writedate,readed from tbl_cstVSBoard ";
		// 조건절 삽입
		switch ( searchCondition) {
	      case 1:  // 제목
	         sql += " WHERE REGEXP_LIKE( title, ?, 'i') ";
	         break;
	      case 2: // 내용
	         sql += " WHERE REGEXP_LIKE( content, ?, 'i') ";
	         break;
	      case 3: // 작성자
	         sql += " WHERE REGEXP_LIKE( writer, ?, 'i') ";
	         break;         
	      case 4: // 제목 + 내용 
	         sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR  REGEXP_LIKE( content, ?, 'i') ";
	         break;
	      case 5: // 제목 + 내용 + 작성자 
		         sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR  REGEXP_LIKE( content, ?, 'i')  or  REGEXP_LIKE( writer, ?, 'i')";
		         break;
	      } // switch
		sql+= "order by seq desc";
		//PreparedStatement pst = null ;
		try {
			//           st = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			switch ( searchCondition) {
		             
		      case 4: // 제목 + 내용 
		    	  pstmt.setString(1, searchWord);
		    	  pstmt.setString(2, searchWord);
		    	  break;
		      case 5: // 제목 + 내용 
		    	  pstmt.setString(1, searchWord);
		    	  pstmt.setString(2, searchWord);
		    	  pstmt.setString(3, searchWord);
		    	  break;
		    	  default : pstmt.setString(1, searchWord);
		    	  break;
		      }
			rs = pstmt.executeQuery();
			//           rs = st.executeQuery(sql);
			if (rs.next()) {
				
				do { 
					a= a+1;
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
		return a;
	}
	
	

	
	
	

}
