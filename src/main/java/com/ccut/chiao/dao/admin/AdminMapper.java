package com.ccut.chiao.dao.admin;

import com.ccut.chiao.entity.Admin;
import org.apache.ibatis.annotations.Param;


/**
 * @author Chiao
 */
public interface AdminMapper {

	Admin getLoginAdmin(@Param("userName") String userName);

	int updatePassword(@Param("passWord") String passWord, @Param("userName") String userName);

}
