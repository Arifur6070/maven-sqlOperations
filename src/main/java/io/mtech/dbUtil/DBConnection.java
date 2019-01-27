package io.mtech.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnection {
	private static Connection conn;
	
	static Logger log = Logger.getLogger(DBOperation.class.getName());

	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://VNTDACWSSQLD002:1433;databaseName=DEV_TEST;user=dev_test_dbo;password=dev_test_dbo123;");
			log.info("connection created.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public static void closeAll(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				//log.error("The result set cannot be closed.", e);
				
				System.out.println(e.getMessage());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				//log.error("The statement cannot be closed.", e);
				
				System.out.println(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				//log.error("The data source connection cannot be closed.", e);
				
				System.out.println(e.getMessage());
			}
		}
	}
}
