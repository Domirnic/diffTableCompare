package com.example.difftablecompare.ldao;

import com.example.difftablecompare.utils.CloseUtils;
import com.example.difftablecompare.utils.DatabaseUtils;
import com.example.difftablecompare.utils.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table2Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Table2Dao.class);

	static String tableName1 = JdbcUtils.getInstance().getString("jdbc.tableName1");
	static String index1 = JdbcUtils.getInstance().getString("jdbc.index1");
	static String column1 = JdbcUtils.getInstance().getString("jdbc.column1");
    @Autowired
	public DatabaseUtils databaseUtils = new DatabaseUtils();
	public List<Map<String,Object>> findById2(Object obj) {
		List<Map<String,Object>> resultList=new ArrayList<>();

		String index[] = index1.split(",");
		String column[] = column1.split(",");
		StringBuffer tableSql= new StringBuffer("select ");
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		try {
			// 1、加载驱动
			Connection conn= databaseUtils.getConnection1();
			for (int i=0;i<column.length;i++) {
				tableSql.append(column[i]);
				tableSql.append(",");
			}
			tableSql.deleteCharAt(tableSql.lastIndexOf(","));
			tableSql.append(" from ").append(tableName1).append(" where ").append( index[0] ).append("= ?");

			//在建立了连接的基础上对数据库进行操作
			System.out.println(tableSql.toString());

			preparedStatement = conn.prepareStatement(tableSql.toString());

				//preparedStatement.setString(column.length+1, tableName1);
				preparedStatement.setObject(1, obj);
				//System.out.println(preparedStatement.getParameterMetaData().getParameterClassName(0));

			resultSet = preparedStatement.executeQuery();

			//遍历结果
			while (resultSet.next()){
				Map<String,Object> resultMap= new HashMap<>();
				for (int i=0;i<column.length;i++) {
					resultMap.put(column[i],resultSet.getObject(column[i]));
					System.out.println(resultSet.getObject(column[i]));
				}
				resultList.add(resultMap);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			CloseUtils.close(resultSet);
			CloseUtils.close(preparedStatement);
		}
		return resultList;
	}

	public List<Map<String,Object>> findMinAndMaxId2() {
		List<Map<String,Object>> resultList=new ArrayList<>();

		String index[] = index1.split(",");
		String column[] = column1.split(",");
		StringBuffer tableSql= new StringBuffer("select ");
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		try {
			// 1、加载驱动
			Connection conn= databaseUtils.getConnection1();
			tableSql.append("min(").append(index[0]).append(") minId,");
			tableSql.append("max(").append(index[0]);
			tableSql.append(") maxId  from ").append(tableName1);

			//在建立了连接的基础上对数据库进行操作
			System.out.println(tableSql.toString());

			preparedStatement = conn.prepareStatement(tableSql.toString());

			//preparedStatement.setString(column.length+1, tableName1);
			//System.out.println(preparedStatement.getParameterMetaData().getParameterClassName(0));

			resultSet = preparedStatement.executeQuery();

			//遍历结果
			while (resultSet.next()){
				Map<String,Object> resultMap= new HashMap<>();
					resultMap.put("minId",resultSet.getObject("minId"));
					resultMap.put("maxId",resultSet.getObject("maxId"));
				System.out.println(resultSet.getObject("minId"));
				System.out.println(resultSet.getObject("maxId"));
				resultList.add(resultMap);
			}

	} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			CloseUtils.close(resultSet);
			CloseUtils.close(preparedStatement);
		}
		return resultList;
	}



	public List<Map<String,Object>> findBetweenId2s(Object obj1,Object obj2) {
		List<Map<String,Object>> resultList=new ArrayList<>();

		String index[] = index1.split(",");
		String column[] = column1.split(",");
		StringBuffer tableSql= new StringBuffer("select ");
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		try {
			// 1、加载驱动
			Connection conn= databaseUtils.getConnection1();
			for (int i=0;i<column.length;i++) {
				tableSql.append(column[i]);
				tableSql.append(",");
			}
			tableSql.deleteCharAt(tableSql.lastIndexOf(","));
			tableSql.append(" from ").append(tableName1).append(" where ").append( index[0] )
					.append(" between ").append(" ? and ?");
			//在建立了连接的基础上对数据库进行操作
			System.out.println(tableSql.toString());

			preparedStatement = conn.prepareStatement(tableSql.toString());

			//preparedStatement.setString(column.length+1, tableName1);
			preparedStatement.setObject(1, obj1);
			preparedStatement.setObject(2, obj2);
			//System.out.println(preparedStatement.getParameterMetaData().getParameterClassName(0));

			resultSet = preparedStatement.executeQuery();

			//遍历结果
			while (resultSet.next()){
				Map<String,Object> resultMap= new HashMap<>();
				for (int i=0;i<column.length;i++) {
					resultMap.put(column[i],resultSet.getObject(column[i]));
					System.out.println(resultSet.getObject(column[i]));
				}
				resultList.add(resultMap);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			CloseUtils.close(resultSet);
			CloseUtils.close(preparedStatement);
		}
		return resultList;

	}
}
