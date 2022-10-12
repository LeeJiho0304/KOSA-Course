package ch20.oracle.practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import ch20.oracle.sec09.exam01.User;

public class BoardExample {
	//Filed
	private Scanner sc = new Scanner(System.in);
	private Connection conn;
 	private User loginUser;
	
	//Constructor
	public BoardExample() {
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "java", "oracle");
		} catch(Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
	
	//Method
	public static void main(String[] args) {
		BoardExample boardExample = new BoardExample();
		boardExample.list();
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]" + ((loginUser != null)? ("사용자: " + loginUser.getUserId()) : ""));
		System.out.println("------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		
		//boards 테이블에서 게시물 정보를 가져와서 출력
		try {
			String sql = "select bno, bwriter, bdate, btitle from boards order by bno desc";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBtitle(rs.getString("btitle"));
				
				System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		
		if(loginUser == null) {
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
			System.out.print("메뉴 선택: ");
			String menuNo = sc.nextLine();
			System.out.println();
			
			switch(menuNo) {
				case "1" -> create();
				case "2" -> read();
				case "3" -> clear();
				case "4" -> join();
				case "5" -> login();
				case "6" -> exit();
			}
		} else {
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Logout | 5.Exit");
			System.out.print("메뉴 선택: ");
			String menuNo = sc.nextLine();
			System.out.println();
			
			switch(menuNo) {
				case "1" -> create();
				case "2" -> read();
				case "3" -> clear();
				case "4" -> logout();
				case "5" -> exit();
			}
		}
		
	}

	public void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용: ");
		board.setBcontent(sc.nextLine());
		if(loginUser == null) {
			System.out.print("작성자: ");
			board.setBwriter(sc.nextLine());
		} else {
			board.setBwriter(loginUser.getUserId());
		}
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			try {
				String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate) values (seq_bno.nextval, ?, ?, ?, sysdate)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				
				pstmt.executeUpdate();
				pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		
		list();
	}
	
	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(sc.nextLine());
		
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from boards where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				
				System.out.println("########################");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("########################");
				
				if(loginUser != null && loginUser.getUserId().equals(board.getBwriter())) {
					System.out.println("------------------------------------------------------------------");
					System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
					System.out.print("메뉴 선택: ");
					String menuNo = sc.nextLine();
					System.out.println();
					
					if(menuNo.equals("1")) {
						update(board);
					} else if(menuNo.equals("2")) {
						delete(board);
					}
				}
				
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			exit();
		}
		
		list();
	}
	
	public void update(Board board) {

		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용: ");
		board.setBcontent(sc.nextLine());

		System.out.println("------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			try {
				String sql = "update boards set btitle=?, bcontent=?, bwriter=? where bno=?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				
				pstmt.executeUpdate();
				pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		
		list();
	}
	
	public void delete(Board board) {
		try {
			String sql = "delete from boards where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		
		list();
	}
	
	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			try {
				String sql = "truncate from boards";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.executeUpdate();
				pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		
		list();
	}
	
	public void join() {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.print("아이디: ");
		user.setUserId(sc.nextLine());
		System.out.print("이름: ");
		user.setUserName(sc.nextLine());
		System.out.print("비밀번호: ");
		user.setUserPassword(sc.nextLine());
		System.out.print("나이: ");
		user.setUserAge(Integer.parseInt(sc.nextLine()));
		System.out.print("이메일: ");
		user.setUserEmail(sc.nextLine());

		System.out.println("------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			try {
				String sql = "insert into users (userid, username, userpassword, userage, useremail) "
						+"values (?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getUserPassword());
				pstmt.setInt(4, user.getUserAge());
				pstmt.setString(5, user.getUserEmail());
				
				pstmt.executeUpdate();
				pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		
		list();
	}
	
	public void login() {
		System.out.println("[로그인]");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		System.out.println("------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = sc.nextLine();
		
		if(menuNo.equals("1")) {
			try {
				String sql1 = "{? = call user_login(?, ?)}";
				CallableStatement cstmt = conn.prepareCall(sql1);
				
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setString(2, id);
				cstmt.setString(3, password);
				
				//함수 실행
				cstmt.execute();
				//리턴값 얻기
				int result = cstmt.getInt(1);
				
				cstmt.close();
				
				switch(result) {
					case 0:
						System.out.println("로그인 성공");
						String sql2 = "select userid, username, userpassword, userage, useremail from users where userid=?";
						PreparedStatement pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, id);
						
						ResultSet rs = pstmt.executeQuery();
						
						if(rs.next()) {
							loginUser = new User();
							loginUser.setUserId(rs.getString("userid"));
							loginUser.setUserName(rs.getString("username"));
							loginUser.setUserPassword(rs.getString("userpassword"));
							loginUser.setUserAge(rs.getInt(4));
							loginUser.setUserEmail(rs.getString("useremail"));
						}	
						list();
						break;
						
					case 1:
						System.out.println("비밀번호가 틀립니다. 다시 입력하세요.\n");
						login();
						break;
						
					case 2: 
						System.out.println("아이디가 존재하지 않습니다.\n");
						join();
						break;
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		
		list();
	}
	
	public void logout() {
		loginUser = null;
		list();
	}
	
	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
}
