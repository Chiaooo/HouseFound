package com.ccut.chiao.service.admin;

import com.ccut.chiao.dao.admin.AdminMapper;
import com.ccut.chiao.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chiao
 */
public class AdminServiceImpl implements AdminService {

	private AdminMapper adminMapper;

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public Admin adminLogin(@Param("userName") String userName, @Param("passWord") String passWord) {
		Admin admin = null;
		admin = adminMapper.getLoginAdmin(userName);
		if (null != admin) {
			if (!admin.getPassWord().equals(passWord)) {
				admin = null;
			}
		}
		return admin;
	}

	@Override
	public int updatePassword(@Param("passWord") String passWord, @Param("userName") String userName) {
		return adminMapper.updatePassword(passWord, userName);
	}
}
