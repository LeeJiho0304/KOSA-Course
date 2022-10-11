package ch20.oracle.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//java.sql 에 있는 인터페이스와 클래스 총칭해서 JDBC 라고 함.

public class BoardUpdateExample {

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
			String sql = new StringBuilder()
					.append("update boards set ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("where bno=?")
					.toString();
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "비가 내려요");
			pstmt.setString(2, "겨울비는 추워요.");
			pstmt.setString(3, "photo2.jpg");
			pstmt.setBlob(4, new FileInputStream("src/ch20/oracle/sec07/photo2.jpg"));
			pstmt.setInt(5, 8);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수: " + rows);
			
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

}
