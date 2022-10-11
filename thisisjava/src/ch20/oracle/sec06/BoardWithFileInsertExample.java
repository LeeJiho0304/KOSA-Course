package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//java.sql 에 있는 인터페이스와 클래스 총칭해서 JDBC 라고 함.

public class BoardWithFileInsertExample {

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
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) "
						+ "values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			pstmt.setString(1, "스키");
			pstmt.setString(2, "드디어 스키 시즌이 왔어요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "photo1.jpg");
			pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec06/photo1.jpg"));
			
			int rows = pstmt.executeUpdate();
			System.out.println("실행된 행 수: " + rows);
			
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: " + bno);
					
					String btitle = rs.getString(2);
					System.out.println("저장된 btitle: " + btitle);
				}
				rs.close();
			}
			
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
