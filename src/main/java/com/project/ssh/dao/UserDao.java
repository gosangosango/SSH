package com.project.ssh.dao;


import com.project.ssh.domain.User;

public interface UserDao {
	
	boolean createUser(User user); // 사용자가입

	boolean updateUser(User user); // 사용자정보 수정

	User retrieveUser(String userId); // 사용자 찾기

	boolean deleteUser(String userid); // 사용자 삭제



}
