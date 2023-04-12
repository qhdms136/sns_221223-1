package com.sns.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.user.dao.UserMapper;
import com.sns.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByLoginId(String loginId) {
		return userMapper.selectUserByLoginId(loginId);
	}
}
