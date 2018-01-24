package com.project.ssh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.ssh.domain.User;

public interface UserService {
	boolean registUser(User user); // 사용자가입

	boolean modifyUser(User user); // 사용자 정보수정

	User findUser(String userId); // 사용자 정보 조회

	boolean removeUser(String userId); // 사용자 탈퇴


	boolean login(String userId, String password); // 로그인


	
	
	
	public User checkLogin(HttpServletRequest req);
}
