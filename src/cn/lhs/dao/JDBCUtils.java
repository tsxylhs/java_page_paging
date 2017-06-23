package cn.lhs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * @author lhs
 *连接数据库
 */
public class JDBCUtils {
  private Connection conn=null;
  private PreparedStatement pstmt=null;
  public Connection connect(){
	  String user="root";
	  String password="123321";
	  String driverClass="com.mysql.jdbc.Driver";
	  String jdbcUrl="jdbc:mysql://localhost:3306/Student";
	  try {
		Class.forName(driverClass);
		conn=DriverManager.getConnection(jdbcUrl,user,password);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  return conn;
  }
  /**
   * close关闭数据库
   * 
   */
	public void close(Connection conn ,PreparedStatement pstmt,ResultSet  result){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result!=null){
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
