package days05.baord.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.service.BoardService;

public class BoardController {
	private Scanner sc = null ;
	private int selectedNumber ;
	private BoardService service ;
	
	public BoardController() {
		super();
		this.sc = new Scanner(System.in);
	}
	
	public BoardController(BoardService service) {
		this(); //  scanner 객체도 호출하기위해서 
		this.service = service ;
	}
	//게시판 기능을 사용
	public void boardstart() {
		while (true) {
			메뉴출력();
			메뉴선택();
			메뉴처리();
		}
	}

	private void 메뉴처리() {
		switch (this.selectedNumber) {
	      case 1:// 새글   
	         새글쓰기();
	         break;
	      case 2:// 목록
	         목록보기();
	         break;
	      case 3:// 보기
	         상세보기();
	         break;
	      case 4:// 수정
	         수정하기();
	         break;
	      case 5:// 삭제
	         삭제하기();
	         break;
	      case 6:// 검색
	         검색하기();
	         break;
	      case 7:// 종료   
	         exit();
	         break; 
	      } // switch
		일시정지();
	}

	private void 검색하기() {
		System.out.print(
				"> 검색 조건 : 제목(1) , 내용(2), 작성자(3), 제목+내용(4) ,제목+내용+작성자(5) 선택  ? ");
				      int searchCondition = this.sc.nextInt();
				      System.out.print("> 검색어 입력 ? ");
				      String searchWord = this.sc.next();
			
						ArrayList<BoardDTO> al = this.service.searchService(searchCondition,searchWord);
						// 뷰(View)-출력담당
					      System.out.println("\t\t\t  게시판");
					      System.out.println("-------------------------------------------------------------------------");
					      System.out.printf("%s\t%-30s\t%s\t%-10s\t%s\n", 
					            "글번호","글제목","글쓴이","작성일","조회수");
					      System.out.println("-------------------------------------------------------------------------");
					      if (al==null) {
							System.out.println("더 이상의 게시글이 존재하지 않습니다.");
						} else {
							Iterator<BoardDTO> ir = al.iterator();
						while (ir.hasNext()) {
							BoardDTO dto =  ir.next();
							System.out.printf("%d\t%-30s  %s\t%-10s\t%d\n",
					                  dto.getSeq(), 
					                  dto.getTitle(),
					                  dto.getWriter(),
					                  dto.getWritedate(),
					                  dto.getReaded());   
						}
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("\t\t\t [1] 2 3 4 5 6 7 8 9 10 >"); 
						System.out.println("-------------------------------------------------------------------------");
						}
						
				      
	}

