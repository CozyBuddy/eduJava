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
	public ArrayList<BoardDTO> searchService(int searchCondition, String searchWord) {
		ArrayList<BoardDTO> al = null ;
		//1.DB 처리 
		try {
			al = this.dao.Search(searchCondition,searchWord);
		} catch (SQLException e) {
			System.out.println("BoardDAO.Searchboard 에서 예외 발생");
			e.printStackTrace();
		}
		//2.로그 기록
		System.out.println("> 게시글 검색 : 로그 기록 작업");
		
		
		return al;
		
	}
	

}
