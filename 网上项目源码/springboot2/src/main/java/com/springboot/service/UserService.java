package com.springboot.service;

import com.springboot.bean.User;

public interface UserService {

	/**
	 * 保存用户对象
	 * @param user
	 */
	void save(User user);

}
