package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Board;
/*
drop table if exists board;
CREATE TABLE board (
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
mydate datetime DEFAULT CURRENT_TIMESTAMP,
login_id varchar(100) NOT NULL,
contents varchar(100) NOT NULL,
likes int NOT NULL DEFAULT '0'
);
+----+---------------------+----------+----------+-------+----------+
| id | mydate              | login_id | contents | likes | dislikes |
+----+---------------------+----------+----------+-------+----------+
|  1 | 2025-02-19 19:31:21 | ayukawa  | aaaa     |     2 |        2 |
|  2 | 2025-02-19 19:31:25 | ayukawa  | aaaa     |     0 |        3 |
|  4 | 2025-02-19 19:31:57 | samejima | aaaaaaa  |     0 |        0 |
+----+---------------------+----------+----------+-------+----------+
 */

public class BoardDAO extends DAO {
	//全件取得
	public List<Board> findAll() throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by mydate DESC;";		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginId = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//login_idによる絞り込みをして検索　アカウントページ取得用
	public List<Board> findbyLoginId(String loginId) throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board where login_id = ? order by mydate DESC;";		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}	
	//boardIdで検索　いいね用
	public Board findByBoardId(int boardId) throws Exception{
		Board board = null;
		String sql = "select * from board where id = ?;";		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginId = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			board = new Board(boardId,mydate,loginId,contents,likes);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return board;
	}	
	//ポスト追加
	public int save(Board board) throws Exception{
		int result= 0;
		String sql = "insert into board(login_id,contents) values(?,?);";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,board.getLoginId());
		pstmt.setString(2, board.getContents());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	//ポストしたあとそのポストの情報を取得 jsonに埋め込むため
	public Board findByLoginIdAndContents(String loginId,String contents) throws Exception{
		Board board = null;
		String sql = "select * from board where binary login_id = ? and contents = ? order by mydate DESC;";		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		pstmt.setString(2, contents);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			int likes = rs.getInt("likes");
			board = new Board(id,mydate,loginId,contents,likes);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return board;
	}	
	//特定の1行削除
	public int clearById(int id) throws Exception{
		int result= 0;
		String sql = "delete from board where id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}	
	//loginIdを指定して複数削除
	public int clearByLoginId(Board board) throws Exception{
		int result= 0;
		String sql = "delete from board where login_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,board.getLoginId());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;					
	}
	//likes +1
	public int CountUpLike(int id) throws Exception{
		int result = 0;
		String sql = "update board set likes = likes + 1 where id = ?;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	//likes -1
	public int CountDownLike(int id) throws Exception{
		int result = 0;
		String sql = "update board set likes = likes - 1 where id = ?;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	//新しい順でソート
	public List<Board> sortByDateNew() throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by mydate DESC;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginId = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//古い順でソート
	public List<Board> sortByDateOld() throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by mydate ASC;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginId = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//likesでソート(全員分)
	public List<Board> sortByLikes() throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board order by likes DESC;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginId = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//likesでソート(その人のだけ)
	public List<Board> sortByLikesOfLoginId(String loginId) throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board  where login_id = ? order by likes DESC;";	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginId,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	//自分がいいねしたリスト一覧
	public List<Board> findMyLikeList(String loginId) throws Exception{
		List<Board> list = new ArrayList<>();
		String sql = "select * from board where id in (select board_id from likes where login_id = ?) order by mydate DESC;";		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			java.sql.Timestamp sqldate = rs.getTimestamp("mydate");
			java.util.Date mydate = new java.util.Date(sqldate.getTime());
			String loginIdOfBoard = rs.getString("login_id");
			String contents = rs.getString("contents");
			int likes = rs.getInt("likes");
			Board board = new Board(id,mydate,loginIdOfBoard,contents,likes);
			list.add(board);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
