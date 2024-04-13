package freshner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dataBaseDao {
	public String getDate(String serial_no){
		 try {
	  			String url="jdbc:mysql://localhost:3306/showroom";
	  			String uname="root";
	  			String pass="1234";
	  			Class.forName("com.mysql.jdbc.Driver");
	  			Connection con = DriverManager.getConnection(url, uname, pass);
	  			String sql = "select date from register where serial_no = ?";
	  			PreparedStatement st = con.prepareStatement(sql);
	  			st.setString(1, serial_no);
	  			
	  			
	  			
	  			
	  		    ResultSet rs = st.executeQuery();
	  			if(rs.next()) {
	  				return rs.getString("date");
	  			}
	  			
	  			
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		return "";
	}
	
	public boolean renew(String serial_no, String uDate) {
		try {
  			String url="jdbc:mysql://localhost:3306/showroom";
  			String uname="root";
  			String pass="1234";
  			Class.forName("com.mysql.jdbc.Driver");
  			Connection con = DriverManager.getConnection(url, uname, pass);
  			String sql = "UPDATE register SET date = ? WHERE serial_no = ?";
  			PreparedStatement st = con.prepareStatement(sql);
  			st.setString(1, uDate);
  			st.setString(2, serial_no);
  			
  			
  			int result = st.executeUpdate();
  			
  			if(result > 0) {
  				return true;
  			}else {
  				return false;
  			}
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
		
		return false;
	}
	public boolean add(String New_serial_no, String date) {
		try {
  			String url="jdbc:mysql://localhost:3306/showroom";
  			String uname="root";
  			String pass="1234";
  			Class.forName("com.mysql.jdbc.Driver");
  			Connection con = DriverManager.getConnection(url, uname, pass);
  			String sql = "insert into register values(?,?)";
  			PreparedStatement st = con.prepareStatement(sql);
  			st.setString(1, New_serial_no);
  			st.setString(2, date);
  			
  			
  			int result = st.executeUpdate();
  			
  			if(result > 0) {
  				return true;
  			}else {
  				return false;
  			}
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
		
		return false;
	}
	
}
