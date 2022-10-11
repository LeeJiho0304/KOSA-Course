package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//java.sql 에 있는 인터페이스와 클래스 총칭해서 JDBC 라고 함.

public class BoardSelectExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			//JDBC Driver 를 메모리로 로딩하고 Driver Management에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB 연결
			//연결 성공하면 Connection 구현 객체 리턴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "java", "oracle");
			System.out.println("연결 성공");
			
			//매개변수화된 SQL문 작성
			String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "winter");
			
			ResultSet rs = pstmt.executeQuery();
			List<Board> boards = new ArrayList<>();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt(1));
				board.setBtitle(rs.getString(2));
				board.setBcontent(rs.getString(3));
				board.setBwriter(rs.getString(4));
				board.setBdate(rs.getDate(5));
				board.setBfilename(rs.getString(6));
				board.setBfiledata(rs.getBlob(7));
				
				Blob blob = board.getBfiledata();
				if(blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:/Temp/" + board.getBfilename());
					
					is.transferTo(os);
					os.flush();
					is.close();
					os.close();
				}
				
				//List Collection에 Board 객체 추가
				boards.add(board);
			}
			printBoards(boards);
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB 연결 끊기
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void printBoards(List<Board> boards) {
		//내부 반복자
		boards.stream()
			.forEach(b -> System.out.println(b));
		
		//향상된 for문
//		for(Board board : boards) {
//			System.out.println(board);
//		}
	}


}
