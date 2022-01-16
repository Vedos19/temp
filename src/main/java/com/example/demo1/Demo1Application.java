package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Demo1Application {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
		public void run(String... args) throws Exception {
			String sql = "INSERT INTO users (email, password) VALUES (?,?)";
			int result = jdbcTemplate.update(sql, "MarcelinaSzotowska@gmail.com", "Cycek123");

			if (result > 0) {
				System.out.println("A new row has been instered");
			}
		}
}
