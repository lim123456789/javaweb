package kr.co.zerock.sample;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testService1() {
		log.info(sampleService);
		Assertions.assertNotNull(sampleService);
	}
	
	@Test
	public void testConnection() throws Exception {
		Connection connection = dataSource.getConnection();
		log.info(connection);
		Assertions.assertNotNull(connection);
		
		connection.close();
	}
}
