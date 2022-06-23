package com.ccut.chiao.controller;

import com.ccut.chiao.dao.admin.AdminMapper;
import com.ccut.chiao.entity.Admin;
import com.ccut.chiao.service.admin.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {


	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminMapper adminMapper;

	public AdminService getAdminService() {
		return adminService;
	}


	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String doLogin(@Param("userName") String userName, @Param("passWord") String passWord, Model model, HttpSession session) {
		Admin admin = adminService.adminLogin(userName, passWord);

		if (null != admin) {
			session.setAttribute("userSession", admin);
			return "index";
		} else {
			model.addAttribute("error", "用户名或密码不正确");
			return "login";
		}
	}

	@RequestMapping("/updatePwd")
	public String updatePwd(@Param("passWord") String passWord, @Param("oldPwd") String oldPwd, @Param("userName") String userName, Model model) {
		Admin admin = adminMapper.getLoginAdmin(userName);
		if (!admin.getPassWord().equals(oldPwd)) {
			System.out.println(admin.getPassWord() + "->" + oldPwd);
			model.addAttribute("msg", "旧密码不正确");
			return "updatePassword";
		} else {
			adminService.updatePassword(passWord, userName);
			return "";
		}
	}

	@RequestMapping("toUpdatePwd")
	public String toUpdatePwd() {
		return "updatePassword";
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("userSession");
		return "login";
	}

}
