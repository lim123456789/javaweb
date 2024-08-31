package ko.co.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Test;

public class ConnectTests {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=Asia/Seoul";
	static String user ="WEBUSER";   // 계정 이름 - 책에선 webuser,WEBUSER
	static String pass = "1234";  // 계정 비밀번호 - 책에선 webuser
	
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		Assert.assertNotNull(connection);  // org.junit.Assert;
		connection.close();
	}
}
