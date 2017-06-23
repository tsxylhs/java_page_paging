package cn.lhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.lhs.dao.book;
public class UserDao {
	public int getPage(){
		int recordCount=0,t1=0,t2=0;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		JDBCUtils jdbcconnection=new JDBCUtils();
		Connection conn=jdbcconnection.connect();
		String sql="select count(*) from book";
		try {
			pstmt=conn.prepareStatement(sql);
			result=pstmt.executeQuery();
			result.next();
			recordCount=result.getInt(1);
			t1=recordCount%5;
			t2=recordCount/5;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		jdbcconnection.close(conn, pstmt, result);
		}
		
		
	if(t1!=0){
		t2=t2+1;
	}
		return t2;
		
	}
	
	
	/**
	 * 查询指定的页数
	 */
	public List<book> listBook(int pageNo){
		PreparedStatement pstmt=null;
		ResultSet result=null;
		List<book> list=new ArrayList<book>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		JDBCUtils jdbcconnection=new JDBCUtils();
		Connection conn=jdbcconnection.connect();
		String sql="select * from book order by id limit ?,?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			result=pstmt.executeQuery();
			while(result.next()){
				book book=new book();
				  book.setBookID(result.getInt(1));
				 book.setBookName(result.getString(2));
				 book.setAutherName(result.getString(3));
				 list.add(book);
				 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			jdbcconnection.close(conn, pstmt, result);
			
		
		}
		
		return list;
		
	}
	/**
	 * 删除数据
	 */
	
	public  int remove(int id){
		PreparedStatement pstmt=null;

		JDBCUtils jdbcconnection=new JDBCUtils();
		Connection conn=jdbcconnection.connect();
		String sql="delete  from book where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, id);
			int  result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
		
	}

}
