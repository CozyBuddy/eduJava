package days05.board.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import days05.board.domain.BoardDTO;


public interface BoardDAO {
	
		
	// 1.게시글 목록 조회 + 페이징 처리 X 
	public abstract ArrayList<BoardDTO> Sboard() throws SQLException;
	// 1-1 게시글 목록 조회 + 페이징 처리 
	public abstract ArrayList<BoardDTO> Sboard(int currentpage, int numberperpage) throws SQLException;
	// 2.게시글 쓰기
	int Iboard (BoardDTO dto) throws SQLException;
	
	//3. 게시글 상세보기 - 조회수 증가
	int increasereaded(long seq) throws SQLException ; 
	//3-2. 상세 보기 
	BoardDTO view(long seq) throws SQLException ; 
	//4. 게시글 삭제
	int delete(long seq) throws SQLException;
	//5 .게시글 수정
	//int update(long seq,String title, String content, String email) throws SQLException;
	int update(BoardDTO dto) throws SQLException;
	
	// 6. 게시글 검색
	public abstract ArrayList<BoardDTO> Search(int currentpage , int searchCondition, String searchWord) throws SQLException;
	// 7 . 총 페이지 수 계산
	int gettotalpages(int numberperpage) throws SQLException;
	
	// 8 . 총 게시글 수 계산
	int gettotalrecords() throws SQLException;
	
	// 9 . 총 검색 페이지 수 계산
	int totalsearchpages (int searchCondition, String searchWord) throws SQLException;
	

	
	
}
