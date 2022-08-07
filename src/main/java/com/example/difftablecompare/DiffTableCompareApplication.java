package com.example.difftablecompare;

import com.example.difftablecompare.ldao.Table1Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DiffTableCompareApplication {

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
       // Database left_db = databaseStructureLoader.loadDatabase(new DBConnectionConfig("mysql", "localhost", "3306", "root", "root1234", "test"));
      //  Database rigth_db = databaseStructureLoader.loadDatabase(new DBConnectionConfig("mysql", "localhost", "3306", "root", "root1234", "sys"));

        Table1Dao table1Dao = new Table1Dao();
        table1Dao.findMinAndMaxId1();
        System.out.println(String.format("加载表结构数据成功.... 耗时:%s ms",System.currentTimeMillis() - start));
        //加载db结构
        start = System.currentTimeMillis();
        System.out.println(String.format("比对数据库结构成功! 耗时:%s ms",System.currentTimeMillis() - start));

    }

}
