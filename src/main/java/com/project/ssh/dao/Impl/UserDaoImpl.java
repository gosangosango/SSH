package com.project.ssh.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.ssh.dao.UserDao;
import com.project.ssh.dao.mybatis.QuickMatchSessionFactory;
import com.project.ssh.domain.User;
@Repository
public class UserDaoImpl implements UserDao {

	private QuickMatchSessionFactory factory;
	
	public UserDaoImpl() {
		factory = QuickMatchSessionFactory.getInstance();
	}
	
	@Override
	public boolean createUser(User user) {
		SqlSession session = factory.getSession();
		
		int cnt = 0;
		try{
				cnt = session.insert("registUser", user);
				session.commit();
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
		return cnt > 0;
	}

	@Override
	public boolean updateUser(User user) {
		SqlSession session = factory.getSession();
		int cnt = 0;
		try{
				cnt = session.update("updateUser", user);
				session.commit();
		}catch(Exception e){
			return false;
		}finally {
			session.close();
		}
		
		return cnt > 0;
	}

	@Override
	public User retrieveUser(String userId) {
		SqlSession session = factory.getSession();
		
		try{
			User user = session.selectOne("retrieveUser", userId);
			return user;
		}catch(Exception e){
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean deleteUser(String userId) {
		SqlSession session = factory.getSession();
		int cnt = 0;
		try{
			if((retrieveUser(userId).getUserId()).equals(userId)){
				cnt = session.delete("deleteUser", userId);
				session.commit();
			}
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
		return cnt > 0;
	}

	

}
