package com.xk.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = null;
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sqlSessionFactory;
		
	}
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	public static SqlSession getSqlSession(boolean autoCommit) throws IOException{
		return getSqlSessionFactory().openSession(autoCommit);
	}
}
