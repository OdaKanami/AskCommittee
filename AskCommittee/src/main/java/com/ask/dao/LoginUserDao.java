package com.ask.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ask.entity.LoginUser;

@Repository
public class LoginUserDao {
	
	@Autowired
	EntityManager em;

	public LoginUser findUser(String userName) {
		String query = "";
		query += "SELECT * ";
		query += "FROM Ask_member ";
		query += "WHERE email = :userName ";
		
		//EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
		return (LoginUser)em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName)
				.getSingleResult();
	}

}