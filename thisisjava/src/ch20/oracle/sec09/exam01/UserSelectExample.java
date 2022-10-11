package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//java.sql 에 있는 인터페이스와 클래스 총칭해서 JDBC 라고 함.

public class UserSelectExample {

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
			String sql = "select userid, username, userpassword, userage, useremail from users where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "fall");
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				/* 변수로 컬럼을 읽어옴
				String userId = rs.getString("userid");
				String userName = rs.getString("username");
				String userPassword = rs.getString("userpassword");
				int userAge = rs.getInt(4);
				String userEmail = rs.getString("useremail");
				printUser(userId, userName, userPassword, userAge, userEmail);
				*/
				
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString("useremail"));
				
				printUser(user);
				
			} else {
				System.out.println("사용자 아이디가 존재하지 않음.");
			}
			
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
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
	
	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		System.out.println("userId: " + userId);
		System.out.println("userName: " + userName);
		System.out.println("userPassword: " + userPassword);
		System.out.println("userAge: " + userAge);
		System.out.println("userEmail: " + userEmail);
	}
	
	public static void printUser(User user) {
//		System.out.println("userId: " + user.getUserId());
//		System.out.println("userName: " + user.getUserName());
//		System.out.println("userPassword: " + user.getUserPassword());
//		System.out.println("userAge: " + user.getUserAge());
//		System.out.println("userEmail: " + user.getUserEmail());
		System.out.println(user);
	}

}
