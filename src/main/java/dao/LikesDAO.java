package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import bean.Like;

public class LikesDAO extends DAO{
/*
	drop table if exists likes;
	create table likes(
	    board_id int not null,
	    login_id varchar(100) not null
	)
*/
	//検索
	public boolean search(int boardId,String loginId) throws Exception{
		boolean result = false;
		String sql = "select * from likes where board_id = ? and binary login_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardId);
		pstmt.setString(2, loginId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}
	//追加
	public int save(int boardId,String loginId) throws Exception{
		int result = 0;
		String sql = "insert into likes(board_id,login_id) values(?,?);";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardId);
		pstmt.setString(2, loginId);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;
	}
	//削除
	public int delete(int boardId,String loginId) throws Exception{
		int result = 0;
		String sql = "delete from likes where board_id = ? and binary login_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardId);
		pstmt.setString(2, loginId);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;		
	}
	//login_idで検索
	public List<Like> findByLoginId(String loginId) throws Exception{
		List<Like> list = new ArrayList<Like>();
		String sql = "select * from likes where binary login_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Like like = new Like();
			like.setId(rs.getInt("board_id"));
			like.setLoginId(loginId);
			list.add(like);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//board_idで検索
	public List<Customer> findByBoardId(int boardId) throws Exception{
		List<Customer> list = new ArrayList<>();
		String sql = "select * from likes where binary board_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setLoginId(rs.getString("login_Id"));
			list.add(customer);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}