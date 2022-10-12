package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 를 메모리로 로딩하고 Driver Management에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB 연결
			//연결 성공하면 Connection 구현 객체 리턴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "java", "oracle");
			System.out.println("연결 성공");
			
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			String sql1 = "update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1 = pstmt1.executeUpdate();
			if(rows1 == 0) throw new Exception("출금되지 않았음");
			pstmt1.close();
			
			String sql2 = "update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2223");
			int rows2 = pstmt2.executeUpdate();
			if(rows2 == 0) throw new Exception("압금되지 않았음");
			pstmt2.close();
			
			conn.commit();
			System.out.println("계좌 이체 성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("계좌 이체 실패");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			//DB 연결 끊기
			if(conn != null) {
				try {
					//원래대로 자도 커밋 기능 켜기
					conn.setAutoCommit(true);
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
