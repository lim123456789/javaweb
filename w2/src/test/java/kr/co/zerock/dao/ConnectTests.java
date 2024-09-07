package kr.co.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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
	
	@Test
	public void testHikariCP() throws Exception {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb?serverTimezone=Asia/Seoul");
		config.setUsername("WEBUSER");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		HikariDataSource ds = new HikariDataSource(config);
		Connection connection = ds.getConnection();
		
		System.out.println(connection);
		
		connection.close();
		ds.close();
	}
	
}
