package project;


import java.sql.*;


public class connect {
	public static void main(String[] args) {
		
		String dbuser = "c##bituser";
		String dbpass = "bituser";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DBConfig.DBURL,	
					dbuser,
					dbpass);
			
			System.out.println(conn);
			System.out.println("연결 성공!");
		}catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			System.err.println("SQLError!");
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
				
	}
}
