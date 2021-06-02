package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDAOlmpl implements PhoneBookDAO {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,
					"C##bituser",
					"bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		
		return conn;
	}

	@Override
	public List<PhoneBookVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<PhoneBookVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel FROM phone_book";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
		return list;
	}

	@Override
	public List<PhoneBookVO> search(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneBookVO> list = new ArrayList<>();
		
		String sql = "SELECT id, name, hp, tel FROM phone_book " + 
							" WHERE name LIKE ?";
		
		try {
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");
				
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return list;
	}

	@Override
	public PhoneBookVO get(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		PhoneBookVO vo = null;
		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				Long Id = rs.getLong(1);
				String Name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				vo = new PhoneBookVO(Id, Name, hp, tel);
		}
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	return vo;
	}
	@Override
	public boolean insert(PhoneBookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO phone_book VALUES(SEQ_PHONE_BOOK_PK.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				
			}
		}
		return 1 == deletedCount;
	}

	@Override
	public boolean update(PhoneBookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "UPDATE phone_book SET id=? WHERE tel=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getId());
			pstmt.setString(2, vo.getTel());
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
		return 1 == updatedCount;

	}
}