	private void 삭제하기() {
		System.out.print("삭제하려는 글 번호를 입력하세요.");
		int seq = sc.nextInt();
		int rowcount = this.service.delete(seq);
		if (rowcount ==1 ) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("해당하는 글이 존재하지 않습니다.");
		}
		
		
	}

	private void 수정하기() {
		System.out.print("수정할 글번호를 입력하세요");
		int seq = sc.nextInt();
		// 1. 원래 게시글 정보를 출력
		BoardDTO dto = null;
		try {
			dto = this.service.getDao().view(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dto == null ) {
			System.out.println("해당하는 게시글이 없습니다.");
			return ;
		} else {
		 System.out.println("\tㄱ. 글번호 : " + seq );
	      System.out.println("\tㄴ. 작성자 : " + dto.getWriter() );
	      System.out.println("\tㄷ. 조회수 : " + dto.getReaded() );
	      System.out.println("\tㄹ. 글제목 : " + dto.getTitle() );
	      System.out.println("\tㅁ. 글내용 : " + dto.getContent() );
	      System.out.println("\tㅂ. 작성일 : " + dto.getWritedate() );

	    
		}
		// 2. 
		System.out.print("수정할 이메일 주소를 입력하세요.");
		String email = sc.next();
		sc.nextLine();
		System.out.println("수정할 제목을 입력하세요.");
		String title = sc.next();
		sc.nextLine();
		System.out.println("수정할 내용을 입력하세요.");
		String content = sc.next();
		sc.nextLine();
		dto = BoardDTO.builder().seq(seq).email(email).title(title).content(content).build();
		int rowcount = this.service.update(dto);
		if (rowcount==1) {
			System.out.println("수정이 완료되었습니다.");
		}
	}

	private void 상세보기() {
			
			System.out.print(" 보려는 글의 번호를 입력하세요. ");
			selectedNumber = sc.nextInt();
		
			BoardDTO dto  = this.service.detailview(selectedNumber);
			if (dto == null ) {
				System.out.println("해당하는 게시글이 없습니다.");
				return ;
			} else {
			 System.out.println("\tㄱ. 글번호 : " + selectedNumber );
		      System.out.println("\tㄴ. 작성자 : " + dto.getWriter() );
		      System.out.println("\tㄷ. 조회수 : " + dto.getReaded() );
		      System.out.println("\tㄹ. 글제목 : " + dto.getTitle() );
		      System.out.println("\tㅁ. 글내용 : " + dto.getContent() );
		      System.out.println("\tㅂ. 작성일 : " + dto.getWritedate() );

		      System.out.println("\t\n [수정] [삭제] [목록(home)]");
			}
		   
		}
	
	//페이징 처리 필요한 필드 선언
	private int currentpage = 1;
	private void 목록보기() {
		System.out.print("보고싶은 페이지번호를 입력하세요.");
		this.currentpage = sc.nextInt();
		ArrayList<BoardDTO> al = this.service.Sselect();
		// 뷰(View)-출력담당
	      System.out.println("\t\t\t  게시판");
	      System.out.println("-------------------------------------------------------------------------");
	      System.out.printf("%s\t%-40s\t%s\t%-10s\t%s\n", 
	            "글번호","글제목","글쓴이","작성일","조회수");
	      System.out.println("-------------------------------------------------------------------------");
	      if (al==null) {
			System.out.println("더 이상의 게시글이 존재하지 않습니다.");
		} else {
			Iterator<BoardDTO> ir = al.iterator();
		while (ir.hasNext()) {
			BoardDTO dto =  ir.next();
			System.out.printf("%d\t%-30s  %s\t%-10s\t%d\n",
	                  dto.getSeq(), 
	                  dto.getTitle(),
	                  dto.getWriter(),
	                  dto.getWritedate(),
	                  dto.getReaded());   
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\t\t\t [1] 2 3 4 5 6 7 8 9 10 >"); 
		System.out.println("-------------------------------------------------------------------------");
		}
		
		
		
	}

	private void 새글쓰기() {
	    System.out.print("> writer, pwd, email, title, tag, content 입력 ? ");
	    
	    String datas[] = this.sc.nextLine().split("\s*,\s*");
	    String writer = datas[0];
	    String pwd = datas[1];
	    String email = datas[2];
	    String title = datas[3];
		int tag = Integer.parseInt(datas[4]);
		String content = datas[5];
		
		BoardDTO dto = BoardDTO.builder().writer(writer).pwd(pwd).email(email).title(title).tag(tag).content(content).build();
		
		int rowcount = this.service.InsertS(dto);
		if (rowcount==1) {
			System.out.println("새글 쓰기 성공");
		}
		
	
	}

	private void 메뉴선택() {
		System.out.print("> 메뉴 선택하세요 ? ");
	      this.selectedNumber = this.sc.nextInt();
	      sc.nextLine();
	}

	private void 메뉴출력() {
		// TODO Auto-generated method stub
		String menu[] = {"새글","목록","보기","수정","삭제","검색","종료"};
		System.out.println("[ 메뉴 ]");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s\t",i+1 ,menu[i]);
		}
		System.out.println();
	}
	private void 일시정지() {
	      System.out.println(" \t\t 계속하려면 엔터치세요.");
	      try {
	         System.in.read();
	         System.in.skip(System.in.available()); // 13, 10
	      } catch (IOException e) { 
	         e.printStackTrace();
	      }
	   }
	private void exit() {
	      DBConn.close();
	      System.out.println("\t\t\t  프로그램 종료!!!");
	      System.exit(-1);
	   }
	

}