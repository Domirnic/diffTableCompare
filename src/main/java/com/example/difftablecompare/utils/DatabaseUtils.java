package com.example.difftablecompare.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DatabaseUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseUtils.class);

	static String driverName1 = JdbcUtils.getInstance().getString("jdbc.driver1");

	static String url1 = JdbcUtils.getInstance().getString("jdbc.url1");

	static String username1 = JdbcUtils.getInstance().getString("jdbc.username1");

	static String password1 = JdbcUtils.getInstance().getString("jdbc.password1");
	static String tableName1 = JdbcUtils.getInstance().getString("jdbc.tableName1");
	static String index1 = JdbcUtils.getInstance().getString("jdbc.index1");


	static String driverName2 = JdbcUtils.getInstance().getString("jdbc.driver2");

	static String url2 = JdbcUtils.getInstance().getString("jdbc.url2");

	static String username2 = JdbcUtils.getInstance().getString("jdbc.username2");

	static String password2 = JdbcUtils.getInstance().getString("jdbc.password2");
	static String tableName2 = JdbcUtils.getInstance().getString("jdbc.tableName2");
	static String index2 = JdbcUtils.getInstance().getString("jdbc.index2");

	public Connection getConnection1() {
		Connection conn=null;
		try {
			// 1、加载驱动
			Class.forName(driverName1);
			// 2、获取connection
			 conn = DriverManager.getConnection(url1, username1, password1);

		} catch (ClassNotFoundException | SQLException e) {


			e.printStackTrace();
		}
		return  conn;
	}
		public Connection getConnection2() {
			Connection conn=null;
			try {
				// 1、加载驱动
				Class.forName(driverName2);
				// 2、获取connection
				 conn = DriverManager.getConnection(url2, username2, password2);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}

}
