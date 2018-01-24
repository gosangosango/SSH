package com.project.ssh.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class QuickMatchSessionFactory {
	
	private static QuickMatchSessionFactory instance;
	private static SqlSessionFactory sqlSessionFactory;
	private final String resource = "mybatis-config.xml";
	
	private QuickMatchSessionFactory(){}
	
	public static QuickMatchSessionFactory getInstance(){
		if(instance == null){
			instance = new QuickMatchSessionFactory();
		}
		
		return instance;
	}
	
	public SqlSession getSession(){
		if(sqlSessionFactory == null){
			Reader reader = null;
			try{
				reader = Resources.getResourceAsReader(resource);
			}catch(IOException e){
				e.printStackTrace();
			}
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		
		return sqlSessionFactory.openSession(true);
	}

}
