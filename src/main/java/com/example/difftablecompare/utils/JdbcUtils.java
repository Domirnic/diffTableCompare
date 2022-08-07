package com.example.difftablecompare.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUtils.class);



	private static JdbcUtils jdbcUtils;
	private static Properties properties;
	private JdbcUtils(){
		String configFile="conf/dbconfig.properties"; // 数据库配置文件
		properties = new Properties();
		InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream(configFile);
		try{
			properties.load(is);
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static JdbcUtils getInstance(){

		if(jdbcUtils == null){
			jdbcUtils=new JdbcUtils();
		}
		return jdbcUtils;
	}

	// 通过配置文件Key的名称获取到Key的值。
	public String getString(String key){
		return properties.getProperty(key);
	}

}
