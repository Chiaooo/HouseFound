package com.ccut.chiao.service.admin;

import com.ccut.chiao.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chiao
 */
public interface AdminService {
	Admin adminLogin(String username, String password);

	int updatePassword(@Param("password") String password, @Param("username") String username);
}
