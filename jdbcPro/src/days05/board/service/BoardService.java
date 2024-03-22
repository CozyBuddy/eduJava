package days05.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import days05.board.domain.BoardDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;
import lombok.Getter;
@Getter
public class BoardService {
	private BoardDAO dao = null ; 
	
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	// 1. 게시글 목록 조회 서비스
	public ArrayList<BoardDTO> Sselect(){
		ArrayList<BoardDTO> al = null ;
		//1.DB 처리 
		try {
			al =this.dao.Sboard();
		} catch (SQLException e) {
			System.out.println("BoardDAO.Sselect 에서 예외 발생");
			e.printStackTrace();
		}
		//2.로그 기록
		System.out.println("> 게시글 목록 조회 : 로그 기록 작업");
		
		
		return al;
	};
	// 2. 게시글 쓰기
	public int InsertS(BoardDTO dto){
		int rowcount = 0;
	
		//1.DB 처리 
		try {
			rowcount =this.dao.Iboard(dto);
		} catch (SQLException e) {
			System.out.println("BoardDAO.Sselect 에서 예외 발생");
			e.printStackTrace();
		}
		//2.로그 기록
		System.out.println("> 게시글 쓰기 : 로그 기록 작업");
		
		
		return rowcount;
	};
	//3. 게시글 상세보기
	public BoardDTO detailview(int seq) {
		BoardDTO dto = null;
		BoardDAOImpl dao2 = (BoardDAOImpl) this.dao;
		Connection conn = dao2.getConn();
		try {
			
			conn.setAutoCommit(false);
			this.dao.increasereaded(seq);
			/*System.out.println("1번 게시글 조회수 : "+ rowcount);
			throw new SQLException("이유 없는 SQL예외 발생");*/
			dto = this.dao.view(seq);
			//3.로그기록
			System.out.println("> 게시글 보기 : 로그 기록 작업");
			conn.commit();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return dto;
	}
	
	//4. 게시글 삭제
	public int delete(int seq) {
		int rowcount = 0 ;
		//1. DB 처리
		try {
			rowcount = this.dao.delete(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. 로그기록
		System.out.println("게시글 삭제 : 로그 기록 작업 ");
		return rowcount;
		
	}
	//5. 게시글 수정
	public int update(BoardDTO dto) {
		int rowcount = 0 ;
		try {
			rowcount = dao.update(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;
		
	}
	//6. 게시글 검색 서비스
	public ArrayList<BoardDTO> searchService(int currentpage , int searchCondition, String searchWord) {
		ArrayList<BoardDTO> al = null ;
		//1.DB 처리 
		try {
			al = this.dao.Search(currentpage,searchCondition,searchWord);
		} catch (SQLException e) {
			System.out.println("BoardDAO.Searchboard 에서 예외 발생");
			e.printStackTrace();
		}
		//2.로그 기록
		System.out.println("> 게시글 검색 : 로그 기록 작업");
		
		
		return al;
		
	}
	//7. 게시글 페이징 목록 처리
	
		public ArrayList<BoardDTO> Sselect(int currentpage , int numberperpage){
			ArrayList<BoardDTO> al = null ;
			//1.DB 처리 
			try {
				al =this.dao.Sboard(currentpage ,numberperpage);
			} catch (SQLException e) {
				System.out.println("BoardDAO.Sselect 에서 예외 발생");
				e.printStackTrace();
			}
			//2.로그 기록
			System.out.println("> 게시글 목록 조회 : 로그 기록 작업");
			
			
			return al;
		};
		
		// "1 2 3 4 5 6 7 8 9 10 " 페이징 처리 문자열로 반환하는 메서드 
		public String pageservice(int currentpage, int numberperpage , int numberofpageblock) {
			String pageblock = "\t\t\t";
			int totalpages = 0 ;
			try {
				totalpages = this.dao.gettotalpages(numberperpage);
				int start = (int)currentpage/(numberperpage+1)* numberofpageblock +1;
				int end = start + numberofpageblock-1;
				if (end > totalpages) {
					end = totalpages;
				}
				System.out.printf("cureentpage = %d start =%d end %d ",currentpage,start,end);
				if (start != 1 ) {
					pageblock += " < ";
				}
				for (int i = start; i <= end; i++) {
					pageblock += String.format(i==currentpage ?"[%d]" : "%d ", i);
				}
				if (end !=totalpages) { pageblock += " > ";
					
				}
				System.out.println();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return pageblock ; 
		}
		// 검색한 게시글 숫자 계산
		public String searchc(int currentpage ,int searchCondition, String searchWord) {
			String pageblock = "\t\t\t";
			int total = 0 ;
			try {
				total = this.dao.totalsearchpages(searchCondition, searchWord);
				int start = ((int)currentpage/10) *10 +1;
				int end =  (int) Math.ceil((int)total/10);
				if (end > total) {
					end = total;
				}
				System.out.printf("cureentpage = %d start =%d end %d ",currentpage,start,end);
				if (start != 1 ) {
					pageblock += " < ";
				}
				for (int i = start; i <= end; i++) {
					pageblock += String.format(i==currentpage ?"[%d]" : "%d ", i);
				}
				if (end !=total) { pageblock += " > ";
					
				}
				System.out.println();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return pageblock ; 
		}

}
