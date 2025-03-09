package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bean.Customer;
/*
 
 create table customer (
	id integer primary key auto_increment,
	login_id varchar(100) not null unique,
	password varchar(100) not null
);

insert into customer values(null, 'ayukawa','SweetfishRevier1');
insert into customer values(null, 'samejima','SharkIsaland2');
insert into customer values(null, 'wanibuchi','CrocodileChasm3');
insert into customer values(null, 'ebihara','ShrimpField4');
insert into customer values(null, 'kanie','CrubBay5');
insert into customer values(null, 'admin','Administrator35');
+----+-----------+------------------+
| id | login_id  | password         |
+----+-----------+------------------+
|  1 | ayukawa   | SweetfishRevier1 |
|  2 | samejima  | SharkIsland2    |
|  3 | wanibuchi | CrocodileChasm3  |
|  4 | ebihara   | ShrimpField4     |
|  5 | kanie     | CrubBay5         |
|  6 | admin     | Administrator35  |
+----+-----------+------------------+

drop table if exists customer;
 create table customer (
	id integer primary key auto_increment,
	login_id varchar(100) not null unique,
	password varchar(100) not null,
    role varchar(16) NOT NULL DEFAULT 'GENERAL'
);

INSERT INTO `customer`
VALUES (1,'ayukawa','SweetfishRevier1','GENERAL'),
(2,'samejima','SharkIsland2','GENERAL'),
(3,'wanibuchi','CrocodileChasm3','GENERAL'),
(4,'ebihara','ShrimpField4','GENERAL'),
(5,'kanie','CrubBay5','GENERAL'),
(6,'admin','AdminCarp6','ADMIN');

+----+-----------+------------------+---------+
| id | login_id  | password         | role    |
+----+-----------+------------------+---------+
|  1 | ayukawa   | SweetfishRevier1 | GENERAL |
|  2 | samejima  | SharkIsland2     | GENERAL |
|  3 | wanibuchi | CrocodileChasm3  | GENERAL |
|  4 | ebihara   | ShrimpField4     | GENERAL |
|  5 | kanie     | CrubBay5         | GENERAL |
|  6 | admin     | AdminCarp6       | ADMIN   |
+----+-----------+------------------+---------+
 */

public class CustomerDAO extends DAO{
	//検索(login_id and password)
	public Optional<Customer> search(String loginId,String password) throws Exception{
		Customer customer = null;
		String sql = "select * from customer where binary login_id = ? and binary password = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,loginId);
		pstmt.setString(2,password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLoginId(rs.getString("login_id"));
			customer.setPassword(rs.getString("password"));
			customer.setRole(rs.getString("role"));
		}	
		rs.close();
		pstmt.close();
		conn.close();		
		return Optional.ofNullable(customer);
	}

	//登録
	public boolean register(String loginId, String password, String role) throws Exception{		
		int result = 0;
		
		String sql = "select * from customer where binary login_id = ?;";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,loginId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return false;
		}
		sql = "insert into customer(login_id,password,role) values(?,?,?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,loginId);
		pstmt.setString(2,password);
		pstmt.setString(3,role);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return true;
	}
	
	//パスワードの更新
	public int updatePassword(String password,Customer customer) throws Exception {
		int result = 0;
		String sql = "update customer set password = ? where binary login_id = ?;";
			
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, customer.getLoginId());
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;
	}
	//全件取得
	public List<Customer> findAll() throws Exception{
		List<Customer> list = new ArrayList<>();
		String sql = "select * from customer;";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String password = rs.getString("password");
			String role = rs.getString("role");
			Customer customer = new Customer(id,loginId,password,role);
			list.add(customer);	
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
}
